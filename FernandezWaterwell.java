/* Lab 1
   Kelvin Fernandez 
   02/04/2024
*/


import java.util.Scanner;

public class FernandezWaterwell {

    // constants
    private static final double PI_VALUE = Math.PI;
    private static final double CONVERSION_RATE = 7.48;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ask user to input radius of well casing in feet
        System.out.print("Enter the radius of the well casing in feet (3-5 feet): ");
        double radius = input.nextDouble();

        // ask user to input depth of well in feet
        System.out.print("Enter the depth of the well in feet: ");
        double depth = input.nextDouble();

        // calculate the volume of the well casing
        double cylinderVolume = PI_VALUE * Math.pow(radius, 2) * depth;

        // convert volume from cubic feet to gallons
        double gallonVolume = cylinderVolume * CONVERSION_RATE;

        // display the result with decimal
        System.out.printf("The number of gallons stored in the well casing: %.2f gallons%n", gallonVolume);

        
    }
}
