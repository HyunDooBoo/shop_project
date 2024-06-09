package shop_project.shop_back_end.domain.item.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop_project.shop_back_end.domain.item.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
