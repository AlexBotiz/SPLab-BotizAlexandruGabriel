package labexample.commands;

import labexample.Command;
import labexample.service.BooksService;

public class CreateBookCommand implements Command<String> {

    private final BooksService booksService;
    private final String book;

    public CreateBookCommand(BooksService booksService, String book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public String execute() {
        return booksService.createBook(book);
    }
}
