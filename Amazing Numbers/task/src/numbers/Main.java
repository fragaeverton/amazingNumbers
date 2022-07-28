package numbers;

import numbers.enums.Status;
import numbers.enums.Properties;

import java.util.*;

import static numbers.Messages.*;
import static numbers.Rules.*;
import static numbers.Input.*;

public class Main {

    public static Status status;
    public static String[] propertiesListFull = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "EVEN", "ODD",
            "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-JUMPING", "-HAPPY", "-SAD", "-EVEN", "-ODD"
    };
    public static String[] propertiesList = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "EVEN", "ODD"};

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

    public static void generateNumbers(long startNumber, long times, List<Properties> propertiesArrayList, Quantity qtt) {
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
            default:
                for (long l = startNumber; l < range; l++) {
                    List<Boolean> areCommon = new ArrayList<>();
                    for (Properties properties : propertiesArrayList) {
                        areCommon.add(isValid(l, properties));
                    }
                    if(!areCommon.contains(false)){
                        numbers.add(l);
                    }else{
                        range++;
                    }
                }
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
            case JUMPING:
                if (isJumping(l)) {
                    isValid = true;
                }
                break;
            case HAPPY:
            case EX_SAD:
                if (isHappy(l)) {
                    isValid = true;
                }
                break;
            case SAD:
            case EX_HAPPY:
                if (!isHappy(l)) {
                    isValid = true;
                }
                break;
            case EVEN:
            case EX_ODD:
                if (isEven(l)) {
                    isValid = true;
                }
                break;
            case ODD:
            case EX_EVEN:
                if (isOdd(l)) {
                    isValid = true;
                }
                break;
            case EX_BUZZ:
                if (!isBuzz(l)) {
                    isValid = true;
                }
                break;
            case EX_DUCK:
                if (!isDuck(l)) {
                    isValid = true;
                }
                break;
            case EX_PALINDROMIC:
                if (!isPalindromic(l)) {
                    isValid = true;
                }
                break;
            case EX_GAPFUL:
                if (!isGapful(l)) {
                    isValid = true;
                }
                break;
            case EX_SPY:
                if (!isSpy(l)) {
                    isValid = true;
                }
                break;
            case EX_SUNNY:
                if (!isSunny(l)) {
                    isValid = true;
                }
                break;
            case EX_SQUARE:
                if (!isSquare(l)) {
                    isValid = true;
                }
                break;
            case EX_JUMPING:
                if (!isJumping(l)) {
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
        List<Boolean> jumpingList = new ArrayList<>();
        List<Boolean> happyList = new ArrayList<>();
        List<Boolean> sadList = new ArrayList<>();
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
            jumpingList.add(isJumping(l));
            happyList.add(isHappy(l));
            sadList.add(!isHappy(l));
            sunnyList.add(isSunny(l));
            squareList.add(isSquare(l));
        }
        printResolution(numbers,
                buzzList,
                duckList,
                palindromicList,
                gapfulList,
                spyList,
                sunnyList,
                squareList,
                jumpingList,
                happyList,
                sadList,
                evenList,
                oddList,
                qtt);
    }


    private static void printResolution(List<Long> numbers,
                                        List<Boolean> buzzList,
                                        List<Boolean> duckList,
                                        List<Boolean> palindromicList,
                                        List<Boolean> gapfulList,
                                        List<Boolean> spyList,
                                        List<Boolean> sunnyList,
                                        List<Boolean> squareList,
                                        List<Boolean> jumpingList,
                                        List<Boolean> happyList,
                                        List<Boolean> sadList,
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
                String jumping = (jumpingList.get(i)) ? "jumping, " : "";
                String happy = (happyList.get(i)) ? "happy, " : "";
                String sad = (sadList.get(i)) ? "sad, " : "";
                String type = (evenList.get(i)) ? "even" : "odd";
                System.out.println(numbers.get(i) + " is "
                        + buzz
                        + duck
                        + palindromic
                        + gapful
                        + spy
                        + square
                        + sunny
                        + jumping
                        + happy
                        + sad
                        + type);
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
                    "jumping: %b\n" +
                    "happy: %b\n" +
                    "sad: %b\n" +
                    "even: %b\n"+
                    "odd: %b\n", numbers.get(0),
                    buzzList.get(0),
                    duckList.get(0),
                    palindromicList.get(0),
                    gapfulList.get(0),
                    spyList.get(0),
                    squareList.get(0),
                    sunnyList.get(0),
                    jumpingList.get(0),
                    happyList.get(0),
                    sadList.get(0),
                    evenList.get(0),
                    oddList.get(0) );
        }

    }


}
