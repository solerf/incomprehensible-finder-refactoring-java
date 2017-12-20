package algorithm;

import java.util.Date;
import java.util.Objects;

public class Person {

    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isYounger(Person person){
        return this.birthDate.compareTo(person.getBirthDate()) > 0;
    }

    public boolean notEquals(Object obj) {
        return !this.equals(obj);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Person.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Person other = (Person) obj;
        if (this.name == null || !this.name.equals(other.name)) {
            return false;
        }
        if (this.birthDate != other.birthDate) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.birthDate);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
