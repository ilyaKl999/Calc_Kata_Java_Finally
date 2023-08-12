import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UncheckedUserException {
        Scanner scanner = new Scanner(System.in);
        String userExpression = scanner.nextLine();
        Kata_Calc_LikeMentor_metod.calc(userExpression);
        String output = Kata_Calc_LikeMentor_metod.calc(userExpression);
        System.out.println(output);
    }
}
class Kata_Calc_LikeMentor_metod {
    public static String calc(String input) throws UncheckedUserException {

        String result = null;

        String[] rome = {"Ave, Caesar", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII",
                "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII",
                "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        String[] arrayUserExpression = input.split(" ");
        if (arrayUserExpression.length < 3) {
            throw new UncheckedUserException("строка не является математической операцией");
        }
        if (arrayUserExpression.length > 3) {
            throw new UncheckedUserException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String userVariableOne = arrayUserExpression[0];
        String userVariableTwo = arrayUserExpression[2];
        String userOperation = arrayUserExpression[1];
        try {
            ROMEENUM f1 = ROMEENUM.valueOf(userVariableOne);
            ROMEENUM f2 = ROMEENUM.valueOf(userVariableTwo);
            try {


                if (f1 != null) {
                    if (f2 != null) {
                        switch (userOperation) {
                            case "+":
                                int w = f1.x + f2.x;
                                result = rome[w];
                                return result;

                            case "-":
                                int p = f1.x - f2.x;
                                if (p == 0) {
                                    throw new UncheckedUserException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
                                }
                                result = rome[p];
                                return result;
                            case "/":
                                int o = f1.x / f2.x;
                                result = rome[o];
                                return result;
                            case "*":
                                int n = f1.x * f2.x;
                                result = rome[n];
                                return result;
                            default:
                                throw new UncheckedUserException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException p) {
                throw new ArrayIndexOutOfBoundsException("в римской системе нет отрицательных чисел");
            }
        } catch (IllegalArgumentException digit) {
            try {
                int prov1 = Integer.parseInt(arrayUserExpression[0]);
            } catch (NumberFormatException fd) {
                try {
                    int prov2 = Integer.parseInt(arrayUserExpression[2]);
                } catch (NumberFormatException fdsds) {
                    throw new NumberFormatException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
                }
            }
            try {
                int prov1 = Integer.parseInt(arrayUserExpression[0]);
                int prov2 = Integer.parseInt(arrayUserExpression[2]);
            } catch (NumberFormatException dsf53dsas) {
                throw new NumberFormatException("используются одновременно разные системы счисления");
            }


            int a3 = Integer.parseInt(arrayUserExpression[0]);
            int b3 = Integer.parseInt(arrayUserExpression[2]);
            String operand = arrayUserExpression[1];
            if (a3 > 10 | a3 < 1 | b3 > 10 | b3 < 1) {
                throw new UncheckedUserException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
            }

            switch (operand) {

                case "+":
                    int w = a3 + b3;
                    result = Integer.toString(w);
                    return result;
                case "-":
                    int p = a3 - b3;
                    result = Integer.toString(p);
                    return result;
                case "/":

                    int o = a3 / b3;
                    result = Integer.toString(o);
                    return result;
                case "*":
                    int n = a3 * b3;
                    result = Integer.toString(n);
                    return result;
                default:
                    throw new UncheckedUserException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }


        return result;
    }

}

class UncheckedUserException extends Exception {
    public UncheckedUserException(String message) {
        super(message);

    }
}

enum ROMEENUM {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    public int x;

    ROMEENUM(int x) {
        this.x = x;
    }
}

