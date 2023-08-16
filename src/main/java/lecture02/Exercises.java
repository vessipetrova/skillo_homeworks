package lecture02;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        System.out.println("Print Name");
        printName();
        System.out.println("Print Triangle Perimeter");
        printTrianglePerimeter();
        System.out.println("Print Triangle Area");
        printTriangleArea();
        System.out.println("Print Pine Tree");
        printPineTree();
        System.out.println("Print Triangle Perimeter Input");
        printTrianglePerimeterInput();
        System.out.println("Print Triangle Area Input");
        printTriangleAreaInput();
        System.out.println("Convert Minutes To Years Days");
        convertMinutesToYearsDays();
    }

    public static void printName() {
        String firstName = "Vessi";
        String middleName = "Luybomirova";
        String lastName = "Petrova";
        String fullName = firstName + " " + middleName + " " + lastName;

        System.out.println(fullName);
    }

    public static void printTrianglePerimeter() {
        int a = 8;
        int b = 7;
        int c = 2;
        int perimeter = a + b + c;
        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleArea() {
        float a = 4.4F;
        float h = 2.8F;
        float triangleArea = (a * h) / 2;

        System.out.println("The area of the triangle is: " + triangleArea);
    }

    public static void printPineTree() {
        char pine = '#';
        System.out.println("     " + pine);
        System.out.println("    " + pine + " " + pine);
        System.out.println("   " + pine + " " + pine + " " + pine);
    }

    public static void printTrianglePerimeterInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side A's Size");
        int a = scanner.nextInt();

        System.out.println("Enter side B's Size");
        int b = scanner.nextInt();

        System.out.println("Enter side C's Size");
        int c = scanner.nextInt();

        float perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleAreaInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side a size");
        float a = scanner.nextFloat();

        System.out.println("Enter side b size");
        float h = scanner.nextFloat();

        float area = (a * h) / 2;

        System.out.println("The triangle's area is: " + area);
    }

    public static void convertMinutesToYearsDays() {
        byte minutesInHour = 60;
        byte hoursInDay = 24;
        short daysInYear = 365;
        int minutesInYear = minutesInHour * hoursInDay * daysInYear;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the number of minutes: ");

        long min = scanner.nextLong();

        long years = (min / minutesInYear);
        long days = (min / minutesInHour / hoursInDay) % daysInYear;

        System.out.println(min + " minutes is " + years + " years and " + days + " days");
    }
}