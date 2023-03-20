package sa.ovodkov.librarian.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sa.ovodkov.librarian.AbstractIntegrationTest;
import sa.ovodkov.librarian.entity.Category;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@DisplayName("Интеграционное тестирование методов репозитория работы с категориями книг")
class CategoryRepositoryIntegrationTest extends AbstractIntegrationTest {

  @Autowired private CategoryRepository categoryRepository;

  @Test
  @DataSet("datasets/categories/categories.yml")
  @DisplayName("Проверка получения списка корневых категорий")
  void findByParentCategoryIsNull() {
    List<Category> result = categoryRepository.findByParentCategoryIsNull();

    assertThat(result).isNotNull().hasSize(2).extracting(Category::getId).containsOnly(1L, 2L);
  }
}
