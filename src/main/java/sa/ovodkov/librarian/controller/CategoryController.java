package sa.ovodkov.librarian.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sa.ovodkov.librarian.dto.CategoryRequest;
import sa.ovodkov.librarian.dto.CategoryResponse;
import sa.ovodkov.librarian.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "categories", description = "Категории книг")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Получение списка верхне уровневых категорий.")
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getRootCategories() {
        return ResponseEntity.ok(categoryService.getRootCategories());
    }

    @Operation(summary = "Получение дочерних категорий по идентификатору родительской категории")
    @GetMapping("/{parentId}")
    public ResponseEntity<List<CategoryResponse>> getChildCategories(
        @Parameter(description = "Идентификатор родительской категории", required = true) @PathVariable("parentId") Long parentId
    ) {
        return ResponseEntity.ok(categoryService.getSubCategories(parentId));
    }

    @Operation(summary = "Добавить новую категорию книг")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCategory(@RequestBody CategoryRequest category) {
        categoryService.addCategory(category);
    }
}
