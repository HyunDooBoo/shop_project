package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@DiscriminatorValue("F")
@Getter
@Setter
public class Food extends Item {

    private String type;
}
