package business.beans;

import java.util.Objects;

public class Author {
    private String name;
    private String gender;

    public Author(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Author() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(gender, author.gender);
    }
}
