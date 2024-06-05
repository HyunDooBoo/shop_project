package shop_project.shop_back_end.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop_project.shop_back_end.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNickname(String nickName);

}
