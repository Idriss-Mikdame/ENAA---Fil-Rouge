package ma.enaa.enaafillrouge.Service;

import ma.enaa.enaafillrouge.Dto.ProduitDto;
import ma.enaa.enaafillrouge.Entity.Produit;
import ma.enaa.enaafillrouge.Mapper.ProduitMapper;
import ma.enaa.enaafillrouge.Repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServices {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    public ProduitServices(ProduitRepository produitRepository, ProduitMapper produitMapper) {
        this.produitRepository = produitRepository;
        this.produitMapper = produitMapper;
    }
    public ProduitDto AjouterProduit(ProduitDto produitDto){
        Produit produit = produitMapper.toEntity(produitDto);
        Produit addProduit = produitRepository.save(produit);
        return produitMapper.toDto(addProduit);
    }

    public List<ProduitDto> AfficherProduit(){
        return produitRepository.findAll().stream()
                .map(produitMapper::toDto)
                .toList();
    }

    public ProduitDto ModifierProduit(Long id,ProduitDto produitDto){
    Produit produit =produitRepository.findById(id).orElseThrow(()-> new RuntimeException("Non trouvé"));
        produit.setNom(produitDto.getNom());
        produit.setDescription(produitDto.getDescription());
        produit.setPrix(produitDto.getPrix());
        produit.setImage(produitDto.getImage());
        produit.setStock(produitDto.getStock());
        produit.setCouleur(produitDto.getCouleur());
        produit.setTaille(produitDto.getTaille());
        produit.setOptionsSpeciales(produitDto.getOptionsSpeciales());
        return produitMapper.toDto(produitRepository.save(produit));
    }
    public void SupprimerProduit(Long id){
            produitRepository.deleteById(id);
    }

    public ProduitDto AfficheProduitByid(Long id){

        return produitRepository.findById(id).map(produitMapper::toDto).orElse(null);
    }
}
