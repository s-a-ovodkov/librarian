package sa.ovodkov.librarian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Категория к которой относится книга
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    /**
     * Идентификатор категории книги.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название категории.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Описание смысла данной категории книг.
     */
    @Column(name = "description")
    private String description;

    /**
     * Ссылка на родительскую категорию.
     */
    @ManyToOne
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Category parentCategory;

    /**
     * Список дочерних категорий.
     */
    @OneToMany
    @JoinColumn(name = "parent_id")
    private Set<Category> childrenCategory = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Book> books = new HashSet<>();
}
