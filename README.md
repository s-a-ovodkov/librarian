# Приложение "Библиотекарь"

## Сборка и запуск приложения
```bash
mvn clean package
docker build . --tag librarian
docker run -it -p8080:8080 librarian:latest
```