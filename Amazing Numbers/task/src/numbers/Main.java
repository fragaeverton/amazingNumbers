package numbers;

import java.util.Scanner;

public class Main {

    public static boolean isEven;
    public static boolean isOdd;
    public static boolean isBuzz;
    public static boolean isDuck;
    public static boolean isPalindromic;
    public static Status status;

    public static void main(String[] args) {

        System.out.print("Welcome to Amazing Numbers!\n\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter 0 to exit.\n");
        status = Status.REQUEST;

        while (status == Status.REQUEST) {
            startRequest();
        }

    }

    private static void startRequest() {
        System.out.print("\nEnter a request:");

        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();

        firstCheck(number);
    }


    private static void firstCheck(long number) {
        if (number < 0){
            System.out.println("\nThe first parameter should be a natural number or zero.");
        } else if (number == 0){
            status = Status.FINISH;
            System.out.println("\nGoodbye!");
        } else {
            checkIfIsOddOrEven(number);
            checkIfIsBuzz(number);
            checkIfIsDuck(number);
            checkIfIsPalindromic(number);
            printResolution(number);
        }
    }

    private static void checkIfIsOddOrEven(long number) {
        isOdd = number % 2 != 0;
        isEven = number % 2 == 0;
    }

    private static void checkIfIsBuzz(long number) {
        isBuzz = number % 7 == 0 | number % 10 == 7;
    }

    private static void checkIfIsDuck(long number) {
        isDuck = String.valueOf(number).contains("0");
    }

    private static void checkIfIsPalindromic(long number) {
        String palindromic = "" + number;
        StringBuilder sb = new StringBuilder();
        for (int i = (palindromic.length() - 1); i >=0; --i){
            sb.append(palindromic.charAt(i));
        }
        isPalindromic = palindromic.equals(String.valueOf(sb));
    }

    private static void printResolution(long number) {
        System.out.printf("Properties of %d\n" +
                "even: %b\n"+
                "odd: %b\n"+
                "buzz: %b\n"+
                "duck: %b\n"+
                "palindromic: %b\n", number, isEven, isOdd, isBuzz, isDuck, isPalindromic);
    }

    public enum Status {
        REQUEST, FINISH
    }

}
