package map;

import lombok.EqualsAndHashCode;

import java.util.Objects;

public class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != getClass())
            return false;
        Student that = (Student) obj;
        return (name == that.name && id == that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
