package labexample;

import jakarta.persistence.Entity;

@Entity
public class TableElement extends BaseElement {

    private String title;

    public TableElement() {}

    public TableElement(String title, String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public void print() {
        System.out.println("TableElement: " + title + ", content: " + getContent());
    }

    @Override
    public TableElement clone() {
        return new TableElement(title, getContent());
    }
}
