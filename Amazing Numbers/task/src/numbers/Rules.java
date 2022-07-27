package numbers;

public class Rules {
    public static boolean isBuzz(long number){
        return (number % 7 == 0 | number % 10 == 7);
    }

    public static boolean isDuck(long number){
        return String.valueOf(number).contains("0");
    }

    public static boolean isPalindromic(long number){
        String palindromic = "" + number;
        StringBuilder sb = new StringBuilder();
        for (int i = (palindromic.length() - 1); i >=0; --i){
            sb.append(palindromic.charAt(i));
        }
        return palindromic.equals(String.valueOf(sb));
    }

    public static boolean isGapful(long number){
        String gapful = "" + number;
        int n1 = Integer.parseInt(String.valueOf(gapful.charAt(0))) * 10;
        int n2 = Integer.parseInt(String.valueOf(gapful.charAt(gapful.length() - 1)));
        return (gapful.length() > 2 && number % (n1 + n2) == 0);
    }

    public static boolean isSpy(long number){
        String[] digits = ("" + number).split("");
        int product = 1, sum = 0;
        for (String s : digits) {
            int i = Integer.parseInt(s);
            product = product * i;
            sum += i;
        }
        return sum == product;
    }

    public static boolean isEven(long number){
        return number % 2 == 0;
    }

    public static boolean isOdd(long number){
        return number % 2 != 0;
    }

    public static boolean isSunny(long number){
        return ((Math.sqrt(number + 1) - Math.floor(Math.sqrt(number + 1))) == 0);
    }

    public static boolean isSquare(long number){
        return ((Math.sqrt(number) - Math.floor(Math.sqrt(number))) == 0);
    }
}
