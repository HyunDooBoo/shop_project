package shop_project.shop_back_end.util;

import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.category.*;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;

public class ItemFactory {
    public static Item createItem(ItemForm form, Category category) {
        Item item;
        switch (form.getItemType()) {
            case "Clothes":
                item = Clothes.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .fabric(form.getFabric())
                        .category(category)
                        .build();
                return item;
            case "Book":
                item = Book.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .author(form.getAuthor())
                        .isbn(form.getIsbn())
                        .category(category)
                        .build();
                return item;
            case "Food":
                item = Food.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .type(form.getFoodType())
                        .category(category)
                        .build();
                return item;
            default:
                throw new IllegalArgumentException("Invalid item type: " + form.getItemType());
        }
    }
}
