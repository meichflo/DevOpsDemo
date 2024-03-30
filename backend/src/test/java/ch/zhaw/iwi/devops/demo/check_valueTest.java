package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class check_valueTest {
    @Test
    void testIsAlphabetical() {
        assertTrue(check_value.isAlphabetical("florian"));
        assertFalse(check_value.isAlphabetical("27"));

    }
}
