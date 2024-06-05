package shop_project.shop_back_end.domain.manufacturer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Supply extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "supply_id")
    private Long id;

    private String name;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "supply")
    private List<Item> items = new ArrayList<>();
}
