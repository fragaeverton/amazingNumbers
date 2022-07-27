package numbers;

import java.util.Arrays;
import numbers.enums.Properties;

public class Messages {

    public static void welcome(){
        System.out.print("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    public static void enterRequest(){
        System.out.print("\nEnter a request: ");
    }

    public static void errorFirstParameter(){
        System.out.println(  "\nThe first parameter should be a natural number or zero.");
    }

    public static void errorSecondParameter(){
        System.out.println(  "\nThe second parameter should be a natural number.");
    }

    public static void errorWrongProperty(String[] propertiesList, String s){
        System.out.printf("\nThe property [%s] is wrong.\n" +
                "Available properties: " + Arrays.toString(propertiesList) + "\n", s.toUpperCase());
    }

    public static void errorWrongProperties(String[] propertiesList, String p1, String p2){
        System.out.printf("\nThe properties [%s, %s] are wrong.\n" +
                "Available properties: " + Arrays.toString(propertiesList) + "\n", p1, p2);
    }

    public static void errorWrongCombination(Properties first, Properties second){
        System.out.printf("\nThe request contains mutually exclusive properties: [%s, %s]\n" +
                "There are no numbers with these properties.\n", first, second);
    }

    public static void goodbye(){
        System.out.println("\nGoodbye!");
    }
}
