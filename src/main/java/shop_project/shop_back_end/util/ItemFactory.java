package shop_project.shop_back_end.util;

import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.category.Book;
import shop_project.shop_back_end.domain.item.category.Clothes;
import shop_project.shop_back_end.domain.item.category.Food;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;

public class ItemFactory {
    public static Item createItem(ItemForm form) {
        switch (form.getItemType()) {
            case "Clothes":
                return Clothes.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .fabric(form.getFabric())
                        .build();
            case "Book":
                return Book.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .author(form.getAuthor())
                        .isbn(form.getIsbn())
                        .build();
            case "Food":
                return Food.builder()
                        .name(form.getName())
                        .price(form.getPrice())
                        .stockQuantity(form.getStockQuantity())
                        .type(form.getFoodType())
                        .build();
            default:
                throw new IllegalArgumentException("Invalid item type: " + form.getItemType());
        }
    }
}
