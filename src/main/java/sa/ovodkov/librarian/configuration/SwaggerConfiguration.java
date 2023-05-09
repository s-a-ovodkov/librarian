package sa.ovodkov.librarian.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "Библиотекарь",
        description = "Приложение категоризации, поиска и хранения информации книг в электронной библиотеки",
        version = "1.0.0"
    ))
@Configuration
public class SwaggerConfiguration {
}
