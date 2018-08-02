package business;

import business.beans.Book;
import business.beans.Employee;
import business.beans.Sale;
import business.beans.User;
import exceptions.BookDoesntExistException;

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

    public List<Book> readBooks() {
        return bookController.read();
    }

    public void updateBook(Book oldBook, Book newBook) {
        bookController.updateBook(oldBook, newBook);
    }

    public ArrayList<Book> searchBook(String value) {
        try {
            return bookController.searchBook(value);
        } catch (BookDoesntExistException e) {
            e.getMessage();
            return null;
        }
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

    public List<Employee> readEmployees() {
        return employeeController.read();
    }

    public void update(Employee oldObj, Employee newObj) {
        employeeController.update(oldObj, newObj);
    }

    public void delete(Employee obj) {
        employeeController.delete(obj);
    }

    public boolean exist(Employee obj) {
        return employeeController.exist(obj);
    }

    public Employee searchEmployee(String name) {
        return employeeController.search(name);
    }

    public void create(Sale obj) {
        saleController.create(obj);
    }

    public List<Sale> readSales() {
        return saleController.read();
    }

    public void update(Sale oldObj, Sale newObj) {
        saleController.update(oldObj, newObj);
    }

    public void delete(Sale obj) {
        saleController.delete(obj);
    }

    public boolean exist(Sale obj) {
        return saleController.exist(obj);
    }

    public void sale(Book b) {
        saleController.sale(b);
    }

    public Sale search(String obj) {
        return saleController.search(obj);
    }

    public void saveUser(User user) {
        userController.saveUser(user);
    }

    public User searchByUser(String username) {
        return userController.searchByUser(username);
    }

    public boolean existsUser(String username) {
        return userController.existsUser(username);
    }

    public boolean login(User user) {
        return userController.login(user);
    }

    public void delete(User obj) {
        userController.delete(obj);
    }

    public List<User> read() {
        return userController.read();
    }
}
