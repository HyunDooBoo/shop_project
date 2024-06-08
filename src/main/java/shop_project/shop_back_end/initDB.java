package shop_project.shop_back_end;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
//import shop_project.shop_back_end.domain.item.Item;
//import shop_project.shop_back_end.domain.item.category.Book;
//import shop_project.shop_back_end.domain.item.category.CategoryItem;
//import shop_project.shop_back_end.domain.item.category.Clothes;
//import shop_project.shop_back_end.domain.like.Like;
//import shop_project.shop_back_end.domain.manufacturer.Manufacturer;
//import shop_project.shop_back_end.domain.manufacturer.Supply;
//import shop_project.shop_back_end.domain.manufacturer.SupplyType;
import shop_project.shop_back_end.domain.supplier.Supplier;
import shop_project.shop_back_end.domain.user.User;
import shop_project.shop_back_end.util.Address;
import shop_project.shop_back_end.util.Role;
import shop_project.shop_back_end.util.Sex;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;

        public void dbInit(){

            //유저 두 명 넣기
            Address address = Address.builder()
                    .city("서울")
                    .street("먹골")
                    .zipcode("123456")
                    .build();

            User user = User.builder()
                    .username("오현두")
                    .nickname("유기농두부")
                    .password("12345")
                    .age(26)
                    .phoneNum("010-3597-3141")
                    .email("hyundoo1006@gmail.com")
                    .sex(Sex.MAN)
                    .role(Role.BRONZE)
                    .address(address)
                    .build();
            em.persist(user);

            Address address2 = Address.builder()
                    .city("서울")
                    .street("잠실")
                    .zipcode("126")
                    .build();

            User user2 = User.builder()
                    .username("이승주")
                    .nickname("병아리")
                    .password("125")
                    .age(26)
                    .phoneNum("010-6399-9738")
                    .email("joouk22@naver.com")
                    .sex(Sex.WOMAN)
                    .role(Role.DIAMOND)
                    .address(address)
                    .build();
            em.persist(user2);

            //공급자 두 명 넣기
            Address address3 = Address.builder()
                    .city("광주")
                    .street("전북")
                    .zipcode("12456")
                    .build();

            Supplier supplier = Supplier.builder()
                    .name("공급자1")
                    .password("1561065")
                    .phoneNum("010-1234-5678")
                    .address(address3)
                    .build();

            Address address4 = Address.builder()
                    .city("부산")
                    .street("해운대")
                    .zipcode("3456")
                    .build();

            Supplier supplier2 = Supplier.builder()
                    .name("공급자2")
                    .password("1565")
                    .phoneNum("010-4378-5678")
                    .address(address4)
                    .build();

            em.persist(supplier);
            em.persist(supplier2);

        }
    }
}
