package sa.ovodkov.librarian.repository;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sa.ovodkov.librarian.entity.Category;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@DataJpaTest
@DisplayName("Интеграционное тестирование методов репозитория работы с категориями книг")
class CategoryRepositoryIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DataSet("datasets/categories/categories.yml")
    @DisplayName("Проверка получения списка корневых категорий")
    void findByParentCategoryIsNull() {

        List<Category> result = categoryRepository.findByParentCategoryIsNull();

        assertThat(result).isNotNull()
            .hasSize(2)
            .extracting(Category::getId)
            .containsOnly(1L, 2L);
    }
}
