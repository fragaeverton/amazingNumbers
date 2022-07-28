package numbers;

import numbers.enums.Properties;
import numbers.enums.Status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String[] data = sc.nextLine().split(" ");
        List<Properties> propertiesArrayList = new ArrayList<>();

        switch (data.length){
            case 1:
                if(isFirstAttCorrect(data)){
                    generateNumbers(Long.parseLong(data[0]), 0, propertiesArrayList, Quantity.ONE);
                }
                break;
            case 2:
                if(isSecondAttCorrect(data)){
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), propertiesArrayList, Quantity.TWO);
                }
                break;
            case 3:
                propertiesArrayList.add(convertToEnum(data[2]));
                if(isSecondAttCorrect(data) && isUniquePropertyCorrect(data[2], true)){
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), propertiesArrayList, Quantity.THREE);
                }
                break;
            default:
                for (int i = 2; i < data.length; i++) {
                    if (!propertiesArrayList.contains(convertToEnum(data[i]))) {
                        propertiesArrayList.add(convertToEnum(data[i]));
                    }
                }
                if(isSecondAttCorrect(data)
                        && isAllPropertiesCorrect(data)){
                    generateNumbers(Long.parseLong(data[0]), Long.parseLong(data[1]), propertiesArrayList, Quantity.MULTIPLE);
                }
                break;
        }
        return current;
    }

    private static boolean isFirstAttCorrect(String[] data) {
        boolean isValid =  true;
        String one = data[0];
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

    private static boolean isSecondAttCorrect(String[] data) {
        boolean isValid =  isFirstAttCorrect(data);
        String two = data[1];
        if (!two.matches("\\d+" ) || Long.parseLong(two) < 0){
            errorSecondParameter();
            isValid = false;
        }
        return isValid;
    }

    private static boolean isUniquePropertyCorrect(String three, boolean showError) {
        boolean isValid =  true;
        if (!Arrays.asList(propertiesListFull).contains(three.toUpperCase())){
            if (showError) {
                errorWrongProperty(three);
            }
            isValid = false;
        }
        return isValid;
    }

    private static boolean isAllPropertiesCorrect(String[] data) {
        boolean isValid =  true;
        List<Properties> propertiesArray = new ArrayList<>();
        List<String> invalidList = new ArrayList<>();
        for(int p = 2; p < data.length; p++){
            propertiesArray.add(convertToEnum(data[p]));
            if(!isUniquePropertyCorrect(data[p], false)){
                invalidList.add(String.valueOf(data[p]));
                isValid = false;
            }
        }
        if (invalidList.size() > 0) {
            if (invalidList.size() > 1) {
                errorWrongProperties(invalidList);
            }else{
                errorWrongProperty(invalidList.get(0));
            }
        }
        if (propertiesArray.contains(Properties.EVEN) && propertiesArray.contains(Properties.ODD)) {
            errorWrongCombination(Properties.EVEN, Properties.ODD);
            isValid = false;
        }
        if (propertiesArray.contains(Properties.EX_EVEN) && propertiesArray.contains(Properties.EX_ODD)) {
            errorWrongCombination(Properties.EX_EVEN, Properties.EX_ODD);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.DUCK) && propertiesArray.contains(Properties.SPY)) {
            errorWrongCombination(Properties.DUCK, Properties.SPY);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.SUNNY) && propertiesArray.contains(Properties.SQUARE)) {
            errorWrongCombination(Properties.SUNNY, Properties.SQUARE);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.HAPPY) && propertiesArray.contains(Properties.SAD)) {
            errorWrongCombination(Properties.HAPPY, Properties.SAD);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.EVEN) && propertiesArray.contains(Properties.EX_EVEN)) {
            errorWrongCombination(Properties.EVEN, Properties.EX_EVEN);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.ODD) && propertiesArray.contains(Properties.EX_ODD)) {
            errorWrongCombination(Properties.ODD, Properties.EX_ODD);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.BUZZ) && propertiesArray.contains(Properties.EX_BUZZ)) {
            errorWrongCombination(Properties.BUZZ, Properties.EX_BUZZ);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.DUCK) && propertiesArray.contains(Properties.EX_DUCK)) {
            errorWrongCombination(Properties.DUCK, Properties.EX_DUCK);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.EX_PALINDROMIC) && propertiesArray.contains(Properties.PALINDROMIC)) {
            errorWrongCombination(Properties.EX_PALINDROMIC, Properties.PALINDROMIC);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.GAPFUL) && propertiesArray.contains(Properties.EX_GAPFUL)) {
            errorWrongCombination(Properties.GAPFUL, Properties.EX_GAPFUL);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.SPY) && propertiesArray.contains(Properties.EX_SPY)) {
            errorWrongCombination(Properties.SPY, Properties.EX_SPY);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.SUNNY) && propertiesArray.contains(Properties.EX_SUNNY)) {
            errorWrongCombination(Properties.SUNNY, Properties.EX_SUNNY);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.SQUARE) && propertiesArray.contains(Properties.EX_SQUARE)) {
            errorWrongCombination(Properties.SQUARE, Properties.EX_SQUARE);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.JUMPING) && propertiesArray.contains(Properties.EX_JUMPING)) {
            errorWrongCombination(Properties.JUMPING, Properties.EX_JUMPING);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.SAD) && propertiesArray.contains(Properties.EX_SAD)) {
            errorWrongCombination(Properties.SAD, Properties.EX_SAD);
            isValid = false;
        }
        if  (propertiesArray.contains(Properties.HAPPY) && propertiesArray.contains(Properties.EX_HAPPY)) {
            errorWrongCombination(Properties.HAPPY, Properties.EX_HAPPY);
            isValid = false;
        }
        return isValid;
    }

    private static Properties convertToEnum(String prop) {
        prop = prop.charAt(0) == '-' ? prop.replace("-", "EX_") : prop;
        Properties properties;
        try {
            properties = Properties.valueOf(prop.toUpperCase());
        } catch (IllegalArgumentException e) {
            properties = Properties.NULL;
        }
        return properties;
    }

    public enum Quantity {
        ONE, TWO, THREE, MULTIPLE
    }
}
