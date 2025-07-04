import java.util.*;

class Question {
    String question;
    String[] options;
    char correctAnswer;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        char optionName = 'A';
        for (String option : options) {
            System.out.println(optionName + ") " + option);
            optionName++;
        }
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Rohit Sharma Quiz Questions
        questions.add(new Question(
                "1. What is Rohit Sharma's nickname?",
                new String[]{"Hitman", "Mahi", "Boom", "King"},
                'A'));

        questions.add(new Question(
                "2. Against which team did Rohit Sharma score his first ODI double century?",
                new String[]{"Sri Lanka", "Australia", "South Africa", "Pakistan"},
                'A'));

        questions.add(new Question(
                "3. What is Rohit Sharma's highest individual score in ODIs?",
                new String[]{"209", "264", "248", "232"},
                'B'));

        questions.add(new Question(
                "4. In which year did Rohit Sharma make his debut in international cricket?",
                new String[]{"2005", "2007", "2009", "2011"},
                'B'));

        questions.add(new Question(
                "5. Which IPL team does Rohit Sharma captain?",
                new String[]{"Chennai Super Kings", "Delhi Capitals", "Mumbai Indians", "RCB"},
                'C'));

        int score = 0;

        System.out.println("🏏 Welcome to the Rohit Sharma Quiz!");
        System.out.println("-----------------------------------");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println();
            questions.get(i).displayQuestion();

            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);

            if (questions.get(i).isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + questions.get(i).correctAnswer);
            }
        }

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());

        if (score == 5) {
            System.out.println("🏆 You're a true Hitman fan!");
        } else if (score >= 3) {
            System.out.println("👏 Good job! You know Rohit pretty well.");
        } else {
            System.out.println("📚 Time to brush up on your cricket knowledge!");
        }

        scanner.close();
    }
}
