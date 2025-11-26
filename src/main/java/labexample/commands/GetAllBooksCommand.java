package labexample.commands;

import labexample.Command;
import labexample.Book;
import labexample.BooksService;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.getAllBooks();
    }
}
