package algorithm;

public enum Criteria {
    CLOSEST {
        @Override
        public int sort(AgeGapResult agr1, AgeGapResult agr2) {
            return agr1.getAgeGap() - agr2.getAgeGap();
        }
    },

    FURTHEST {
        @Override
        public int sort(AgeGapResult agr1, AgeGapResult agr2) {
            return agr2.getAgeGap() - agr1.getAgeGap();
        }
    };

    public abstract int sort(AgeGapResult agr1, AgeGapResult agr2);
}
