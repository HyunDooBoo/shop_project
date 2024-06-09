package shop_project.shop_back_end.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop_project.shop_back_end.domain.item.category.service.CategoryService;
import shop_project.shop_back_end.web.dto.category.CategoryDTO;

//ADMIN 전용 Category 등록 api
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Long> createCategory(@RequestBody CategoryDTO categoryDTO){
        Long categoryId = categoryService.save(categoryDTO);
        return ResponseEntity.ok(categoryId);
    }
}
