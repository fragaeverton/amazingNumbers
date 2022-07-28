package numbers;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> getDigit(long number){
        List<Integer> digits = new ArrayList<>();
        while (number > 0){
            digits.add((int) (number % 10));
            number /= 10;
        }
        return digits;
    }
}
