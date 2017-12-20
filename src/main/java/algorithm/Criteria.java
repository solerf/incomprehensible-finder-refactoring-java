package algorithm;

import java.util.*;

public enum Criteria {

    CLOSEST_AGE_DIFFERENCE() {
        @Override
        public List<PersonAgeComparison> from(Collection<PersonAgeComparison> agesDifference) {
            List toOrder = new ArrayList(agesDifference);
            Collections.reverse(toOrder);
            return toOrder;
        }
    },
    FURTHEST_AGE_DIFFERENCE() {
        @Override
        public List<PersonAgeComparison> from(Collection<PersonAgeComparison> agesDifference) {
            List toOrder = new ArrayList(agesDifference);
            Collections.sort(toOrder);
            return toOrder;
        }
    };

    public abstract List<PersonAgeComparison> from(Collection<PersonAgeComparison> agesDifference);
}
