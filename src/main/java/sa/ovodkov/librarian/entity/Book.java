package sa.ovodkov.librarian.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Описание электронной книги.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    /**
     * Идентификатор книги в системе.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Краткое название книги.
     */
    @Column(name = "short_name", nullable = false)
    private String shortName;

    /**
     * Полное название книги.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * Год издания.
     */
    @Column(name = "year_publish", nullable = false)
    private Integer yearPublish;

    /**
     * Описание книги.
     */
    @Column(name = "description")
    private String description;

    /**
     * Замечания о книге, в основном описаны недостатки текущей версии электронной книги.
     */
    @Column(name = "shortcomings")
    private String shortcomings;

    /**
     * Формат книги (PDF, DJVU, EPUB).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false)
    private BookFormatCode format;

    /**
     * Язык на котором написана книга (RUS, ENG).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private BookLanguageCode language;

    /**
     * Путь к файлу электронной книги.
     */
    @Column(name = "file_path", nullable = false)
    private String filePath;

    /**
     * Категория к которой относится книга.
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, insertable = false)
    private Category category;

    /**
     * Список авторов книги.
     */
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return shortName.equals(book.shortName) && yearPublish.equals(book.yearPublish) && format == book.format;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName, yearPublish, format);
    }
}
