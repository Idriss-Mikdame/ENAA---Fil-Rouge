package ma.enaa.enaafillrouge.Mapper;

import ma.enaa.enaafillrouge.Dto.PanierDto;
import ma.enaa.enaafillrouge.Entity.Client;
import ma.enaa.enaafillrouge.Entity.Panier;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PanierMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "produit.id", target = "produitId")
    PanierDto toDto(Panier panier);
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "produit.id", source = "produitId")
    Panier toEntity(PanierDto panierDto);

    @AfterMapping
    default void setClient(PanierDto dto, @MappingTarget Panier panier) {
        Client client = new Client();
        client.setId(dto.getClientId());
        panier.setClient(client);
    }
}
