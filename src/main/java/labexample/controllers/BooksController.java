package labexample.controllers;

import labexample.Command;
import labexample.commands.*;
import labexample.service.BooksService;
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

    @GetMapping
    public ResponseEntity<List<String>> getAllBooks() {
        Command<List<String>> command = new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(command.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBookById(@PathVariable int id) {
        Command<String> command = new GetBookByIdCommand(booksService, id);
        return ResponseEntity.ok(command.execute());
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody String book) {
        Command<String> command = new CreateBookCommand(booksService, book);
        return ResponseEntity.ok(command.execute());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @RequestBody String book) {
        Command<String> command = new UpdateBookCommand(booksService, id, book);
        return ResponseEntity.ok(command.execute());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        Command<String> command = new DeleteBookCommand(booksService, id);
        return ResponseEntity.ok(command.execute());
    }
}
