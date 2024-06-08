package shop_project.shop_back_end.web.dto.supplier;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierRequest {
    @NotEmpty(message = "공급자 이름은 필수입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;

    @NotEmpty(message = "핸드폰 번호는 필수입니다.")
    private String phoneNum;

    private String city;
    private String street;
    private String zipcode;
}
