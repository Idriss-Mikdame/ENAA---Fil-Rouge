package ma.enaa.enaafillrouge.Authentification;

import ma.enaa.enaafillrouge.Configuration.ServiceJWT;
import ma.enaa.enaafillrouge.Entity.Admin;
import ma.enaa.enaafillrouge.Entity.Client;
import ma.enaa.enaafillrouge.Entity.User;
import ma.enaa.enaafillrouge.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static ma.enaa.enaafillrouge.Entity.Role.ADMIN;
import static ma.enaa.enaafillrouge.Entity.Role.CLIENT;

@Service
public class AutehnticateServices {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ServiceJWT jwtService;
    private final AuthenticationManager authenticationManager;

    public AutehnticateServices(UserRepository repository,
                                PasswordEncoder passwordEncoder,
                                ServiceJWT jwtService,
                                AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user;

        switch (request.getRole()) {
            case ADMIN -> user = new Admin();
            case CLIENT -> user = new Client();
            default -> throw new IllegalArgumentException("Invalid role: " + request.getRole());
        }

        user.setNom(request.getNom());
        user.setPrenom(request.getPrenom());
        user.setEmail(request.getEmail());
        user.setMotDePasse(passwordEncoder.encode(request.getMotDePasse()));
        user.setRole(request.getRole());
        user.setDateCreation(request.getDateCreation());
        repository.save(user);

        String jwtToken = jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );

        User user = repository.findByEmail(request.getEmail());
        String jwtToken = jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }
}
