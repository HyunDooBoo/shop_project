package shop_project.shop_back_end.web.dto.user;

import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.util.Sex;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String nickname;
    private String password;
    private int age;
    private String phoneNum;
    private String email;
    private String city;
    private String street;
    private String zipcode;
    private Sex sex;
}
