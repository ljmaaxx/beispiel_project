package business;

import business.beans.Book;
import business.beans.Employee;
import business.beans.Sale;
import business.beans.User;
import exceptions.InexistentUserException;
import exceptions.UserAlreadyRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class AdmFacade {
    private BookController bookController;
    private EmployeeController employeeController;
    private SaleController saleController;
    private UserController userController;

    public AdmFacade() {
        this.bookController = new BookController();
        this.employeeController = new EmployeeController();
        this.saleController = new SaleController();
        this.userController = new UserController();
    }

    public void createBook(Book b) {
        bookController.createBook(b);
    }

    public ArrayList<Book> searchBook(String value) {
        return bookController.search(value);
    }

    public void importBook(int amount, Book bookImported) {
        bookController.importBook(amount, bookImported);
    }

    public void delete(Book obj) {
        bookController.delete(obj);
    }

    public void create(Employee obj) {
        employeeController.create(obj);
    }

    public void update(Employee oldObj, Employee newObj) {
        employeeController.update(oldObj, newObj);
    }

    public void delete(Employee obj) {
        employeeController.delete(obj);
    }

    public void create(Sale obj) {
        saleController.create(obj);
    }

    public void update(Sale oldObj, Sale newObj) {
        saleController.update(oldObj, newObj);
    }

    public void delete(Sale obj) {
        saleController.delete(obj);
    }

    public void sale(Book b) {
        saleController.sale(b);
    }

    public Sale search(String obj) {
        return saleController.search(obj);
    }

    public void saveUser(User user) {
        try {
            userController.saveUser(user);
        } catch (UserAlreadyRegisteredException e) {
            e.printStackTrace();
        }
    }

    public User searchByUser(String username) {
        try {
            return userController.searchByUser(username);
        } catch (InexistentUserException e) {
            return null;
        }
    }

    public void delete(User obj) {
        userController.delete(obj);
    }

    public List<User> read() {
        return userController.read();
    }

    public Employee searchEmployee(String value) {
        return employeeController.searchByIdCode(value);
    }
}
