package homework06;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        System.out.println("The smallest number between 1 2 and 3 is " + findSmallestNumber(1, 2, 3));
        System.out.println("The average number between 1 2 and 3 is " + computeAverageNumber(1, 2, 3));

        System.out.println("Exercise 2");
        displayMiddleChar("abcde");
        displayMiddleChar("abcd");

        System.out.println("Exercise 3");
        System.out.println("The number of words in the text is " + countWords("This is a text"));

        System.out.println("Exercise 4");
        System.out.println("The number 2 is even: " + isEven(2));

        System.out.println("Exercise 5");
        System.out.println("The number 12321 is a palindrome: " + isPalindrome());
    }

    public static double findSmallestNumber(double num1, double num2, double num3) {
        double smallestNumber = num1;

        if (smallestNumber > num2) {
            smallestNumber = num2;
        }

        if (smallestNumber > num3) {
            smallestNumber = num3;
        }

        return smallestNumber;
    }

    public static double computeAverageNumber(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    public static void displayMiddleChar(String value) {
        int position;
        int length;

        if (value.length() % 2 == 0) {
            position = value.length() / 2 - 1;
            length = 2;

        } else {
            position = value.length() / 2;
            length = 1;
        }

        System.out.println(value.substring(position, position + length));
    }

    public static int countWords(String text) {
        text = text.trim();
        int count = 0;
        int textLength = text.length();

        if (textLength > 1) {
            count++; //After trim() the text will always start with a word

            for (int i = 1; i < textLength; i++) {
                if (text.charAt(i) == ' ') {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPalindrome() {
        int remainder;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number ");

        int num = scanner.nextInt();

        if (num >= 0) {
            int palindrome = num;

            while (palindrome > 0) {
                remainder = palindrome % 10;
                sum = (sum * 10) + remainder;
                palindrome = palindrome / 10;
            }
            return num == sum;
        } else {
            System.out.println("The integer must be non-negative!");
            return false;
        }
    }
}
