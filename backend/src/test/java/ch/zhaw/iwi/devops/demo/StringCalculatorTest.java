package ch.zhaw.iwi.devops.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator calculator = new StringCalculator();

        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1"));
        //assertEquals(3, calculator.add("1,2"));
        //assertEquals(10, calculator.add("1,2,3,4"));
        //assertEquals(6, calculator.add("1\n2,3"));
        //assertEquals(3, calculator.add("//[;]\n1;2"));
        //assertEquals(6, calculator.add("//[===]\n1===2===3"));
        //assertEquals(6, calculator.add("//[=][%]\n1=2%3"));


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,-3");
        });

        String expectedMessage = "negatives not allowed: [-2, -3]";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

        assertEquals(2, calculator.add("2,1001"));
    }
}