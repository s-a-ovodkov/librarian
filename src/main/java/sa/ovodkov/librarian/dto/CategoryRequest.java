package sa.ovodkov.librarian.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * Данные создания категории книг.
 */
@Builder
@Schema(description = "Создание категории")
public record CategoryRequest(

    @Schema(description = "Название категории", example = "Художественная литература", requiredMode = REQUIRED)
    String name,

    @Schema(
        description = "Описание категории",
        example = "Книги, которые использует в качестве выразительных средств слова и словесные конструкции языка.",
        requiredMode = REQUIRED)
    String description,

    @Schema(description = "Идентификатор родительской категории")
    Long parentId
) {
}
