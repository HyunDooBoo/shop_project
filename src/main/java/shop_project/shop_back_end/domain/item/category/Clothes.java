package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@DiscriminatorValue("C")
@Getter
@Setter
public class Clothes extends Item {

    private String fabric;
}
