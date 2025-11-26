package labexample;

import java.util.ArrayList;
import java.util.List;

public class AllBooksSubject {

    private final List<Observer> observers = new ArrayList<>();
    private static final AllBooksSubject INSTANCE = new AllBooksSubject();

    private AllBooksSubject() {}

    public static AllBooksSubject getInstance() { return INSTANCE; }

    public void attach(Observer o) { observers.add(o); }
    public void detach(Observer o) { observers.remove(o); }

    public void add(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }
}
