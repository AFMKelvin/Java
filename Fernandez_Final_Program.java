import java.util.Scanner;
import java.text.DecimalFormat;

public class Fernandez_Final_Program {
    public static void main(String[] args) {
        Scanner deviceInput = new Scanner(System.in);
        int numberOfCourses;

        //ask user to input number of courses
        System.out.println("How many courses will you be inputting today?");
        numberOfCourses = deviceInput.nextInt();
        deviceInput.nextLine();

        //declarations
        int numberOfStudents;

        String[] coursename = new String[numberOfCourses];
        String[] courseSection = new String[numberOfCourses];
        double[] courseAverage = new double[numberOfCourses];
        int[] above85 = new int[numberOfCourses];
        int[] above70 = new int[numberOfCourses];
        double[] highestGradeCourse = new double[numberOfCourses];
        double[] lowestGradeCourse = new double[numberOfCourses];


        //loop for number of courses
        for (int i = 0; i < numberOfCourses; i++) {

            String[] FirstName;
            String[] lastName;
            int[] studentID;

            double[] studentAverage;
            String[] scholarship;
            char[] letterGrade;
            int[] extraCredit;
            //input course details
            System.out.println("Enter the name of course");
            coursename[i] = deviceInput.nextLine();

            System.out.println("Enter the name of the section for " + coursename[i]);
            courseSection[i] = deviceInput.nextLine();

            System.out.println("Enter the number of students for this course");
            numberOfStudents = deviceInput.nextInt();
            deviceInput.nextLine(); // Consume newline

            //allocating memory for arrays
            FirstName = new String[numberOfStudents];
            lastName = new String[numberOfStudents];
            studentID = new int[numberOfStudents];

            studentAverage = new double[numberOfStudents];
            scholarship = new String[numberOfStudents];
            letterGrade = new char[numberOfStudents];
            extraCredit = new int[numberOfStudents];
            //loop for student details
            for (int j = 0; j < numberOfStudents; j++) {
                System.out.println("Enter student first name:");
                FirstName[j] = deviceInput.nextLine();

                System.out.println("Enter student last name:");
                lastName[j] = deviceInput.nextLine();

                System.out.println("Enter student ID:");
                studentID[j] = deviceInput.nextInt();


                studentAverage[j] = getStudentAverage(0);


                System.out.println("Enter extra credit for student (0 to 5 points):");
                extraCredit[j] = deviceInput.nextInt();
                deviceInput.nextLine(); // Consume newline


                studentAverage[j] += extraCredit[j];

                scholarship[j] = getScholarship(studentAverage[j]);
                letterGrade[j] = getLetterGrade(studentAverage[j]);
            }

            DecimalFormat dfTwoDecimal = new DecimalFormat("0.00");
            DecimalFormat dfInt = new DecimalFormat("#");

            // Student summary table header
            System.out.println("                                                            Student Summary");
            System.out.println();
            System.out.println("First Name     Last Name      ID        Weighted Average Extra Credit    Student Average Letter Grade  Scholarship");
            System.out.println("-".repeat(140));

            // Print student details, data rows
            for (int j = 0; j < numberOfStudents; j++) {
                System.out.print(FirstName[j] + " ".repeat(15 - FirstName[j].length()));
                System.out.print(lastName[j] + " ".repeat(15 - lastName[j].length()));
                System.out.print(studentID[j] + " ".repeat(10 - String.valueOf(studentID[j]).length()));
                System.out.print(dfTwoDecimal.format(studentAverage[j] - extraCredit[j]) + " ".repeat(18 - dfTwoDecimal.format(studentAverage[j] - extraCredit[j]).length()));
                System.out.print(dfInt.format(extraCredit[j]) + " ".repeat(15 - dfInt.format(extraCredit[j]).length()));
                System.out.print(dfTwoDecimal.format(studentAverage[j]) + " ".repeat(18 - dfTwoDecimal.format(studentAverage[j]).length()));
                System.out.print(letterGrade[j] + " ".repeat(15 - 1));
                System.out.println(scholarship[j]);

            }
            courseAverage[i] = courseAverage(studentAverage);
            above85[i] = above85(studentAverage);
            above70[i] = above70(studentAverage);
            highestGradeCourse[i] = highestGradeCourse(studentAverage);
            lowestGradeCourse[i] = lowestGradeCourse(studentAverage);
        }
        DecimalFormat df = new DecimalFormat("0.00");

        // Course summary table header
        System.out.println("                                                            Course Summary");
        System.out.println();
        System.out.println("Course         Section        Average    Above 85   Above 70   Highest Grade   Lowest Grade");
        System.out.println("-".repeat(140));

        // Course summary output, data rows
        for (int i = 0; i < numberOfCourses; i++) {
            // Use DecimalFormat to format double values
            String courseAvgStr = df.format(courseAverage[i]);
            String highestGradeStr = df.format(highestGradeCourse[i]);
            String lowestGradeStr = df.format(lowestGradeCourse[i]);


            System.out.print(coursename[i] + " ".repeat(15 - coursename[i].length()));
            System.out.print(courseSection[i] + " ".repeat(15 - courseSection[i].length()));
            System.out.print(courseAvgStr + " ".repeat(10 - courseAvgStr.length()));
            System.out.print(above85[i] + " ".repeat(10 - String.valueOf(above85[i]).length()));
            System.out.print(above70[i] + " ".repeat(10 - String.valueOf(above70[i]).length()));
            System.out.print(highestGradeStr + " ".repeat(15 - highestGradeStr.length()));
            System.out.println(lowestGradeStr);

        }
    }
    //method to get student average, extra credit, input grades
    public static double getStudentAverage(int extraCredit) {

        Scanner deviceInput = new Scanner(System.in);
        int inputGrade;

        int quizzesTotal = 0;
        int quizzesCount = 0;

        int examsTotal = 0;
        int examsCount = 0;

        int programsTotal = 0;
        int programsCount = 0;

        int discussionsTotal = 0;
        int discussionsCount = 0;

        int sloTotal = 0;
        int sloCount = 0;
        //loop to enter grades
        // For Quizzes
        System.out.println("Enter Quizzes (press -1 to exit or press Enter to input next grade):");
        inputGrade = deviceInput.nextInt();
        while (inputGrade != -1) {
            try {
                if (inputGrade > 100 || inputGrade < 0){
                    throw new Exception(inputGrade + " out of bounds");
                }
                quizzesTotal += inputGrade;
                quizzesCount++;
                inputGrade = deviceInput.nextInt(); // Read the next input
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputGrade = deviceInput.nextInt();
            }
        }

        // For Exams
        System.out.println("Enter Exams (press -1 to exit or press Enter to input next grade):");
        inputGrade = deviceInput.nextInt();
        while (inputGrade != -1) {
            try {
                if (inputGrade > 100 || inputGrade < 0){
                    throw new Exception(inputGrade + " out of bounds");
                }
                examsTotal += inputGrade;
                examsCount++;
                inputGrade = deviceInput.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputGrade = deviceInput.nextInt();
            }
        }

        // For Programs
        System.out.println("Enter Programs (press -1 to exit or press Enter to input next grade):");
        inputGrade = deviceInput.nextInt();
        while (inputGrade != -1) {
            try {
                if (inputGrade > 100 || inputGrade < 0){
                    throw new Exception(inputGrade + " out of bounds");
                }
                programsTotal += inputGrade;
                programsCount++;
                inputGrade = deviceInput.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputGrade = deviceInput.nextInt();
            }
        }

        // For Discussions
        System.out.println("Enter Discussions (press -1 to exit or press Enter to input next grade):");
        inputGrade = deviceInput.nextInt();
        while (inputGrade != -1) {
            try {
                if (inputGrade > 100 || inputGrade < 0){
                    throw new Exception(inputGrade + " out of bounds");
                }
                discussionsTotal += inputGrade;
                discussionsCount++;
                inputGrade = deviceInput.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputGrade = deviceInput.nextInt();
            }
        }

        // For SLOs
        System.out.println("Enter SLOs (press -1 to exit or press Enter to input next grade):");
        inputGrade = deviceInput.nextInt();
        while (inputGrade != -1) {
            try {
                if (inputGrade > 100 || inputGrade < 0){
                    throw new Exception(inputGrade + " out of bounds");
                }
                sloTotal += inputGrade;
                sloCount++;
                inputGrade = deviceInput.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                inputGrade = deviceInput.nextInt();
            }
        }

        // Calculate the weighted average
        int quizzes_average;
        int exams_average;
        int programs_average;
        int discussions_average;
        int slo_average;


        quizzes_average = quizzesTotal / quizzesCount;

        exams_average = examsTotal / examsCount;

        programs_average = programsTotal / programsCount;

        discussions_average = discussionsTotal / discussionsCount;
        slo_average = sloTotal / sloCount;

        // Calculate the weighted average
        double weightedAverage = quizzes_average * 0.15 + exams_average * 0.15 +
                programs_average * 0.20 + discussions_average * 0.15 +
                slo_average * 0.35;

        // Return the final student average
        return weightedAverage + extraCredit;
    }

