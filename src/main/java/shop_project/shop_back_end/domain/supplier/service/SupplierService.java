package shop_project.shop_back_end.domain.supplier.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.item.Item;
import shop_project.shop_back_end.domain.item.category.Category;
import shop_project.shop_back_end.domain.item.category.CategoryItem;
import shop_project.shop_back_end.domain.item.category.repository.CategoryRepository;
import shop_project.shop_back_end.domain.supplier.Supplier;
import shop_project.shop_back_end.domain.supplier.repository.SupplierRepository;
import shop_project.shop_back_end.util.Address;
import shop_project.shop_back_end.util.ItemFactory;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;
import shop_project.shop_back_end.web.dto.supplier.SupplierRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;

    //공급자 회원 가입
    @Transactional
    public Long join(SupplierRequest supplierRequest){

        Address address = Address.builder()
                .city(supplierRequest.getCity())
                .street(supplierRequest.getStreet())
                .zipcode(supplierRequest.getZipcode())
                .build();

        Supplier supplier = Supplier.builder()
                .name(supplierRequest.getUsername())
                .password(supplierRequest.getPassword())
                .phoneNum(supplierRequest.getPhoneNum())
                .address(address)
                .build();

        supplierRepository.save(supplier);
        return supplier.getId();
    }

    @Transactional
    public Long addItem(Long supplierId, ItemForm form){
        Supplier supplier = findSupplier(supplierId);

        Category category = categoryRepository.findById(form.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException(form.getCategoryId() + "번 카테고리는 없습니다"));

        Item item = ItemFactory.createItem(form, category);

        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setItem(item);
        categoryItem.setCategory(category);
        category.addCategoryItem(categoryItem);

        supplier.addItem(item);
        return item.getId();
    }

    public Supplier findSupplier(Long supplierId){
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new EntityNotFoundException(supplierId + "에 해당하는 유저가 없습니다."));
    }

//    @Transactional
//    public void addItem(Long supplierId, ItemForm form){
//        String itemType = form.getType();
//        if (itemType.equals("Clothes")){
//            Item clothes = Clothes.builder()
//                    .fabric(form.getFabric())
//                    .name(form.getName())
//                    .price(form.getPrice())
//                    .stockQuantity(form.getStockQuantity())
//                    .build();
//        } else if (itemType.equals("Book")){
//            Book book = Book.builder()
//                    .author(form.getAuthor())
//                    .isbn(form.getIsbn())
//                    .name(form.getName())
//                    .price(form.getPrice())
//                    .stockQuantity(form.getStockQuantity())
//                    .build();
//        } else if (itemType.equals("Food")){
//            Food food = Food.builder()
//                    .type(form.getType())
//                    .name(form.getName())
//                    .price(form.getPrice())
//                    .stockQuantity(form.getStockQuantity())
//                    .build();
//        }
//    }
}
