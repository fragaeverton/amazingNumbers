package numbers;

import java.util.Scanner;

public class Main {

    public static boolean isEven;
    public static boolean isOdd;
    public static boolean isBuzz;
    public static boolean isDuck;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = sc.nextInt();

        checkIfIsNatural(number);
        checkIfIsOddOrEven(number);
        checkIfIsBuzz(number);
        checkIfIsDuck(number);
        printResolution(number);

    }



    private static void checkIfIsNatural(int number) {
        if (number < 1){
            System.out.println("This number is not natural!");
            System.exit(0);
        }
    }

    private static void checkIfIsOddOrEven(int number) {
        if (number % 2 != 0){
            isOdd = true;
        } else {
            isEven = true;
        }
    }

    private static void checkIfIsBuzz(int number) {
        if (number % 7 == 0 | number % 10 == 7){
            isBuzz = true;
        }
    }

    private static void checkIfIsDuck(int number) {
        if (String.valueOf(number).contains("0")) {
            isDuck = true;
        }
    }

    private static void printResolution(int number) {
        System.out.printf("Properties of %d\n" +
                "even: %b\n"+
                "odd: %b\n"+
                "buzz: %b\n"+
                "duck: %b", number, isEven, isOdd, isBuzz, isDuck);
    }


}