    //method to get scholarship
    public static String getScholarship(double studentAverage) {
        DecimalFormat df = new DecimalFormat("$0.00");
        if (studentAverage >= 95) {
            return df.format(750);
        } else if (studentAverage >= 90) {
            return df.format(500);
        } else if (studentAverage >= 85) {
            return df.format(250);
        } else {
            return df.format(0);
        }
    }
    //method to get letter grade
    public static char getLetterGrade(double average) {
        return switch ((int) average / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }
    //method to calculate grades above85
    public static int above85(double[] studentAverage) {
        int count = 0;
        for (int i = 0; i < studentAverage.length; i++) {
            if (studentAverage[i] > 85) {
                count++;
            }
        }
        return count;
    }
    //method to calculate grades above70
    public static int above70(double[] studentAverage) {
        int count = 0;
        for (int i = 0; i < studentAverage.length; i++) {
            if (studentAverage[i] > 70) {
                count++;
            }
        }
        return count;
    }
    //method to calculate highest grade in course
    public static double highestGradeCourse(double[] studentAverage) {
        if (studentAverage.length == 0) return 0.0;

        double highestAverage;

        highestAverage = studentAverage[0];
        for (int i = 1; i < studentAverage.length; i++) {
            if (studentAverage[i] > highestAverage) {
                highestAverage = studentAverage[i];
            }
        }
        return highestAverage;
    }
    //method to calculate lowest grade in course
    public static double lowestGradeCourse(double[] studentAverage) {
        if (studentAverage.length == 0) return 0.0;

        double lowestAverage;

        lowestAverage = studentAverage[0];
        for (int i = 1; i < studentAverage.length; i++) {
            if (studentAverage[i] < lowestAverage) {
                lowestAverage = studentAverage[i];
            }
        }
        return lowestAverage;
    }
    //method to calculate course average
    public static double courseAverage(double[] studentAverage) {

        double total;

        if (studentAverage.length == 0) return 0.0;

        total = 0.0;
        int i = 0;
        while (i < studentAverage.length) {
            total += studentAverage[i];
            i++;
        }
        return total / studentAverage.length;
    }
}

