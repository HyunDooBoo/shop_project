package shop_project.shop_back_end.web.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNickname {

    @NotBlank(message = "변경할 닉네임을 입력해주세요.")
    private String updateNick;
}
