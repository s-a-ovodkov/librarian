package sa.ovodkov.librarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.ovodkov.librarian.dto.CategoryRequest;
import sa.ovodkov.librarian.dto.CategoryResponse;
import sa.ovodkov.librarian.entity.Category;
import sa.ovodkov.librarian.repository.CategoryRepository;

import java.util.List;
import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getRootCategories() {
        return categoryRepository.findByParentCategoryIsNull();
    }

    @Override
    public List<CategoryResponse> getSubCategories(Long parentCategoryId) {
        return categoryRepository.findByChildren(parentCategoryId);
    }

    @Override
    public void addCategory(CategoryRequest category) {
        Category newCategory = Category.builder()
            .name(category.name())
            .description(category.description())
            .build();
        if (category.parentId() != null) {
            categoryRepository.findById(category.parentId()).ifPresent(newCategory::setParentCategory);
        }
        categoryRepository.save(newCategory);
    }
}