package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean stringIsNumber(String input){
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

}
