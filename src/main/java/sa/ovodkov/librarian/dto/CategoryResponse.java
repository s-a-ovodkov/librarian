package sa.ovodkov.librarian.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
@Schema(description = "Данные категории книг")
public record CategoryResponse(

    @Schema(description = "Идентификатор категории", example = "1", requiredMode = REQUIRED)
    Long id,

    @Schema(description = "Название категории", example = "Художественная литература", requiredMode = REQUIRED)
    String name,

    @Schema(
        description = "Описание категории",
        example = "Книги, которые использует в качестве выразительных средств слова и словесные конструкции языка.",
        requiredMode = REQUIRED)
    String description,

    @Schema(description = "Название родительской категории")
    String parentCategoryName
) {
}
