package labexample.commands;

import labexample.Command;
import labexample.service.BooksService;

public class DeleteBookCommand implements Command<String> {

    private final BooksService booksService;
    private final int id;

    public DeleteBookCommand(BooksService booksService, int id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public String execute() {
        return booksService.deleteBook(id);
    }
}
