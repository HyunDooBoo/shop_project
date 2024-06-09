package shop_project.shop_back_end.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop_project.shop_back_end.domain.order.Order;
import shop_project.shop_back_end.domain.order.service.OrderService;
import shop_project.shop_back_end.web.dto.order.OrderDTO;
import shop_project.shop_back_end.web.dto.order.OrderRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@RequestBody @Valid final OrderRequest orderRequest){
        Long orderId = orderService.Order(orderRequest.getUserId(),
                orderRequest.getDelivery(), orderRequest.getOrderItemDtos());
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> cancleOrder(@PathVariable Long orderId){
        orderService.cancelOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOrder/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable Long userId){
        List<Order> orders = orderService.findAllByUserId(userId);
        List<OrderDTO> collect = orders.stream()
                .map(order -> new OrderDTO(order))
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

}
