package model;

import model.beans.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<Employee>();
    }

    public void create(Employee e) {
        this.employees.add(e);
    }

    public ArrayList<Employee> read() {
        return this.employees;
    }

    public void update(Employee oldEmployee, Employee newEmployee) {
        this.employees.remove(oldEmployee);
        this.employees.add(newEmployee);
    }

    public void delete(Employee e) {
        this.employees.remove(e);
    }
}
