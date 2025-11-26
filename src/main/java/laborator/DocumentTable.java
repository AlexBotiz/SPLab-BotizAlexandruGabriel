package laborator;

import jakarta.persistence.Entity;
import labexample.BaseElement;

@Entity
public class DocumentTable extends BaseElement {

    private String title;

    public DocumentTable() {}

    public DocumentTable(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    @Override
    public DocumentTable clone() {
        return new DocumentTable(this.title);
    }
}
