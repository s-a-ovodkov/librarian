package sa.ovodkov.librarian.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sa.ovodkov.librarian.AbstractIntegrationTest;
import sa.ovodkov.librarian.dto.CategoryResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Интеграционное тестирование методов репозитория работы с категориями книг")
class CategoryRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DataSet("datasets/categories/categories.yml")
    @DisplayName("Проверка получения списка корневых категорий")
    void findByParentCategoryIsNull() {
        List<CategoryResponse> result = categoryRepository.findByParentCategoryIsNull();

        assertThat(result)
            .isNotNull()
            .hasSize(2)
            .extracting(CategoryResponse::id)
            .containsOnly(1L, 2L);
    }

    @Test
    @DataSet("datasets/categories/categories.yml")
    @DisplayName("Проверка получения списка дочерних категорий, указанной категории")
    void test() {
        List<CategoryResponse> result = categoryRepository.findByChildren(1L);

        assertThat(result)
            .isNotNull()
            .hasSize(2)
            .extracting(CategoryResponse::id)
            .containsOnly(3L, 4L);
    }
}
