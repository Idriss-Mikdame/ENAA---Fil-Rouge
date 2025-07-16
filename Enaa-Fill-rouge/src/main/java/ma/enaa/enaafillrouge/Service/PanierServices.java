package ma.enaa.enaafillrouge.Service;

import ma.enaa.enaafillrouge.Dto.PanierDto;
import ma.enaa.enaafillrouge.Entity.Panier;
import ma.enaa.enaafillrouge.Mapper.PanierMapper;
import ma.enaa.enaafillrouge.Repository.PanierRepository;
import ma.enaa.enaafillrouge.Repository.ProduitRepository;
import ma.enaa.enaafillrouge.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServices {
    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper;

    public PanierServices(PanierRepository panierRepository, PanierMapper panierMapper) {
        this.panierRepository = panierRepository;
        this.panierMapper = panierMapper;
    }

    public PanierDto AddPanier(PanierDto panierDto){
        Panier panier = panierMapper.toEntity(panierDto);
        Panier AddPanier = panierRepository.save(panier);
        return panierMapper.toDto(AddPanier);
    }

    public List<PanierDto> AfficherPanier(){
        return panierRepository.findAll().stream()
                .map(panierMapper::toDto).toList();
    }
    public void SupprimerPanier(Long id){
        panierRepository.deleteById(id);
    }
}
