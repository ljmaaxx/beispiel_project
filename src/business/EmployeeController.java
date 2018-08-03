package business;

import business.beans.Employee;
import data.EmployeeRepository;
import data.IRepository;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private IRepository employeeRepository;

    public EmployeeController() {
        this.employeeRepository = EmployeeRepository.getInstance();
    }

    public void create(Employee obj) {
        employeeRepository.create(obj);
    }

    public List<Employee> read() {
        return employeeRepository.read();
    }

    public void update(Employee oldObj, Employee newObj) {
        employeeRepository.update(oldObj, newObj);
    }

    public void delete(Employee obj) {
        employeeRepository.delete(obj);
    }

    public Employee searchByIdCode(String value) {
        ArrayList<Employee> searchingEmployees = (ArrayList) employeeRepository.read();
        for (int i = 0; i < searchingEmployees.size(); ++i) {
            if (searchingEmployees.get(i).getIdCode().equals(value)) {
                return searchingEmployees.get(i);
            }
        }
        return null;
    }
}
