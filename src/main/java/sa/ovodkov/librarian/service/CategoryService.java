package sa.ovodkov.librarian.service;

import sa.ovodkov.librarian.dto.CategoryDTO;
import sa.ovodkov.librarian.entity.Category;

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
    List<Category> getRootCategory();

    /**
     * Добавить новую категорию книг в систему.
     *
     * @param category Данные о новой категории книг
     */
    void addCategory(CategoryDTO category);
}
