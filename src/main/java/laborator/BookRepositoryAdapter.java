package laborator;

import labexample.Book;
import labexample.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookRepositoryAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository booksRepository;

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }
}
