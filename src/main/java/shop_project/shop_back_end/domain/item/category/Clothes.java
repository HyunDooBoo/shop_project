package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@DiscriminatorValue("C")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Clothes extends Item {

    private String fabric;
}
