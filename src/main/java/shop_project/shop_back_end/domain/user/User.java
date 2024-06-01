package shop_project.shop_back_end.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.user.util.Address;
import shop_project.shop_back_end.domain.user.util.Role;
import shop_project.shop_back_end.domain.user.util.Sex;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private int age;
    private String phone_num;
    private String email;
    private Address address;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private Role role;

}
