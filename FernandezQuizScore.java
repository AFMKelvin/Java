import java.util.Scanner;

public class FernandezQuizScore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //data fields
        int scoreCount = 0;
        double totalScore = 0;
        int highestScore = Integer.MIN_VALUE;
        int lowestScore = Integer.MAX_VALUE;
        int score = 0;

        //instructions for the user
        System.out.println("Enter quiz scores (Enter -1 to finish): ");

        //while loop
        while(score != -1) {

            // prompt user to enter scores
            System.out.print("Enter score: ");
            score = scanner.nextInt();

            // Sentinel value to terminate input
            if(score == -1) {
                continue;
            }

            // validate score range
            if(score < 0 || score > 100) {
                System.out.println("Invalid score. Score must be between 0 and 100.");
                continue;
            }

            // Update count and total for average calculation
            scoreCount++;
            totalScore += score;

            // Update highest and lowest scores
            if(score > highestScore) {
                highestScore = score;
            }
            if(score < lowestScore) {
                lowestScore = score;
            }
        }

        // Only display results if at least one valid score was entered
        if(scoreCount > 0) {

            double average;

            average = totalScore / scoreCount;

            System.out.println("Number of scores entered: " + scoreCount);
            System.out.println("Highest score: " + highestScore);
            System.out.println("Lowest score: " + lowestScore);
            System.out.printf("Arithmetic average: %.2f\n", average);

            //no valid scores message
        } else {
            System.out.println("No valid scores were entered.");
        }


    }
}
