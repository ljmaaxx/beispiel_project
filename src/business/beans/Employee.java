package business.beans;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private double salary;
    private User systemUser;

    public Employee(String name, int age, String idCode, double salary, User systemUser) {
        super(name, age, idCode);
        this.salary = salary;
        this.systemUser = systemUser;
    }

    public Employee(String name, int age, String idCode, double salary) {
        super(name, age, idCode);
        this.salary = salary;
    }

    public Employee() {}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        String s = "Employee information:";
        s += "\nName: " + this.getName();
        s += "\nAge: " + this.getAge();
        s += "\nSalary: $" + this.getSalary();
        return s;

    }

    public User getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(User systemUser) {
        this.systemUser = systemUser;
    }
}