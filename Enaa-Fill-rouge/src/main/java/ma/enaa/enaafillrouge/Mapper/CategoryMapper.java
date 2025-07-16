package ma.enaa.enaafillrouge.Mapper;

import ma.enaa.enaafillrouge.Dto.CategoryDto;
import ma.enaa.enaafillrouge.Entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
