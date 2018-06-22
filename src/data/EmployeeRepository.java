package data;

import business.beans.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {
    private ArrayList<Employee> employees;
    private static EmployeeRepository instance;

    private EmployeeRepository() {
        this.employees = new ArrayList<Employee>();
    }

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    @Override
    public void create(Employee obj) {
        this.employees.add(obj);
    }

    @Override
    public List<Employee> read() {
        return this.employees;
    }

    @Override
    public void update(Employee oldObj, Employee newObj) {
        this.employees.add(newObj);
        this.employees.remove(oldObj);
    }

    @Override
    public void delete(Employee obj) {
        this.employees.remove(obj);
    }

    public boolean exist(Employee e) {
        return this.employees.contains(e);
    }

    @Override
    public Employee search(String employeeName) {
        for (int i = 0; i < this.employees.size(); ++i) {
            if (this.employees.get(i).getName().equals(employeeName)) {
                return this.employees.get(i);
            }
        }
        return null;
    }
}
