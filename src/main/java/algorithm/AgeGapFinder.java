package algorithm;

import java.util.ArrayList;
import java.util.List;

public class AgeGapFinder {
    private final List<Person> people;

    public AgeGapFinder(List<Person> people) {
        this.people = people;
    }

    public AgeGapResult findBy(Criteria criteria) {
        List<AgeGapResult> ageGaps = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                AgeGapResult ageGapResult = new AgeGapResult();
                if (people.get(i).getBirthDate().getTime() < people.get(j).getBirthDate().getTime()) {
                    ageGapResult.oldest = people.get(i);
                    ageGapResult.youngest = people.get(j);
                } else {
                    ageGapResult.oldest = people.get(j);
                    ageGapResult.youngest = people.get(i);
                }
                ageGapResult.difference = ageGapResult.youngest.getBirthDate().getTime() - ageGapResult.oldest.getBirthDate().getTime();
                ageGaps.add(ageGapResult);
            }
        }

        if (ageGaps.size() < 1) {
            return new AgeGapResult();
        }

        AgeGapResult answer = ageGaps.get(0);
        for (AgeGapResult result : ageGaps) {
            switch (criteria) {
                case CLOSEST:
                    if (result.difference < answer.difference) {
                        answer = result;
                    }
                    break;

                case FURTHEST:
                    if (result.difference > answer.difference) {
                        answer = result;
                    }
                    break;
            }
        }

        return answer;
    }
}
