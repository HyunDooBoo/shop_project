package shop_project.shop_back_end.domain.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop_project.shop_back_end.domain.supplier.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
