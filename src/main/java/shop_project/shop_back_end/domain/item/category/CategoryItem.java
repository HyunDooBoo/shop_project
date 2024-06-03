package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@Getter
@Setter
public class CategoryItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
