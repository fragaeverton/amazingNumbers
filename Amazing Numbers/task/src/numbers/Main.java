package numbers;

import numbers.enums.Status;
import numbers.enums.Properties;

import java.util.*;

import static numbers.Messages.*;
import static numbers.Rules.*;
import static numbers.Input.*;

public class Main {

    public static Status status;
    public static String[] propertiesList = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "EVEN", "ODD"};

    public static void main(String[] args) {

        welcome();

        status = Status.REQUEST;

        while (status == Status.REQUEST) {
            startRequest();
        }

    }

    private static void startRequest() {
        enterRequest();
        status =  validateInput(status);
    }

    public static void generateNumbers(long startNumber, long times, Properties p1, Properties p2, Quantity qtt) {
        List<Long> numbers = new ArrayList<>();
        long range = startNumber + times;
        switch (qtt){
            case ONE:
                numbers.add(startNumber);
                break;
            case TWO:
                for (long l = startNumber; l < range; l++) {
                    numbers.add(l);
                }
                break;
            case THREE:
                for (long l = startNumber; l < range; l++) {
                    if(isValid(l, p1)){
                        numbers.add(l);
                    }else{
                        range++;
                    }
                }
                break;
            case FOUR:
                for (long l = startNumber; l < range; l++) {
                    if(isValid(l, p1) && isValid(l, p2)){
                        numbers.add(l);
                    }else{
                        range++;
                    }
                }
                break;
        }


        checkProperties(numbers, qtt);

    }

    private static boolean isValid(long l, Properties p1){
        boolean isValid = false;
        switch (p1){
            case BUZZ:
                if (isBuzz(l)) {
                    isValid = true;
                }
                break;
            case DUCK:
                if (isDuck(l)) {
                    isValid = true;
                }
                break;
            case PALINDROMIC:
                if (isPalindromic(l)) {
                    isValid = true;
                }
                break;
            case GAPFUL:
                if (isGapful(l)) {
                    isValid = true;
                }
                break;
            case SPY:
                if (isSpy(l)) {
                    isValid = true;
                }
                break;
            case SUNNY:
                if (isSunny(l)) {
                    isValid = true;
                }
                break;
            case SQUARE:
                if (isSquare(l)) {
                    isValid = true;
                }
                break;
            case EVEN:
                if (isEven(l)) {
                    isValid = true;
                }
                break;
            case ODD:
                if (isOdd(l)) {
                    isValid = true;
                }
                break;
        }
        return isValid;
    }

    private static void checkProperties(List<Long> numbers, Quantity qtt) {

        List<Boolean> evenList = new ArrayList<>();
        List<Boolean> oddList = new ArrayList<>();
        List<Boolean> buzzList = new ArrayList<>();
        List<Boolean> duckList = new ArrayList<>();
        List<Boolean> palindromicList = new ArrayList<>();
        List<Boolean> gapfulList = new ArrayList<>();
        List<Boolean> spyList = new ArrayList<>();
        List<Boolean> squareList = new ArrayList<>();
        List<Boolean> sunnyList = new ArrayList<>();

        for (long l : numbers){
            oddList.add(isOdd(l));
            evenList.add(isEven(l));
            buzzList.add(isBuzz(l));
            duckList.add(isDuck(l));
            palindromicList.add(isPalindromic(l));
            gapfulList.add(isGapful(l));
            spyList.add(isSpy(l));
            sunnyList.add(isSunny(l));
            squareList.add(isSquare(l));
        }
        printResolution(numbers, buzzList, duckList, palindromicList, gapfulList, spyList, sunnyList, squareList, evenList, oddList, qtt);
    }


    private static void printResolution(List<Long> numbers,
                                        List<Boolean> buzzList,
                                        List<Boolean> duckList,
                                        List<Boolean> palindromicList,
                                        List<Boolean> gapfulList,
                                        List<Boolean> spyList,
                                        List<Boolean> sunnyList,
                                        List<Boolean> squareList,
                                        List<Boolean> evenList,
                                        List<Boolean> oddList,
                                        Quantity qtt) {
        if (!qtt.equals(Quantity.ONE)){
            System.out.println();
            for (int i = 0; i < numbers.size(); i++) {
                String buzz = (buzzList.get(i)) ? "buzz, " : "";
                String duck = (duckList.get(i)) ? "duck, " : "";
                String palindromic = (palindromicList.get(i)) ? "palindromic, " : "";
                String gapful = (gapfulList.get(i)) ? "gapful, " : "";
                String spy = (spyList.get(i)) ? "spy, " : "";
                String square = (squareList.get(i)) ? "square, " : "";
                String sunny = (sunnyList.get(i)) ? "sunny, " : "";
                String type = (evenList.get(i)) ? "even" : "odd";
                System.out.println(numbers.get(i) + " is " + buzz + duck + palindromic + gapful + spy + square + sunny + type);
            }
        } else {
            System.out.printf("\nProperties of %d\n" +
                    "buzz: %b\n"+
                    "duck: %b\n"+
                    "palindromic: %b\n" +
                    "gapful: %b\n" +
                    "spy: %b\n" +
                    "square: %b\n" +
                    "sunny: %b\n" +
                    "even: %b\n"+
                    "odd: %b\n", numbers.get(0),
                    buzzList.get(0),
                    duckList.get(0),
                    palindromicList.get(0),
                    gapfulList.get(0),
                    spyList.get(0),
                    squareList.get(0),
                    sunnyList.get(0),
                    evenList.get(0),
                    oddList.get(0) );
        }

    }


}
