package sa.ovodkov.librarian.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sa.ovodkov.librarian.entity.Category;
import sa.ovodkov.librarian.repository.CategoryRepository;

import java.util.Optional;
import java.util.Set;

import static fixture.CategoryServiceTestData.getCategoryDTOWithParentCategory;
import static fixture.CategoryServiceTestData.getCategoryDTOWithoutParentCategory;
import static fixture.CategoryServiceTestData.getParentCategory;
import static fixture.CategoryServiceTestData.getParentCategoryWithChildren;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Тестирование сервиса работы с категориями книг")
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private static final Long PARENT_CATEGORY_ID = 1L;

    @Test
    @DisplayName("Создание корневой категории")
    void addCategoryWithoutParentCategory() {
        categoryService.addCategory(getCategoryDTOWithoutParentCategory());

        verify(categoryRepository, never()).findById(Mockito.anyLong());
    }

    @Test
    @DisplayName("Создание под категории книги")
    void addCategoryWithParentCategory() {
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(getParentCategory(PARENT_CATEGORY_ID)));

        categoryService.addCategory(getCategoryDTOWithParentCategory(PARENT_CATEGORY_ID));

        verify(categoryRepository, times(1)).findById(eq(PARENT_CATEGORY_ID));
    }

//    @Test
//    @DisplayName("Получение списка дочерних категорий, случай наличия подкатегорий")
//    void getChildrenCategory() {
//        Long[] children = {4L, 5L, 6L};
//        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(getParentCategoryWithChildren(PARENT_CATEGORY_ID, children)));
//
//        Set<Category> result = categoryService.getSubCategories(PARENT_CATEGORY_ID);
//
//        verify(categoryRepository, times(1)).findById(eq(PARENT_CATEGORY_ID));
//
//        assertThat(result)
//            .isNotNull()
//            .hasSize(children.length)
//            .extracting(Category::getId)
//            .containsOnly(children);
//    }
//
//    @Test
//    @DisplayName("Получение списка дочерних категорий, случай отсутствия таковых у указанной категории")
//    void test() {
//        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//        Set<Category> result = categoryService.getSubCategories(PARENT_CATEGORY_ID);
//
//        verify(categoryRepository, times(1)).findById(eq(PARENT_CATEGORY_ID));
//
//        assertThat(result).isNotNull().isEmpty();
//    }
}