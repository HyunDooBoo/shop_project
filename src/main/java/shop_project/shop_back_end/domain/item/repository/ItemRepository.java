package shop_project.shop_back_end.domain.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop_project.shop_back_end.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
