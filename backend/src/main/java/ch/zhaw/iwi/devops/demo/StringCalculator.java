package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
    
        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterStart = numbers.indexOf("//") + 2;
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(delimiterStart, delimiterEnd);
            delimiter = delimiter.substring(1, delimiter.length() ); // Remove the brackets
            delimiter = delimiter.replace("][", "|"); // Replace ][ with | to create a regex pattern
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }
        
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            int number = Integer.parseInt(part);
            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }
    
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives.toString());
        }
    
        return sum;
    }
}