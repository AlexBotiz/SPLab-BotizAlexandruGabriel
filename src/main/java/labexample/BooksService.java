package labexample.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BooksService {

    private final Map<Integer, String> books = new HashMap<>();
    private int currentId = 1;

    public List<String> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public String getBookById(int id) {
        return books.getOrDefault(id, "Book not found");
    }

    public String createBook(String book) {
        int id = currentId++;
        books.put(id, book);
        return "Book created with id " + id;
    }

    public String updateBook(int id, String book) {
        if (!books.containsKey(id)) return "Book not found";
        books.put(id, book);
        return "Book " + id + " updated";
    }

    public String deleteBook(int id) {
        if (!books.containsKey(id)) return "Book not found";
        books.remove(id);
        return "Book " + id + " deleted";
    }
}
