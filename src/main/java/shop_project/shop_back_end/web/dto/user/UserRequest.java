package shop_project.shop_back_end.web.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import shop_project.shop_back_end.util.Sex;

@Getter
@Setter
public class UserRequest {

    @NotEmpty(message = "회원 이름은 필수입니다.")
    private String username;

    @NotEmpty(message = "닉네임은 필수입니다.")
    private String nickname;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    @NotNull(message = "나이 입력은 필수입니다.")
    private int age;

    @NotEmpty(message = "이메일 입력은 필수입니다.")
    private String email;

    @NotEmpty(message = "핸드폰 번호 입력은 필수입니다.")
    private String phoneNum;

    private String city;
    private String street;
    private String zipcode;

    @NotNull(message = "성별 입력은 필수입니다.")
    private Sex sex;
}
