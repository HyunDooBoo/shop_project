package shop_project.shop_back_end.domain.order.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.delivery.Delivery;
import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.repository.ItemRepository;
import shop_project.shop_back_end.domain.order.Order;
import shop_project.shop_back_end.domain.order.OrderItem;
import shop_project.shop_back_end.domain.order.repository.OrderRepository;
import shop_project.shop_back_end.domain.user.User;
import shop_project.shop_back_end.domain.user.repository.UserRepository;
import shop_project.shop_back_end.web.dto.order.OrderItemDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final EntityManager em;

    @Transactional
    public Long Order(Long userId, Delivery delivery, List<OrderItemDTO> orderItemDtos){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(userId + "에 해당하는 유저가 없습니다."));
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO dto : orderItemDtos){
            Item item = itemRepository.findById(dto.getItemId())
                    .orElseThrow(() -> new EntityNotFoundException(dto.getItemId() + "에 해당하는 아이템이 없습니다"));
            OrderItem orderitem = OrderItem.createOrderItem(item, item.getPrice(), dto.getCount());
            orderItems.add(orderitem);
        }

        Order order = Order.createOrder(user, delivery, orderItems);
        orderRepository.save(order);

        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException(orderId + "에 해당하는 주문이 없습니다."));
        order.cancel();
    }

    public List<Order> findAllWithMemberDelivery(int offset, int limit) {
        return em.createQuery("select o from Order o" +
                        " join fetch o.user u" +
                        " join fetch o.delivery d", Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

}
