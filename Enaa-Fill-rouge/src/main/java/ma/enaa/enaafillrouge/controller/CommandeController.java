package ma.enaa.enaafillrouge.controller;

import ma.enaa.enaafillrouge.Dto.CommandeDto;
import ma.enaa.enaafillrouge.Entity.Commande;
import ma.enaa.enaafillrouge.Service.CommandeServices;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.LabelView;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/commande")
public class CommandeController {
    private final CommandeServices commandeServices;

    public CommandeController(CommandeServices commandeServices) {
        this.commandeServices = commandeServices;
    }
    @PostMapping
    public CommandeDto Add(@RequestBody CommandeDto commandeDto){
        return commandeServices.AjouterCOmmande(commandeDto);
    }
    @GetMapping
    public List<CommandeDto> get(){
        return commandeServices.AfficherCommande();
    }

    @PutMapping("{id}")
    public CommandeDto updat(@PathVariable Long id, @RequestBody CommandeDto commandeDto){
        return commandeServices.ModifierCommande(id,commandeDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        commandeServices.Supprimer(id);
    }
}
