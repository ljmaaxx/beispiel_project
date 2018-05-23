package model;

import model.beans.Employee;

import java.util.ArrayList;

public class EmployeeRegister {
    private EmployeeRepository repository;

    public EmployeeRegister() {
        this.repository = new EmployeeRepository();
    }

    public EmployeeRepository getRepository() {
        return repository;
    }

    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void registerEmployee(Employee e) {
        this.repository.create(e);
    }

    public void removeEmployee(Employee e) {
        this.repository.delete(e);
    }

    public Employee searchEmployee(String name) {
        for (int i = 0; i < this.repository.read().size(); ++i) {
            if (this.repository.read().get(i).getName().equals(name))
            {
                return this.repository.read().get(i);
            }
        }
        return null;
    }
}