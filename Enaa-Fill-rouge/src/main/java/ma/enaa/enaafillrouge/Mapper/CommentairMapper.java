package ma.enaa.enaafillrouge.Mapper;

import ma.enaa.enaafillrouge.Dto.CommandeDto;
import ma.enaa.enaafillrouge.Dto.CommentairDto;
import ma.enaa.enaafillrouge.Dto.PanierDto;
import ma.enaa.enaafillrouge.Entity.Client;
import ma.enaa.enaafillrouge.Entity.Commande;
import ma.enaa.enaafillrouge.Entity.Commentair;
import ma.enaa.enaafillrouge.Entity.Panier;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommentairMapper {
    @Mapping(source = "client.id", target = "client_id")
    @Mapping(source = "produit.id", target = "produitId")
    CommentairDto toDto(Commentair commentair);
    @Mapping(target = "client", ignore = true )
    @Mapping(target = "produit.id", source = "produitId")
    Commentair toEntity(CommentairDto commentairDto);

    @AfterMapping
    default void setClient(CommentairDto dto, @MappingTarget Commentair commentair) {
        Client client = new Client();
        client.setId(dto.getClient_id());
        commentair.setClient(client);
    }
}
