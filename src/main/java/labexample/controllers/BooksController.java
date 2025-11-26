package labexample.controllers;

import labexample.commands.*;
import labexample.Book;
import labexample.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        CreateBookCommand command = new CreateBookCommand(booksService, book);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        GetAllBooksCommand command = new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        GetBookByIdCommand command = new GetBookByIdCommand(booksService, id);
        return command.execute()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        UpdateBookCommand command = new UpdateBookCommand(booksService, id, book);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        DeleteBookCommand command = new DeleteBookCommand(booksService, id);
        command.execute();
        return ResponseEntity.noContent().build();
    }
}
