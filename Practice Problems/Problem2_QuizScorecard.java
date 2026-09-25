// Problem 2. The Quiz Scorecard
// results live in a private array; outside the class only the score
// (count of correct answers) is ever visible, never the array.

public class Problem2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());

        sc.recordAnswer(true);
        System.out.println("Score after extra answer: " + sc.getScore());
    }
}

class Scorecard {
    private final boolean[] results;
    private int recorded;

    Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recorded = 0;
    }

    void recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            System.out.println("Answer rejected: all questions already recorded");
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    int getScore() {
        int score = 0;
        for (boolean correct : results) {
            if (correct) {
                score++;
            }
        }
        return score;
    }
}
