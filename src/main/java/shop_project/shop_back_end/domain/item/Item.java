package shop_project.shop_back_end.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.category.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int count;

    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
