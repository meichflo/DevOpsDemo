package ch.zhaw.iwi.devops.demo;

public class check_value {

    public static boolean isAlphabetical(String input) {
        return input != null && input.matches("^[a-zA-Z]*$");
    }
    
}

