package my.home.webapp.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {

    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        ResourceBundle translations = ResourceBundle.getBundle("translations", locale);
    }
}
