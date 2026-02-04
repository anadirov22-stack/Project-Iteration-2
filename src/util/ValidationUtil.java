package util;

public class ValidationUtil {

    public static boolean isValidText(String text) {
        return text != null && !text.trim().isEmpty();
    }

    public static boolean isPositive(double value) {
        return value > 0;
    }

    public static boolean isPositive(int value) {
        return value > 0;
    }
}

