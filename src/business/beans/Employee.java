package business.beans;

public class Employee extends Person{
    private double salary;

    public Employee(String name, int age, String idCode, double salary) {
        super(name, age, idCode);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}