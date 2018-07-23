package algorithm;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgeGapFinder {
    private final List<Person> people;

    public AgeGapFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<AgeGapResult> findBy(Criteria criteria) {
        return people.stream()
                .map(pr -> people.stream()
                        .filter(p -> !p.getName().equalsIgnoreCase(pr.getName()))
                        .map(p -> new AgeGapResult(pr, p))
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .min(criteria::sort);
    }
}
