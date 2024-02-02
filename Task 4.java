package codsoft;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;
    private char userAnswer = ' '; // Initialize with a default value

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }

    public boolean isCorrect() {
        return Character.toUpperCase(userAnswer) == correctAnswer;
    }

    public void setUserAnswer(char userAnswer) {
        this.userAnswer = userAnswer;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Task_4 {
    private static Timer timer = new Timer(true);
    private static int userScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuizQuestion[] quizQuestions = new QuizQuestion[3];

        quizQuestions[0] = new QuizQuestion("What is the capital of France?",
                new String[]{"Paris", "Berlin", "Madrid", "Rome"}, 'A');
        quizQuestions[1] = new QuizQuestion("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B');
        quizQuestions[2] = new QuizQuestion("What is the largest mammal?",
                new String[]{"Elephant", "Whale", "Giraffe", "Hippopotamus"}, 'B');

        for (QuizQuestion question : quizQuestions) {
            question.displayQuestion();

            setTimer(10, question);

            System.out.print("Your answer (A/B/C/D): ");

            char userAnswer = sc.next().toUpperCase().charAt(0);
            question.setUserAnswer(userAnswer);
            timer.cancel();

            if (question.isCorrect()) {
                System.out.println("Correct!\n");
                userScore++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer() + ".\n");
            }
        }

        System.out.println("Your final score: " + userScore + "/" + quizQuestions.length);

        sc.close();
    }

    private static void setTimer(int seconds, QuizQuestion question) {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! You didn't answer in time.\n");
                timer.cancel();
                question.setUserAnswer(' ');
            }
        }, TimeUnit.SECONDS.toMillis(seconds));
    }
}
