package algorithm;

public class AgeGapResult {
    private Person oldest;
    private Person youngest;
    private long ageGap;

    public AgeGapResult() {
    }

    public Person getOldest() {
        return oldest;
    }

    public void setOldest(Person oldest) {
        this.oldest = oldest;
    }

    public Person getYoungest() {
        return youngest;
    }

    public void setYoungest(Person youngest) {
        this.youngest = youngest;
    }

    public long getAgeGap() {
        return ageGap;
    }

    public void setAgeGap(long ageGap) {
        this.ageGap = ageGap;
    }

    @Override
    public String toString() {
        return "AgeGapResult{" +
                "oldest=" + oldest +
                ", youngest=" + youngest +
                ", ageGap=" + ageGap +
                '}';
    }
}
