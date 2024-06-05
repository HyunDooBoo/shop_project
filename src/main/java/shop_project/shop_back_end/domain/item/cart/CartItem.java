package shop_project.shop_back_end.domain.item.cart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.item.Item;

@Entity
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;
}