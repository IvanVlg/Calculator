import java.util.Scanner;

public class Main {

    public final static String[] ROME_NUMBERS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C", "CI", "CII", "CIII", "CIV", "CV", "CVI", "CVII", "CVIII", "CIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV",
            "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    private static String[] strSplit = null;
    private static int param1 = -1;
    private static int param2 = -1;
    private static int result = 0;

    private static boolean isArabian;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        calc(str);
    }

    public static String calc(String input) {

        CalculationManager calc = new CalculationManager();

        if (input.contains("+")) {
            strSplit = input.split("[+]");

            checkTwoParameters();
            fillParameters();
            calc.checkIntParams(param1, param2);

            result = calc.addition(param1, param2);

        } else if (input.contains("-")) {
            strSplit = input.split("[-]");

            checkTwoParameters();
            fillParameters();
            calc.checkIntParams(param1, param2);

            result = calc.subtraction(param1, param2);

        } else if (input.contains("*")) {
            strSplit = input.split("[*]");

            checkTwoParameters();
            fillParameters();
            calc.checkIntParams(param1, param2);

            result = calc.multiplication(param1, param2);

        } else if (input.contains("/")) {
            strSplit = input.split("[/]");

            checkTwoParameters();
            fillParameters();
            calc.checkIntParams(param1, param2);

            if (param2 == 0) {

                throw new CalculatorException("ERROR:You can't divide by zero.");
            }

            result = calc.division(param1, param2);

        } else {
            throw new CalculatorException("ERROR:You entered incorrect data.");
        }
        if (isArabian) {
            System.out.println(result);

            return String.valueOf(result);
        }
        if (result <= 0) {
            throw new CalculatorException("ERROR:Negative result.");
        }
        System.out.println(ROME_NUMBERS[result - 1]);
        return ROME_NUMBERS[result - 1];
    }

    public static void fillParameters() {
        for (int i = 0; i < 10; i++) {
            if (strSplit[0].equals(ROME_NUMBERS[i])) {
                param1 = i + 1;
            }
            if (strSplit[1].equals(ROME_NUMBERS[i])) {
                param2 = i + 1;
            }

            }

        if (param1 == -1 && param2 == -1) {
            param1 = Integer.parseInt(strSplit[0]);
            param2 = Integer.parseInt(strSplit[1]);
            isArabian = true;
        }
    }

    public static void checkTwoParameters() {
        if (strSplit.length != 2) {
            throw new CalculatorException("ERROR:You entered incorrect data.");
        }
    }
}
