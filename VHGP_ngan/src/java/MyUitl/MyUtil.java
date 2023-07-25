package MyUitl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

    public static boolean isValidLength(String str) {
        return str != null && str.trim().length() >= 3;
    }

    public static boolean isValidInput(String str) {
        // Kiểm tra đầu vào có ít nhất 3 kí tự và không chứa các kí tự đặc biệt
        return str != null && str.trim().length() >= 3;
    }

    public static boolean isValidNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Boolean parseBoolean(String value) {
        if (value != null) {
            return Boolean.valueOf(value);
        }
        return null;
    }

    public static Date parseDate(String dateString, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}