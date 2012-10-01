package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextHelper {
    private static SimpleDateFormat timestampFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

    public static String formatTimestamp(Date date) {
        if (date != null) {
            return timestampFormat.format(date);
        } else {
            return "[no date]";
        }
    }

    public static String formatMultiLineText(String text) {
        return text.replace("\n", "<br/>\n");
    }
}
