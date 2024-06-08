package shop_project.shop_back_end.web.dto.supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {

    //DEFAULT
    private String itemType;
    private String name;
    private int price;
    private int stockQuantity;

    //BOOK
    private String author;
    private String isbn;

    //CLOTHES
    private String fabric;

    //FOOD
    private String foodType;

}
