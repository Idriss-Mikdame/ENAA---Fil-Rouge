package ma.enaa.enaafillrouge.Authentification;

public class AuthenticationResponse {
    public AuthenticationResponse(String token) {
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public AuthenticationResponse() {}

}
