package shop_project.shop_back_end.domain.item.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.category.Category;
import shop_project.shop_back_end.domain.item.category.service.CategoryService;
import shop_project.shop_back_end.domain.item.repository.ItemRepository;
import shop_project.shop_back_end.util.ItemFactory;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;

    @Transactional
    public Long createItem(ItemForm form) {
        Category category = categoryService.getCategory(form.getCategoryId());
        Item item = ItemFactory.createItem(form, category);
        itemRepository.save(item);
        categoryService.addItemToCategory(form.getCategoryId(), item);

        return item.getId();
    }

    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException(itemId + "번 아이템이 없습니다."));
    }

}
