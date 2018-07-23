package algorithm;

import java.time.Period;

public class AgeGapResult {
    private Person oldest;
    private Person youngest;

    AgeGapResult() {
    }

    public AgeGapResult(Person person1, Person person2) {
        this.youngest = person1.isYoungerThan(person2) ? person1 : person2;
        this.oldest = person1.isYoungerThan(person2) ? person2 : person1;
    }

    public static AgeGapResult empty() {
        return new AgeGapResult();
    }

    public Person getOldest() {
        return oldest;
    }

    public Person getYoungest() {
        return youngest;
    }

    public int getAgeGap() {
        return Period.between(getOldest().getBirthDate(), getYoungest().getBirthDate()).getYears();
    }

    @Override
    public String toString() {
        return "AgeGapResult{" +
                "oldest=" + oldest +
                ", youngest=" + youngest +
                ", ageGap=" + getAgeGap() +
                '}';
    }
}
