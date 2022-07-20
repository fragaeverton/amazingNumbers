package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Status status;

    public static void main(String[] args) {

        System.out.print("Welcome to Amazing Numbers!\n\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;" +
                "- enter 0 to exit.\n");
        status = Status.REQUEST;

        while (status == Status.REQUEST) {
            startRequest();
        }

    }

    private static void startRequest() {
        System.out.print("\nEnter a request:");

        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        boolean isNatural = true;
        for (int i = 0; i < input.length; i++) {
            if (!input[i].matches("\\d+" ) || Long.parseLong(input[i]) < 0){
                System.out.println( (i == 0) ? "\nThe first parameter should be a natural number or zero." : "second parameter should be a natural number");
                isNatural = false;
                break;
            }
        }
        if (isNatural) {
            long n0 = Long.parseLong(input[0]);
            List<Long> numbers = new ArrayList<>();
            if (input.length > 1) {
                for (long i = n0; i < Long.parseLong(input[1]) + n0; i++) {
                    numbers.add(i);
                }
            } else{
                numbers.add(n0);
            }
            firstCheck(numbers);

        }

    }


    private static void firstCheck(List<Long> numbers) {
        if (numbers.get(0) < 0){
            System.out.println("\nThe first parameter should be a natural number or zero.");
        } else if (numbers.get(0) == 0){
            status = Status.FINISH;
            System.out.println("\nGoodbye!");
        } else {
            checkProperties(numbers);
        }

    }

    private static void checkProperties(List<Long> numbers) {

        List<Boolean> isEven = new ArrayList<>();
        List<Boolean> isOdd = new ArrayList<>();
        List<Boolean> isBuzz = new ArrayList<>();
        List<Boolean> isDuck = new ArrayList<>();
        List<Boolean> isPalindromic = new ArrayList<>();
        List<Boolean> isGapful = new ArrayList<>();

        for (long l : numbers){
            isOdd.add(l % 2 != 0);
            isEven.add(l % 2 == 0);
            isBuzz.add(l % 7 == 0 | l % 10 == 7);
            isDuck.add(String.valueOf(l).contains("0"));

            String palindromic = "" + l;
            StringBuilder sb = new StringBuilder();
            for (int i = (palindromic.length() - 1); i >=0; --i){
                sb.append(palindromic.charAt(i));
            }
            isPalindromic.add(palindromic.equals(String.valueOf(sb)));

            String gapful = "" + l;
            int n1 = Integer.parseInt(String.valueOf(gapful.charAt(0))) * 10;
            int n2 = Integer.parseInt(String.valueOf(gapful.charAt(gapful.length() - 1)));
            isGapful.add(gapful.length() > 2 && l % (n1 + n2) == 0);
        }
        printResolution(numbers, isBuzz, isDuck, isPalindromic, isGapful, isEven, isOdd);
    }


    private static void printResolution(List<Long> numbers, List<Boolean> isBuzz, List<Boolean> isDuck, List<Boolean> isPalindromic, List<Boolean> isGapful, List<Boolean> isEven, List<Boolean> isOdd) {
        if (numbers.size() > 1){
            for (int i = 0; i < numbers.size(); i++) {
                String buzz = (isBuzz.get(i)) ? "buzz, " : "";
                String duck = (isDuck.get(i)) ? "duck, " : "";
                String palindromic = (isPalindromic.get(i)) ? "palindromic, " : "";
                String gapful = (isGapful.get(i)) ? "gapful, " : "";
                String type = (isEven.get(i)) ? "even" : "odd";
                System.out.println(numbers.get(i) + " is " + buzz + duck + palindromic + gapful + type);
            }
        } else {
            System.out.printf("\nProperties of %d\n" +
                    "buzz: %b\n"+
                    "duck: %b\n"+
                    "palindromic: %b\n" +
                    "gapful: %b\n" +
                    "even: %b\n"+
                    "odd: %b\n", numbers.get(0), isBuzz.get(0), isDuck.get(0), isPalindromic.get(0), isGapful.get(0), isEven.get(0), isOdd.get(0) );
        }

    }

    public enum Status {
        REQUEST, FINISH
    }

}
