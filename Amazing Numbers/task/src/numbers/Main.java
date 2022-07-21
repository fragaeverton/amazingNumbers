package numbers;

import java.util.*;

public class Main {

    public static Status status;
    public static String[] propertiesList = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD"};

    public static void main(String[] args) {

        System.out.print("Welcome to Amazing Numbers!\n\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
        status = Status.REQUEST;

        while (status == Status.REQUEST) {
            startRequest();
        }

    }

    private static void startRequest() {
        System.out.print("\nEnter a request: ");

        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        switch (input.length){
            case 1:
                if (!input[0].matches("\\d+" ) || Long.parseLong(input[0]) < 0){
                    System.out.println(  "\nThe first parameter should be a natural number or zero.");
                } else {
                    if(input[0].equals("0")){
                        status = Status.FINISH;
                        System.out.println("\nGoodbye!");
                    }else{
                        generateNumbers(input, 1);
                    }

                }
                break;
            case 2:
                if (!input[1].matches("\\d+" ) || Long.parseLong(input[1]) < 0){
                    System.out.println(  "\nsecond parameter should be a natural number");
                } else{
                    generateNumbers(input, 2);
                }
                break;
            case 3:
                if (!Arrays.asList(propertiesList).contains(input[2].toUpperCase())){
                    System.out.printf("\nThe property [%s] is wrong.\n" +
                            "Available properties: " + Arrays.toString(propertiesList) + "\n", input[2].toUpperCase());
                } else {
                    generateNumbers(input, 3);
                }
                break;
        }

    }
    private static void generateNumbers(String[] input, int parameter) {
        List<Long> numbers = new ArrayList<>();
        long l1 = Long.parseLong(input[0]);
        switch (parameter){
            case 1:
                numbers.add(l1);
                break;
            case 2:
            case 3:
                long n = Long.parseLong(input[1]);
                long range = l1 + n;
                for (long l = l1; l < range; l++) {
                    if(parameter == 2){
                        numbers.add(l);
                    }
                    if(parameter == 3){
                        switch (Properties.valueOf(input[2].toUpperCase())){
                            case BUZZ:
                                if (isBuzz(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case DUCK:
                                if (isDuck(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case PALINDROMIC:
                                if (isPalindromic(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case GAPFUL:
                                if (isGapful(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case SPY:
                                if (isSpy(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case EVEN:
                                if (isEven(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                            case ODD:
                                if (isOdd(l)) {
                                    numbers.add(l);
                                }else{
                                    range++;
                                }
                                break;
                        }
                    }
                }
                break;
        }
        checkProperties(numbers, parameter);

    }

    private static void checkProperties(List<Long> numbers, int parameter) {

        List<Boolean> evenList = new ArrayList<>();
        List<Boolean> oddList = new ArrayList<>();
        List<Boolean> buzzList = new ArrayList<>();
        List<Boolean> duckList = new ArrayList<>();
        List<Boolean> palindromicList = new ArrayList<>();
        List<Boolean> gapfulList = new ArrayList<>();
        List<Boolean> spyList = new ArrayList<>();

        for (long l : numbers){
            oddList.add(isOdd(l));
            evenList.add(isEven(l));
            buzzList.add(isBuzz(l));
            duckList.add(isDuck(l));
            palindromicList.add(isPalindromic(l));
            gapfulList.add(isGapful(l));
            spyList.add(isSpy(l));
        }
        printResolution(numbers, buzzList, duckList, palindromicList, gapfulList, spyList, evenList, oddList, parameter);
    }


    private static void printResolution(List<Long> numbers, List<Boolean> buzzList, List<Boolean> duckList, List<Boolean> palindromicList, List<Boolean> gapfulList, List<Boolean> spyList, List<Boolean> evenList, List<Boolean> oddList, int parameter) {
        if (parameter > 1){
            System.out.println();
            for (int i = 0; i < numbers.size(); i++) {
                String buzz = (buzzList.get(i)) ? "buzz, " : "";
                String duck = (duckList.get(i)) ? "duck, " : "";
                String palindromic = (palindromicList.get(i)) ? "palindromic, " : "";
                String gapful = (gapfulList.get(i)) ? "gapful, " : "";
                String spy = (spyList.get(i)) ? "spy, " : "";
                String type = (evenList.get(i)) ? "even" : "odd";
                System.out.println(numbers.get(i) + " is " + buzz + duck + palindromic + gapful + spy + type);
            }
        } else {
            System.out.printf("\nProperties of %d\n" +
                    "buzz: %b\n"+
                    "duck: %b\n"+
                    "palindromic: %b\n" +
                    "gapful: %b\n" +
                    "spy: %b\n" +
                    "even: %b\n"+
                    "odd: %b\n", numbers.get(0), buzzList.get(0), duckList.get(0), palindromicList.get(0), gapfulList.get(0), spyList.get(0), evenList.get(0), oddList.get(0) );
        }

    }

    private static boolean isBuzz(long number){
        return (number % 7 == 0 | number % 10 == 7);
    }

    private static boolean isDuck(long number){
        return String.valueOf(number).contains("0");
    }

    private static boolean isPalindromic(long number){
        String palindromic = "" + number;
        StringBuilder sb = new StringBuilder();
        for (int i = (palindromic.length() - 1); i >=0; --i){
            sb.append(palindromic.charAt(i));
        }
        return palindromic.equals(String.valueOf(sb));
    }

    private static boolean isGapful(long number){
        String gapful = "" + number;
        int n1 = Integer.parseInt(String.valueOf(gapful.charAt(0))) * 10;
        int n2 = Integer.parseInt(String.valueOf(gapful.charAt(gapful.length() - 1)));
        return (gapful.length() > 2 && number % (n1 + n2) == 0);
    }

    private static boolean isSpy(long number){
        String[] digits = ("" + number).split("");
        int product = 1, sum = 0;
        for (String s : digits) {
            int i = Integer.parseInt(s);
            product = product * i;
            sum += i;
        }
        return sum == product;
    }

    private static boolean isEven(long number){
        return number % 2 == 0;
    }

    private static boolean isOdd(long number){
        return number % 2 != 0;
    }

    public enum Status {
        REQUEST, FINISH
    }

    public enum Properties{
        BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD
    }

}
