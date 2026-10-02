import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4_ExamQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            List<String> tokens = tokenize(sc.nextLine());
            String type = tokens.get(0);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            int points = Integer.parseInt(tokens.get(4));
            if (type.equals("MCQ")) {
                questions[i] = new McqQuestion(correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                questions[i] = new TrueFalseQuestion(correctAnswer, studentAnswer, points);
            } else {
                questions[i] = new EssayQuestion(correctAnswer, studentAnswer, points);
            }
        }
        double total = 0;
        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade();
            total += score;
            System.out.printf("%s: %.2f%n", questions[i].typeName(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }

    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder current = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            tokens.add(current.toString());
        }
        return tokens;
    }
}

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    Question(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract String typeName();

    abstract double grade();
}

class McqQuestion extends Question {
    McqQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    String typeName() {
        return "MCQ";
    }

    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    String typeName() {
        return "TF";
    }

    double grade() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super(correctAnswer, studentAnswer, points);
    }

    String typeName() {
        return "ESSAY";
    }

    double grade() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();
        int matches = 0;
        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }
        if (matches >= 2) {
            return points * 0.75;
        }
        if (matches == 1) {
            return points * 0.50;
        }
        return 0;
    }
}
