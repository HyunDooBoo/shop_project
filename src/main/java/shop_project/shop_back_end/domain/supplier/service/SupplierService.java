package shop_project.shop_back_end.domain.supplier.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop_project.shop_back_end.domain.item.service.ItemService;
import shop_project.shop_back_end.domain.supplier.Supplier;
import shop_project.shop_back_end.domain.supplier.repository.SupplierRepository;
import shop_project.shop_back_end.util.Address;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;
import shop_project.shop_back_end.web.dto.supplier.SupplierRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final ItemService itemService;

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
        Long itemId = itemService.createItem(form);
        supplier.addItem(itemService.getItem(itemId));
        return itemId;
    }

    public Supplier findSupplier(Long supplierId){
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new EntityNotFoundException(supplierId + "에 해당하는 유저가 없습니다."));
    }

}
