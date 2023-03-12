package sa.ovodkov.librarian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.ovodkov.librarian.entity.Category;
import sa.ovodkov.librarian.modelview.CategoryView;
import sa.ovodkov.librarian.repository.CategoryRepository;

import java.util.List;
import jakarta.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getRootCategory() {
        return categoryRepository.findByParentCategoryIsNull();
    }

    @Override
    public void addCategory(CategoryView category) {
        Category newCategory = Category.builder()
            .name(category.getName())
            .description(category.getDescription())
            .build();
        if (category.getParentId() != null) {
            categoryRepository.findById(category.getParentId()).ifPresent(newCategory::setParentCategory);
        }
    }
}