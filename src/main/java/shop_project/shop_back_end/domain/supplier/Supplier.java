package shop_project.shop_back_end.domain.supplier;

import jakarta.persistence.*;
import lombok.*;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.util.Address;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "supply_id")
    private Long id;
    private String name;
    private String password;
    private String phoneNum;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

    //연관 관계 메서드
    public void addItem(Item item){
        items.add(item);
        item.setSupplier(this);
    }

    public void removeItem(Item item){
        items.remove(item);
        item.setSupplier(null);
    }

    //비즈니스 로직
    public void addStockToItem(Item item, int quantity){
        item.addStock(quantity);
    }

    public void removeStockFromItem(Item item, int quantity){
        item.removeStock(quantity);
    }
}
