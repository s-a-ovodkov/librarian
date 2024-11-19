package fixture;

import sa.ovodkov.librarian.entity.Category;
import sa.ovodkov.librarian.dto.CategoryRequest;

import java.util.HashSet;
import java.util.Set;

public class CategoryServiceTestData {

    public static CategoryRequest getCategoryDTOWithoutParentCategory() {
        return CategoryRequest.builder().name("Test").description("Test description").build();
    }

    public static CategoryRequest getCategoryDTOWithParentCategory(Long parentCategoryId) {
        return CategoryRequest.builder()
            .name("Test")
            .description("Test description")
            .parentId(parentCategoryId)
            .build();
    }

    public static Category getParentCategory(Long id) {
        return Category.builder()
            .id(id)
            .name("Parent category")
            .description("Parent category description")
            .build();
    }

    public static Category getParentCategoryWithChildren(Long parentId, Long... childrenId) {
        Set<Category> children = new HashSet<>();
        for (Long id : childrenId) {
            children.add(Category.builder().id(id).name("Children " + id).build());
        }
        return Category.builder()
            .id(parentId)
            .name("Parent category")
            .description("Parent category description")
            .childrenCategory(children)
            .build();
    }
}
