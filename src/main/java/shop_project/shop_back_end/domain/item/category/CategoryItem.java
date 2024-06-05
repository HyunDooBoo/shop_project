package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@Getter
@Setter
public class CategoryItem {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

}
