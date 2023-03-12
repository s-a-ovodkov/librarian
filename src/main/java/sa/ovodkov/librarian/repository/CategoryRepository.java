package sa.ovodkov.librarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.ovodkov.librarian.entity.Category;

import java.util.List;

/**
 * Репозиторий для работы с категориями книг.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Получить список корневых категорий.
     *
     * @return Список корневых категорий книг.
     */
    List<Category> findByParentCategoryIsNull();
}
