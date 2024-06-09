package shop_project.shop_back_end.domain.item.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.item.category.Category;
import shop_project.shop_back_end.domain.item.category.repository.CategoryRepository;
import shop_project.shop_back_end.web.dto.category.CategoryDTO;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return category.getId();
    }

}
