package shop_project.shop_back_end.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.user.User;

@Entity
@Getter
@Setter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String content;

    //연관관계 편의 메서드
    public void setUser(User user){
        this.user = user;
        user.getBoards().add(this);
    }

    public void removeUser(){
        if(this.user != null){
            this.user.getBoards().remove(this);
            this.user = null;
        }
    }

}
