package ma.enaa.enaafillrouge.controller;

import ma.enaa.enaafillrouge.Dto.CategoryDto;
import ma.enaa.enaafillrouge.Service.CategoryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping
    public CategoryDto AddCategory(@RequestBody CategoryDto categoryDto){
        return categoryServices.AjouterCategory(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> ListCategory(){
        return categoryServices.AfficherCategory();
    }

    @PutMapping("{id}")
    public CategoryDto UpdatCategory(@PathVariable Long id,@RequestBody CategoryDto categoryDto){
        return  categoryServices.ModifierCategory(id,categoryDto);
    }

    @DeleteMapping("{id}")
    public void DeleteCategory(@PathVariable Long id){
        categoryServices.SupprimerCategory(id);
    }
    @GetMapping("{id}")
    public  CategoryDto AfficherParid(@PathVariable  Long id){
        return categoryServices.AfficherParid(id);
    }
}
