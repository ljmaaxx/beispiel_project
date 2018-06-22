package business;


import business.beans.Book;
import data.BookRepository;
import data.IRepository;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private IRepository repositoryBooks;

    public BookController() {
        this.repositoryBooks = BookRepository.getInstance();
    }

    public void createBook(Book b) {
        this.repositoryBooks.create(b);
    }

    public List<Book> read() {
        return this.repositoryBooks.read();
    }

    public void updateBook(Book oldBook, Book newBook) {
        this.repositoryBooks.update(oldBook, newBook);
    }

    /*public List<Book> searchBook(Book b) //throws BookNotExistException
    {
        int valorEnum = 0; //
        String valorFiltro = "";
        List<Book> retorno = new ArrayList<Book>();
        if (this.repositoryBooks.exist(b)) {
            for (Object book : this.repositoryBooks.read()){
                if(book instanceof Book){
                    switch(valorEnum){
                        case 0: //EnumCampo.NomeLivro
                            if(((Book) book).getTitle().contains(valorFiltro)){
                                retorno.add((Book)book);
                            }
                            break;
                        case 1: //EnumCampo.Codigo

                            break;
                        default:
                            //TODO Exceocao pq nao achou o id do enum

                    }
                }
            }
        }else{
            //TODO implementar exceção de "não existe livro"
            //throw new BookNotExistException();
        }
        return retorno;

    }*/

    public Book searchBook(String title) {
        return (Book) this.repositoryBooks.search(title);
    }

    public void importBook(int amount, Book bookImported) {
        bookImported.increaseAmountAvailable(amount);
    }

    public void delete(Book obj) {
        repositoryBooks.delete(obj);
    }
}