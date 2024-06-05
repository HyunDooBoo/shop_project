package shop_project.shop_back_end.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop_project.shop_back_end.domain.user.User;
import shop_project.shop_back_end.domain.user.service.UserService;
import shop_project.shop_back_end.web.dto.user.UpdateNickname;
import shop_project.shop_back_end.web.dto.user.UserRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UserRequest userRequest){
        Long userId = userService.join(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @PutMapping("/{userId}/updateNick")
    public ResponseEntity<User> updateNickname(@PathVariable final Long userId,
                                                 @RequestBody @Valid final UpdateNickname updateNickname){
        User user = userService.updateNickName(userId, updateNickname.getUpdateNick());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
