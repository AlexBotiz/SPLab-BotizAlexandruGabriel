package labexample;

import jakarta.persistence.*;
import laborator.Element;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseElement implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public void add(Element e) {}
    @Override
    public void remove(Element e) {}
    @Override
    public Element get(int i) { return null; }
    @Override
    public BaseElement clone() { return null; }
}
