package shop_project.shop_back_end.domain.user.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.user.User;
import shop_project.shop_back_end.domain.user.repository.UserRepository;
import shop_project.shop_back_end.util.Address;
import shop_project.shop_back_end.util.Role;
import shop_project.shop_back_end.web.dto.user.UserRequest;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원 가입
    @Transactional
    public Long join(UserRequest userRequest){

        validationDuplicateUserNickName(userRequest.getNickname());
        System.out.println("userRequest = " + userRequest.getNickname());

        Address address = Address.builder()
                .city(userRequest.getCity())
                .street(userRequest.getStreet())
                .zipcode(userRequest.getZipcode())
                .build();

        User user = User.builder()
                .username(userRequest.getUsername())
                .nickname(userRequest.getNickname())
                .password(userRequest.getPassword())
                .age(userRequest.getAge())
                .phoneNum(userRequest.getPhoneNum())
                .email(userRequest.getEmail())
                .sex(userRequest.getSex())
                .role(Role.BRONZE)
                .address(address)
                .build();

        userRepository.save(user);
        return user.getId();
    }

    public User findUser(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(userId + "에 해당하는 유저가 없습니다."));
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public void updateNickName(Long userId, String newNickName){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(userId + "에 해당하는 유저가 없습니다."));
        user.setNickname(newNickName);
        userRepository.save(user);
    }

    //닉네임 중복 검증
    private void validationDuplicateUserNickName(String nickname){
        if (userRepository.existsByNickname(nickname)){
            throw new IllegalStateException("중복되는 닉네임입니다.");
        }
    }
}
