package shop_project.shop_back_end.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop_project.shop_back_end.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNickname(String nickname);

}
