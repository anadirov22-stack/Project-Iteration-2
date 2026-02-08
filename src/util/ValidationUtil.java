package util;

import java.util.function.Predicate;

public class ValidationUtil {

    //  ЛЯМБДА
    private static final Predicate<String> TEXT_VALID =
            text -> text != null && !text.trim().isEmpty();

    private static final Predicate<Number> POSITIVE =
            num -> num.doubleValue() > 0;

    public static boolean isValidText(String text) {
        return TEXT_VALID.test(text);
    }

    public static boolean isPositive(double value) {
        return POSITIVE.test(value);
    }

    public static boolean isPositive(int value) {
        return POSITIVE.test(value);
    }
}

