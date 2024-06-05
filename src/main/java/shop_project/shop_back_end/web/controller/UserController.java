package shop_project.shop_back_end.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop_project.shop_back_end.domain.user.service.UserService;
import shop_project.shop_back_end.web.dto.user.UserRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody @Valid UserRequest userRequest){
        Long userId = userService.join(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }
}
