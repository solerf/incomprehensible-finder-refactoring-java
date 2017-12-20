package algorithm;

import java.util.Objects;

public class PersonAgeComparison implements Comparable<PersonAgeComparison> {

    private Person younger;
    private Person older;

    public PersonAgeComparison(Person younger, Person older) {
        this.younger = younger;
        this.older = older;
    }

    private PersonAgeComparison() {

    }

    public static PersonAgeComparison empty() {
        return new PersonAgeComparison();
    }

    public static Person youngestFrom(Person p1, Person p2) {
        return p1.isYounger(p2) ? p1 : p2;
    }

    public static Person oldestFrom(Person p1, Person p2) {
        return p1.isYounger(p2) ? p2 : p1;
    }

    public Person getYounger() {
        return younger;
    }

    public Person getOlder() {
        return older;
    }

    public Long getAgeDifference() {
        return younger.getBirthDate().getTime() - older.getBirthDate().getTime();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!PersonAgeComparison.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final PersonAgeComparison other = (PersonAgeComparison) obj;
        if (!this.younger.equals(other.younger)) {
            return false;
        }
        if (!this.older.equals(other.older)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.younger, this.older);
    }

    @Override
    public String toString() {
        return String.format("Younger: %s, Older: %s, Difference: %s", this.younger.getName(), this.older.getName(), getAgeDifference());
    }

    @Override
    public int compareTo(PersonAgeComparison o) {
        return this.getAgeDifference() > o.getAgeDifference() ? -1 : this.getAgeDifference() < o.getAgeDifference() ? 1 : 0;
    }
}
