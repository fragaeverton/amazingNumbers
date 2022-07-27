package numbers;

import numbers.enums.Properties;
import numbers.enums.Status;

import java.util.Arrays;
import java.util.Scanner;

import static numbers.Main.generateNumbers;
import static numbers.Messages.*;
import static numbers.Main.*;
import static numbers.Messages.errorWrongProperty;

public class Input {
    static Status current;

    public static Status validateInput(Status st){
        current = st;
        Scanner sc = new Scanner(System.in);
        String data[] = sc.nextLine().split(" ");

        switch (data.length){
            case 1:
                if(checkOne(data[0])){
                    generateNumbers(Long.parseLong(data[0]), 0, Properties.NULL, Properties.NULL, Quantity.ONE);
                }
                break;
            case 2:
                if(checkOne(data[0]) && checkTwo(data[1])){
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), Properties.NULL, Properties.NULL, Quantity.TWO);
                }
                break;
            case 3:
                if(checkOne(data[0]) && checkTwo(data[1]) && checkThree(data[2], true)){
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), convertToEnum(data[2]), Properties.NULL, Quantity.THREE);
                }
                break;
            case 4:
                if(checkOne(data[0])
                        && checkTwo(data[1])
                        && checkFour(convertToEnum(data[2]), convertToEnum(data[3]), data)
                        && checkThree(data[2], true)
                        && checkThree(data[3], true)){
                    Properties p1 = convertToEnum(data[2]);
                    Properties p2 = (p1.equals(convertToEnum(data[3]))) ? Properties.NULL : convertToEnum(data[3]);
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), p1, p2, Quantity.FOUR);
                }
                break;
        }
        return current;
    }

    private static boolean checkOne(String one) {
        boolean isValid =  true;
        if (!one.matches("\\d+" ) || Long.parseLong(one) < 0){
            errorFirstParameter();
            isValid = false;
        } else {
            if(one.equals("0")){
                current = Status.FINISH;
                goodbye();
                isValid = false;
            }
        }
        return isValid;
    }

    private static boolean checkTwo(String two) {
        boolean isValid =  true;
        if (!two.matches("\\d+" ) || Long.parseLong(two) < 0){
            errorSecondParameter();
            isValid = false;
        }
        return isValid;
    }

    private static boolean checkThree(String three, boolean showError) {
        boolean isValid =  true;
        if (!Arrays.asList(propertiesList).contains(three.toUpperCase())){
            if (showError) {
                errorWrongProperty(propertiesList, three);
            }
            isValid = false;
        }
        return isValid;
    }

    private static boolean checkFour(Properties p1, Properties p2, String[] data) {
        boolean isValid =  true;
        if (p1.equals(Properties.EVEN) && p2.equals(Properties.ODD) || p1.equals(Properties.ODD) && p2.equals(Properties.EVEN)) {
            errorWrongCombination(p1, p2);
            isValid = false;
        }
        if (p1.equals(Properties.DUCK) && p2.equals(Properties.SPY) || p1.equals(Properties.SPY) && p2.equals(Properties.DUCK)) {
            errorWrongCombination(p1, p2);
            isValid = false;
        }
        if (p1.equals(Properties.SUNNY) && p2.equals(Properties.SQUARE) || p1.equals(Properties.SQUARE) && p2.equals(Properties.SUNNY)) {
            errorWrongCombination(p1, p2);
            isValid = false;
        }
        if(!checkThree(String.valueOf(p1), false) && !checkThree(String.valueOf(p2), false)){
            errorWrongProperties(propertiesList, data[2], data[3]);
            isValid = false;
        }

        return isValid;
    }

    private static Properties convertToEnum(String prop) {
        Properties properties;
        try {
            properties = Properties.valueOf(prop.toUpperCase());
        } catch (IllegalArgumentException e) {
            properties = Properties.NULL;
        }
        return properties;
    }

    public enum Quantity {
        ONE, TWO, THREE, FOUR
    }
}
