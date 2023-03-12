package fixture;

import sa.ovodkov.librarian.entity.Category;
import sa.ovodkov.librarian.modelview.CategoryView;

public class CategoryServiceTestData {

    public static CategoryView getCategoryDTOWithoutParentCategory() {
        return CategoryView.builder().name("Test").description("Test description").build();
    }

    public static CategoryView getCategoryDTOWithParentCategory(Long parentCategoryId) {
        CategoryView categoryDTO = getCategoryDTOWithoutParentCategory();
        categoryDTO.setParentId(parentCategoryId);
        return categoryDTO;
    }

    public static Category getParentCategory(Long id) {
        return Category.builder()
            .id(id)
            .name("Parent category")
            .description("Parent category description")
            .build();
    }
}
