package shop_project.shop_back_end.domain.order.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import shop_project.shop_back_end.domain.order.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = {"user", "delivery"})
    List<Order> findByUserId(Long userId);
}
