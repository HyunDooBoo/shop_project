package shop_project.shop_back_end.domain.item.category;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Item {

    private String author;
    private String isbn;
}
