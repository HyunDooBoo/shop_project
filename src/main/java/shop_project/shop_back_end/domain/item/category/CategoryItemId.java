package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CategoryItemId implements Serializable {
    private Long categoryId;
    private Long itemId;
}
