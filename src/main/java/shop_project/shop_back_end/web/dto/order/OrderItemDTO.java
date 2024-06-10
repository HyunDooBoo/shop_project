package shop_project.shop_back_end.web.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop_project.shop_back_end.domain.order.OrderItem;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long itemId;
    private String itemName;
    private int count;
    private int totalPrice;

    public OrderItemDTO(OrderItem orderItem){
        itemId = orderItem.getId();
        itemName = orderItem.getItem().getName();
        totalPrice = orderItem.getTotalPrice();
        count = orderItem.getCount();
    }
}
