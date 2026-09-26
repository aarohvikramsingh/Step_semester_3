package practiceproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    private static final Pattern QUOTED_TEXT = Pattern.compile("\"([^\"]*)\"");

    private static class QuestionData {
        final String prompt;
        final String correctAnswer;
        final String studentAnswer;
        final double points;

        QuestionData(String prompt, String correctAnswer, String studentAnswer, double points) {
            this.prompt = prompt;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }
    }

    private abstract static class Question {
        final String prompt;
        final String correctAnswer;
        final String studentAnswer;
        final double points;

        Question(QuestionData data) {
            prompt = data.prompt;
            correctAnswer = data.correctAnswer;
            studentAnswer = data.studentAnswer;
            points = data.points;
        }

        abstract double score();
    }

    private static class MultipleChoiceQuestion extends Question {
        MultipleChoiceQuestion(QuestionData data) { super(data); }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0.0; }
    }

    private static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(QuestionData data) { super(data); }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0.0; }
    }

    private static class EssayQuestion extends Question {
        EssayQuestion(QuestionData data) { super(data); }

        double score() {
            String answer = studentAnswer.toLowerCase(Locale.ROOT);
            Set<String> keywords = new HashSet<>();
            for (String keyword : correctAnswer.split(",")) {
                String normalized = keyword.trim().toLowerCase(Locale.ROOT);
                if (!normalized.isEmpty()) keywords.add(normalized);
            }

            int matched = 0;
            for (String keyword : keywords) {
                if (answer.contains(keyword)) matched++;
            }

            if (matched >= 2) return points * 0.75;
            if (matched == 1) return points * 0.50;
            return 0.0;
        }
    }

    private static final Map<String, Function<QuestionData, Question>> QUESTION_TYPES = Map.of(
        "MCQ", MultipleChoiceQuestion::new,
        "TF", TrueFalseQuestion::new,
        "ESSAY", EssayQuestion::new
    );

    private static List<String> parseQuotedFields(String line, Matcher matcher) {
        List<String> fields = new ArrayList<>();
        while (matcher.find()) fields.add(matcher.group(1));
        if (fields.size() != 3) throw new IllegalArgumentException("Expected three quoted fields");
        return fields;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine().trim());
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String line = input.readLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            Matcher matcher = QUOTED_TEXT.matcher(line);
            List<String> fields = parseQuotedFields(line, matcher);
            int lastQuoteEnd = 0;
            matcher.reset();
            while (matcher.find()) lastQuoteEnd = matcher.end();
            double points = Double.parseDouble(line.substring(lastQuoteEnd).trim());

            QuestionData data = new QuestionData(
                fields.get(0), fields.get(1), fields.get(2), points);
            Question question = QUESTION_TYPES.get(type).apply(data);
            double score = question.score();
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
