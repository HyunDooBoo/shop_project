package shop_project.shop_back_end.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.board.Board;
import shop_project.shop_back_end.domain.item.cart.Cart;
import shop_project.shop_back_end.domain.like.Like;
import shop_project.shop_back_end.domain.order.Order;
import shop_project.shop_back_end.domain.util.Address;
import shop_project.shop_back_end.domain.util.Role;
import shop_project.shop_back_end.domain.util.Sex;

import java.util.ArrayList;
import java.util.List;

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

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    //연관관계 편의 메서드
    public void addBoard(Board board){
        boards.add(board);
        board.setUser(this);
    }

    public void removeBoard(Board board){
        boards.remove(board);
        board.setUser(null);
    }

}
