package sa.ovodkov.librarian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sa.ovodkov.librarian.dto.CategoryResponse;
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
    List<CategoryResponse> findByParentCategoryIsNull();

    @Query("""
        SELECT new sa.ovodkov.librarian.dto.CategoryResponse(c.id, c.name, c.description, c.parentCategory.name)
        FROM Category c 
        WHERE c.parentCategory.id = :parentId
        """)
    List<CategoryResponse> findByChildren(Long parentId);
}
