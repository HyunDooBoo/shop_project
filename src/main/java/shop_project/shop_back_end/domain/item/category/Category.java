package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CategoryItem> categoryItems = new HashSet<>();

    //연관관계 편의 메서드
    public void addCategoryItem(CategoryItem categoryItem) {
        categoryItems.add(categoryItem);
        categoryItem.setCategory(this);
    }

    public void removeCategoryItem(CategoryItem categoryItem) {
        categoryItems.remove(categoryItem);
        categoryItem.setCategory(null);
    }
}
