package Test;

import java.util.Scanner;

class CmConversion {
    public static final double CM_TO_INCHES = 2.54;
    public static final double INCHES_IN_FOOT = 12;
    public static final double INCHES_IN_YARD = 36;

    private double centimeter;

    public CmConversion() {
        this.centimeter = 0;
    }

    public CmConversion(double cm) {
        this.centimeter = cm;
    }

    public void setCentimeter(double cm) {
        this.centimeter = cm;
    }

    public double getCentimeter() {
        return this.centimeter;
    }

    public double toInches() {
        return this.centimeter / CM_TO_INCHES;
    }

    public double toYards() {
        return toInches() / INCHES_IN_YARD; // 1 yard = 36 inches
    }

    public double toFeet() {
        return toInches() / INCHES_IN_FOOT; // 1 foot = 12 inches
    }
}


public class CmConversionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Centimeter Conversion");
        System.out.print("\nEnter a number in centimeters: ");
        double numToConvert = scanner.nextDouble();

        CmConversion cmConversion = new CmConversion(numToConvert);

        double inches = cmConversion.toInches();
        double yards = cmConversion.toYards();
        double feet = cmConversion.toFeet();

        System.out.printf("%.2f cm is %.2f inch(es)%n", numToConvert, inches);
        System.out.printf("%.2f cm is %.2f yard(s)%n", numToConvert, yards);
        System.out.printf("%.2f cm is %.2f foot/feet%n", numToConvert, feet);

        scanner.close();
    }
}

