package java_task.hw3;

public enum Rating {
    RATING_A,
    RATING_B,
    RATING_C,
    RATING_D,
    RATING_E;


    public static double getRatingCoefficient(Rating rating) {
        switch (rating) {
            case RATING_A:
                return 1.2;
            case RATING_B:
                return 1.15;
            case RATING_C:
                return 1.05;
            case RATING_D:
                return 1;
            case RATING_E:
                return 0.95;
        }
        return 0;
    }
}
