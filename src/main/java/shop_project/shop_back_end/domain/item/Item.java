package shop_project.shop_back_end.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.category.Category;
import shop_project.shop_back_end.domain.item.category.CategoryItem;
import shop_project.shop_back_end.domain.like.Like;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int count;

    private int price;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CategoryItem> categoryItems = new HashSet<>();


    //연관관계 편의 메서드
    public void addCategoryItem(CategoryItem categoryItem) {
        categoryItems.add(categoryItem);
        categoryItem.setItem(this);
    }

    public void removeCategoryItem(CategoryItem categoryItem) {
        categoryItems.remove(categoryItem);
        categoryItem.setItem(null);
    }
}
