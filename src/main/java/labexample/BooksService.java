package labexample;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return booksRepository.findById(id);
    }

    public Book updateBook(int id, Book updatedBook) {
        updatedBook.setId(id);
        return booksRepository.save(updatedBook);
    }

    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }
}
