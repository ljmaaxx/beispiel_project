package controller;

import model.EmployeeRegister;
import model.beans.Employee;

public class EmployeeController {
    private EmployeeRegister employeeRegister;

    public void registerEmployee(Employee e) {
        if(e != null && (!this.employeeRegister.getRepository().read().contains(e)))
            this.employeeRegister.getRepository().create(e);
    }

    public void removeEmployee(Employee e) {
        if (e != null && this.employeeRegister.getRepository().read().contains(e))
            this.employeeRegister.getRepository().delete(e);
    }

    public Employee searchEmployee(String name) {
        if ((!this.employeeRegister.getRepository().read().isEmpty()) && name != null)
        {
            for (int i = 0; i < this.employeeRegister.getRepository().read().size(); ++i) {
                if (this.employeeRegister.getRepository().read().get(i).getName().equals(name))
                {
                    return this.employeeRegister.getRepository().read().get(i);
                }
            }
        }
        return null;
    }
}
