package shop_project.shop_back_end.domain.order.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop_project.shop_back_end.domain.order.Order;
import shop_project.shop_back_end.web.dto.order.OrderDTO;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @EntityGraph(attributePaths = {"user", "delivery"})
    @Query("SELECT o.id, o.status, o.createdAt, u.nickname, d.address " +
            "FROM Order o " +
            "JOIN o.user u " +
            "JOIN o.delivery d " +
            "WHERE o.user.id = :userId")
    List<OrderDTO> findOrderDTOByUserId(Long userId);
}
