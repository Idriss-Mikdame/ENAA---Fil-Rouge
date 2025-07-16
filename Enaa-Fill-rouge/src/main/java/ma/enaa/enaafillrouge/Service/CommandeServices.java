package ma.enaa.enaafillrouge.Service;

import ma.enaa.enaafillrouge.Dto.CommandeDto;
import ma.enaa.enaafillrouge.Entity.Commande;
import ma.enaa.enaafillrouge.Mapper.CommandeMapper;
import ma.enaa.enaafillrouge.Repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServices {

        private final CommandeRepository commandeRepository;
        private final CommandeMapper commandeMapper;

    public CommandeServices(CommandeRepository commandeRepository, CommandeMapper commandeMapper) {
        this.commandeRepository = commandeRepository;
        this.commandeMapper = commandeMapper;
    }

    public CommandeDto AjouterCOmmande(CommandeDto commandeDto){
        Commande commande = commandeMapper.toEntity(commandeDto);
        Commande commande1 = commandeRepository.save(commande);
        return  commandeMapper.toDto(commande1);
    }

    public List<CommandeDto> AfficherCommande(){
        return commandeRepository.findAll().stream()
                .map(commandeMapper::toDto).toList();
    }

    public CommandeDto ModifierCommande(Long id, CommandeDto commandeDto){
        Commande commande = commandeRepository.findById(id).get();
        commande.setDate(commandeDto.getDate());
        commande.setStatus(commandeDto.getStatus());
        commandeDto.setTotal(commandeDto.getTotal());
        return commandeMapper.toDto(commandeRepository.save(commande));
    }

    public void Supprimer(Long id){
        commandeRepository.deleteById(id);
    }
}
