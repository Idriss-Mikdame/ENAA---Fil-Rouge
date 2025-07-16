package ma.enaa.enaafillrouge.Service;

import ma.enaa.enaafillrouge.Dto.CategoryDto;
import ma.enaa.enaafillrouge.Entity.Category;
import ma.enaa.enaafillrouge.Mapper.CategoryMapper;
import ma.enaa.enaafillrouge.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

        private final CategoryRepository categoryRepository;
        private final CategoryMapper categoryMapper;

    public CategoryServices(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto AjouterCategory(CategoryDto categoryDto){
        Category category = categoryMapper.toEntity(categoryDto);
        Category AddCategory = categoryRepository.save(category);
        return categoryMapper.toDto(AddCategory);
    }

    public List<CategoryDto> AfficherCategory(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto).toList();
    }

    public CategoryDto ModifierCategory(Long id, CategoryDto categoryDto){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Non trouvé"));
        category.setNom(categoryDto.getNom());
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public void SupprimerCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryDto AfficherParid(Long id){
        return categoryRepository.findById(id).map(categoryMapper::toDto).orElseThrow(()-> new RuntimeException("Non trouvé"));

    }
}
