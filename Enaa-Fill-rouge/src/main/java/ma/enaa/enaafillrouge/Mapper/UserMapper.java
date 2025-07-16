package ma.enaa.enaafillrouge.Mapper;

import ma.enaa.enaafillrouge.Dto.UserDto;
import ma.enaa.enaafillrouge.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

     UserDto toDto(User user);

     User toEntity(UserDto userDto);
}
