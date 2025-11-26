package labexample.commands;

import labexample.Command;
import labexample.Book;
import labexample.BooksService;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final int id;

    public GetBookByIdCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.getBookById(id);
    }
}
