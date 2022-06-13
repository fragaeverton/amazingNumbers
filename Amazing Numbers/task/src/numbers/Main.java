package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int number = sc.nextInt();

        checkIfIsNatural(number);
        checkIfIsOddOrEven(number);
        boolean isDivisible = checkIfIsDivisibleBySeven(number);
        boolean isEndingSeven = checkIfIsEndingBySeven(number);

        printResolution(isDivisible, isEndingSeven, number);

    }


    private static void checkIfIsNatural(int number) {
        if (number < 1){
            System.out.println("This number is not natural!");
            System.exit(0);
        }
    }

    private static void checkIfIsOddOrEven(int number) {
        System.out.println(number % 2 != 0 ? "This number is Odd." : "This number is Even.");
    }

    private static boolean checkIfIsDivisibleBySeven(int number) {
        return number % 7 == 0;
    }

    private static boolean checkIfIsEndingBySeven(int number) {
        return number % 10 == 7;
    }

    private static void printResolution(boolean isDivisible, boolean isEndingSeven, int number) {

        System.out.println(isDivisible | isEndingSeven ? "It is a Buzz number." : "It is not a Buzz number.");
        System.out.println("Explanation:");
        if (isDivisible) {
            if (isEndingSeven) {
                System.out.printf("%d is divisible by 7 and ends with 7.", number);
            } else {
                System.out.printf("%d is divisible by 7.", number);
            }
        } else {
            if (isEndingSeven) {
                System.out.printf("%d ends with 7.", number);
            } else {
                System.out.printf("%d is neither divisible by 7 nor does it end with 7.", number);
            }
        }

    }
}
