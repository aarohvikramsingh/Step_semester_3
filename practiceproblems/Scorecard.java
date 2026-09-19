package practiceproblems;

public class Scorecard {

    private boolean[] answers;
    private int totalQuestions;
    private int currentAnswer;

    Scorecard(int questions) {
        totalQuestions = questions;
        answers = new boolean[questions];
        currentAnswer = 0;
    }

    void recordAnswer(boolean correct) {

        if (currentAnswer < totalQuestions) {
            answers[currentAnswer] = correct;
            currentAnswer++;
        }
    }

    int getScore() {

        int score = 0;

        for (int i = 0; i < currentAnswer; i++) {

            if (answers[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}