package ma.enaa.enaafillrouge.controller;

import ma.enaa.enaafillrouge.Dto.PanierDto;
import ma.enaa.enaafillrouge.Service.PanierServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/panier")
public class PanierController {
    private final PanierServices panierServices;

    public PanierController(PanierServices panierServices) {
        this.panierServices = panierServices;
    }
    @PostMapping
    public PanierDto Add(@RequestBody PanierDto panierDto){
        return panierServices.AddPanier(panierDto);
    }
    @GetMapping
    public List<PanierDto> afficher(){
        return panierServices.AfficherPanier();
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        panierServices.SupprimerPanier(id);
    }
}
