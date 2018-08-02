package business.beans;

public abstract class Person {
    private String name;
    private int age;
    private String idCode;

    public Person(String name, int age, String idCode) {
        this.name = name;
        this.age = age;
        this.idCode = idCode;
    }

    public Person() {}

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

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
}
