package business;

import business.beans.Employee;
import data.EmployeeRepository;

public class EmployeeController {
    private EmployeeRepository repository;

    public void registerEmployee(Employee e) {
        if(e != null && (!this.repository.read().contains(e)))
            this.repository.create(e);
    }

    public void removeEmployee(Employee e) {
        if (e != null && this.repository.read().contains(e))
            this.repository.delete(e);
    }

    public Employee searchEmployee(String name) {
        if ((!this.repository.read().isEmpty()) && name != null)
        {
            for (int i = 0; i < this.repository.read().size(); ++i) {
                if (this.repository.read().get(i).getName().equals(name))
                {
                    return this.repository.read().get(i);
                }
            }
        }
        return null;
    }
}
