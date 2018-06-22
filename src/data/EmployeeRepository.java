package data;

import negocios.beans.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<Employee>();
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
        if (this.employees.contains(e)) return true;
        return false;
    }
}
