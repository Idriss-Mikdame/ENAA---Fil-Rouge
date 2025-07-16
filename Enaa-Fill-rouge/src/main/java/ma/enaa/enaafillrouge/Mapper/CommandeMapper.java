package ma.enaa.enaafillrouge.Mapper;

import ma.enaa.enaafillrouge.Dto.CommandeDto;
import ma.enaa.enaafillrouge.Dto.PanierDto;
import ma.enaa.enaafillrouge.Entity.Client;
import ma.enaa.enaafillrouge.Entity.Commande;
import ma.enaa.enaafillrouge.Entity.Panier;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    @Mapping(source = "client.id", target = "client_id")
    @Mapping(source = "produit.id", target = "produitId")
    CommandeDto toDto(Commande commande);
    @Mapping(target = "client", ignore = true )
    @Mapping(target = "produit.id", source = "produitId")
    Commande toEntity(CommandeDto commandeDto);
    @AfterMapping
    default void setClient(CommandeDto dto, @MappingTarget Commande commande) {
        Client client = new Client();
        client.setId(dto.getClient_id());
        commande.setClient(client);
    }
}
