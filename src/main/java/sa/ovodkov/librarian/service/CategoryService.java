package sa.ovodkov.librarian.service;

import sa.ovodkov.librarian.dto.CategoryRequest;
import sa.ovodkov.librarian.dto.CategoryResponse;

import java.util.List;

/**
 * Сервис для работы с категориями книг.
 */
public interface CategoryService {

    /**
     * Получить список верхне уровневых категорий.
     *
     * @return Список верхне уровневых категорий.
     */
    List<CategoryResponse> getRootCategories();

    /**
     * Получить список подкатегорий указанной категории.
     *
     * @param parentCategoryId Идентификатор категории.
     * @return Список подкатегории указанной категории.
     */
    List<CategoryResponse> getSubCategories(Long parentCategoryId);

    /**
     * Добавить новую категорию книг в систему.
     *
     * @param category Данные о новой категории книг
     */
    void addCategory(CategoryRequest category);
}
