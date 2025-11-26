package labexample.commands;

import labexample.Command;
import labexample.service.BooksService;

public class UpdateBookCommand implements Command<String> {

    private final BooksService booksService;
    private final int id;
    private final String book;

    public UpdateBookCommand(BooksService booksService, int id, String book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public String execute() {
        return booksService.updateBook(id, book);
    }
}
