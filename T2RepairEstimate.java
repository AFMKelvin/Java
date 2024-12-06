import java.util.Scanner;

class T2RepairEstimate {

    static final double LABOR_COST_PER_HOUR = 43.50;
    static final double TRAVEL_COST_PER_HOUR = 4.75;
    static final double VETERAN_DISCOUNT = 0.1125;
    static final double SENIOR_DISCOUNT = 0.095;
    static final double TAX_RATE = 0.0825;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Henderson's Repair Services Job Cost Calculator!");

        boolean continueCalculating;

        continueCalculating = true;

        int quantity;
        double pricePerUnit;
        double materialCost;
        boolean isVeteran;
        boolean isSenior;
        double laborHours;
        double travelHours;
        double estimate;

        while (continueCalculating) {

            System.out.print("Enter the name of the job (e.g., Hall Kitchen Remodel): ");
            String jobName = scanner.nextLine();

            System.out.print("Enter material name: ");
            String materialName = scanner.nextLine();

            System.out.print("Enter quantity of " + materialName + ": ");
            quantity = scanner.nextInt();

            System.out.print("Enter price per unit for " + materialName + ": $");
            pricePerUnit = scanner.nextDouble();

            materialCost = quantity * pricePerUnit;

            System.out.print("Is the customer a veteran? (yes/no): ");
            scanner.nextLine();
            isVeteran = scanner.nextLine().equalsIgnoreCase("yes");
            System.out.print("Is the customer a senior? (yes/no): ");
            isSenior = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Enter the estimated labor time in hours: ");
            laborHours = scanner.nextDouble();
            System.out.print("Enter the travel time to the job site in hours: ");
            travelHours = scanner.nextDouble();

            //if statement, calculates distance, if too far gives a message
            if (travelHours > 2.5) {

                System.out.println("The distance is too far, and the job will not be accepted.");

                System.out.print("\nDo you want to calculate another job? (yes/no): ");
                scanner.nextLine();
                String anotherJob = scanner.nextLine();

                if (!anotherJob.equalsIgnoreCase("yes")) {
                    continueCalculating = false;
                }

                continue;
            }

            estimate = compute(materialCost, laborHours, travelHours, isVeteran, isSenior);

            System.out.println("\nCompany Name: Henderson's Repair Services");
            System.out.println("Job Name: " + jobName);
            System.out.println("Material: " + materialName + ", Quantity: " + quantity + ", Price per unit: $" + pricePerUnit + ", Total Material Cost: $" + materialCost);
            System.out.printf("Total Estimated Price: $%.2f\n", estimate);

            System.out.print("\nDo you want to calculate another job? (yes/no): ");
            scanner.nextLine();
            String anotherJob = scanner.nextLine();

            if (!anotherJob.equalsIgnoreCase("yes")) {
                continueCalculating = false;
            }
        }

    }

    public static double compute(double materialCost, double laborHours, double travelHours, boolean isVeteran, boolean isSenior) {

        double laborCost;
        double travelCost;
        double totalCost;


        laborCost = laborHours * LABOR_COST_PER_HOUR;
        travelCost = (travelHours > 0.5) ? (travelHours * TRAVEL_COST_PER_HOUR) : 0;
        totalCost = materialCost + laborCost + travelCost;
        totalCost += totalCost * TAX_RATE;

        if (isVeteran) {
            totalCost -= totalCost * VETERAN_DISCOUNT;
        } else if (isSenior) {
            totalCost -= totalCost * SENIOR_DISCOUNT;
        }

        return totalCost;
    }
}
