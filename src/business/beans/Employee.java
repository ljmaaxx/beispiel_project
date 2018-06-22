package business.beans;

public class Employee {
    private String name;
    private int age;
    private int documentCode;
    private double salary;
    private String type;

    public Employee(String name, int age, int documentCode, double salary, String type) {
        this.name = name;
        this.age = age;
        this.documentCode = documentCode;
        this.salary = salary;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}