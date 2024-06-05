package shop_project.shop_back_end.web.dto.order;

import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.delivery.Delivery;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long userId;
    private Delivery delivery;
    private List<OrderItemDTO> orderItemDtos;

}
