package algorithm;

import java.util.*;

public class PersonFinder {
    private final List<Person> people;

    public PersonFinder(List<Person> people) {
        this.people = people;
    }

    public PersonAgeComparison findBy(Criteria criteria) {
        Collection<PersonAgeComparison> agesDifference = getAgesDifference();
        return (agesDifference.isEmpty()) ? PersonAgeComparison.empty() : criteria.from(agesDifference).get(0);
    }

    private Collection<PersonAgeComparison> getAgesDifference() {
        Set<PersonAgeComparison> comparisons = new HashSet<>();
        for (Person p1 : people) {
            for (Person p2 : people) {
                if (p1.notEquals(p2)) {
                    Person younger = PersonAgeComparison.youngestFrom(p1, p2);
                    Person older = PersonAgeComparison.oldestFrom(p1, p2);
                    comparisons.add(new PersonAgeComparison(younger, older));
                }
            }
        }
        return comparisons;
    }
}
