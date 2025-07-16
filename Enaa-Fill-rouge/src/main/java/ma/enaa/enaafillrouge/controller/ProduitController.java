package ma.enaa.enaafillrouge.controller;

import ma.enaa.enaafillrouge.Dto.ProduitDto;
import ma.enaa.enaafillrouge.Service.ProduitServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produit")
public class ProduitController {

        public final ProduitServices produitServices;

    public ProduitController(ProduitServices produitServices) {
        this.produitServices = produitServices;
    }

    @PostMapping
    public ProduitDto AddProduit(@RequestBody ProduitDto produitDto){
        return produitServices.AjouterProduit(produitDto);
    }

    @GetMapping
    public List<ProduitDto> AfficherProduit(){
        return produitServices.AfficherProduit();
    }

    @GetMapping("{id}")
    public ProduitDto AfficherParid(@PathVariable Long id){
            return produitServices.AfficheProduitByid(id);
    }

    @PutMapping("{updateid}")
    public ProduitDto ModifierProduit(@PathVariable Long updateid, @RequestBody ProduitDto produitDto) {
        return produitServices.ModifierProduit(updateid, produitDto);
    }
    @DeleteMapping("{id}")
    public void Supprimer(@PathVariable Long id){
        produitServices.SupprimerProduit(id);
    }
}
