package shop_project.shop_back_end.web.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop_project.shop_back_end.domain.order.Order;
import shop_project.shop_back_end.domain.order.util.OrderStatus;
import shop_project.shop_back_end.util.Address;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long orderId;
    private String userName;
    private List<OrderItemDTO> orderItems;
    private Address address;
    private OrderStatus status;

    public OrderDTO(Order order){
        orderId = order.getId();
        userName = order.getUser().getUsername();
        address = order.getDelivery().getAddress();
        status = order.getStatus();
        orderItems = order.getOrderItems().stream()
                .map(orderItem -> new OrderItemDTO(orderItem))
                .collect(Collectors.toList());

    }
}
