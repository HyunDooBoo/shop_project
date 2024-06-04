package shop_project.shop_back_end.domain.manufacturer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.util.Address;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Manufacturer {

    @Id
    @GeneratedValue
    @Column(name = "manufacturer_id")
    private Long id;

    private String name;

    private String manager;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "manufacturer")
    private List<Supply> supplies = new ArrayList<>();
}
