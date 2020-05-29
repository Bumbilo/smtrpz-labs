package Lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lab1Test {

    @Test
    public void shouldFindMinimumString() {
        Lab1 lab1 = new Lab1();
        String result = lab1.minString("hello world");
        assertEquals("hello", result);
    }

    @Test
    public void shouldReturnFirstWordIfTwoWordsHasSameAmountOfCharacter() {
        Lab1 lab1 = new Lab1();
        assertEquals("Daniel", lab1.minString("Daniel Nikole Alexandre"));
        assertEquals("Nikole", lab1.minString("Nikole Daniel Alexandre"));
    }

    @Test
    public void shouldThrowExceptionIfStringIsNullOrEmpty() {
        Lab1 lab1 = new Lab1();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lab1.minString(null);
        });
        assertEquals("No words", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> {
            lab1.minString("");
        });
        assertEquals("No words", exception.getMessage());
    }
}
