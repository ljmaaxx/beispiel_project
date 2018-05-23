package controller;

import model.BookRegister;
import model.Stock;
import model.beans.Book;

public class BookController {
    private BookRegister bookRegister;
    private Stock stock;

    public void registerBook(Book b) {
        if(b != null && (!this.bookRegister.getRepository().read().contains(b)))
            this.bookRegister.getRepository().create(b);
    }

    public void removeBook(Book b) {
        if (b != null && this.bookRegister.getRepository().read().contains(b))
            this.bookRegister.getRepository().delete(b);
    }

    public Book searchBook(String title) {
        if ((!this.bookRegister.getRepository().read().isEmpty()) && title != null)
        {
            for (int i = 0; i < this.bookRegister.getRepository().read().size(); ++i) {
                if (this.bookRegister.getRepository().read().get(i).getTitle().equals(title))
                {
                    return this.bookRegister.getRepository().read().get(i);
                }
            }
        }
        return null;
    }

    public void produce(Book b) {
        if (b != null) {
            stock.searchProduct("Book").increaseAmount(1);
        }
    }
}
