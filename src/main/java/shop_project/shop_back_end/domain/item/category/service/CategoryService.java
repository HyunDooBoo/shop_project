package shop_project.shop_back_end.domain.item.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.category.Category;
import shop_project.shop_back_end.domain.item.category.CategoryItem;
import shop_project.shop_back_end.domain.item.category.repository.CategoryRepository;
import shop_project.shop_back_end.domain.item.service.ItemService;
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

    public Category getCategory(Long categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException(categoryId + "번 카테고리는 없습니다"));
    }

    @Transactional
    public void addItemToCategory(Long categoryId, Item item){
        Category category = getCategory(categoryId);
        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setItem(item);
        categoryItem.setCategory(category);
        category.addCategoryItem(categoryItem);
    }

}
