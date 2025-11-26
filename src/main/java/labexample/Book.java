package labexample;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<BaseElement> elements = new ArrayList<>();

    // Constructor fără args pentru JPA
    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    // Getter/Setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public List<BaseElement> getElements() { return elements; }
    public void setElements(List<BaseElement> elements) { this.elements = elements; }

    // Helper methods
    public void addAuthor(Author a) { authors.add(a); }
    public void addElement(BaseElement e) { elements.add(e); }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) a.print();
        System.out.println("Elements:");
        for (BaseElement e : elements) e.print();
    }
}
