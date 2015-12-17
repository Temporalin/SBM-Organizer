package challonge.model.parser;

import java.text.SimpleDateFormat;

/**
 * @author Nicholas Hauschild
 *         Date: 5/13/13
 *         Time: 8:02 PM
 */
public class DateFormats {
    public static final ThreadLocal<SimpleDateFormat> PARSER_SDF = new ThreadLocal<SimpleDateFormat>() {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        }
    };

    public static final ThreadLocal <SimpleDateFormat> REQUEST_SDF = new ThreadLocal <SimpleDateFormat> () {
        @Override protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
}
