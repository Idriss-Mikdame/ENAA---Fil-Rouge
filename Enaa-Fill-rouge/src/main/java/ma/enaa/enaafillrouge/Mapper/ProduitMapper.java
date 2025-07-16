package ma.enaa.enaafillrouge.Mapper;

import jakarta.persistence.ManyToOne;
import ma.enaa.enaafillrouge.Dto.ProduitDto;
import ma.enaa.enaafillrouge.Entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
        @Mapping(source = "category.id", target = "categoryid")
        ProduitDto toDto(Produit produit);
        @Mapping(source = "categoryid", target = "category.id")
        Produit toEntity(ProduitDto produitDto);

}
