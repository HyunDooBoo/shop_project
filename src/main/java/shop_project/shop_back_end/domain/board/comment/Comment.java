package shop_project.shop_back_end.domain.board.comment;

import jakarta.persistence.*;
import shop_project.shop_back_end.domain.BaseEntity;
import shop_project.shop_back_end.domain.board.Board;
import shop_project.shop_back_end.domain.user.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> childComments = new ArrayList<>();
}
