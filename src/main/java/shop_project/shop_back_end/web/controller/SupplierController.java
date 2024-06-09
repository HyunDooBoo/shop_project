package shop_project.shop_back_end.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop_project.shop_back_end.domain.supplier.service.SupplierService;
import shop_project.shop_back_end.web.dto.supplier.ItemForm;
import shop_project.shop_back_end.web.dto.supplier.SupplierRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/signup")
    public ResponseEntity<Long> createSupplier(@RequestBody @Valid final SupplierRequest supplierRequest){
        Long supplierId = supplierService.join(supplierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierId);
    }

    //임시 하드코딩
    @PostMapping("/additem/{supplierId}")
    public ResponseEntity<Long> addItem(@PathVariable final Long supplierId, @RequestBody @Valid final ItemForm form){
        Long itemId = supplierService.addItem(supplierId, form);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemId);
    }
}
