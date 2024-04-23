// B211202005
// BERKAY ÇEKMEZ
// SOFTWARE VERIFICATION AND VALIDATION
// HOMEWORK 1
// https://github.com/berkaycekmez/SoftwareVV_HW1


package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CalculatorTest {
    @ParameterizedTest
    @DisplayName("Division with different inputs")
    @CsvSource({
            "10, 2, 5",
            "10, 4, 2.5",
            "12.5f, 2.5f, 5",
            "10, 2.5f, 4",
            "12.5f, 5, 2.5f"
    })
    public void testDivision(float a, float b, float expectResult) {
        float mainResult = Calculator.divide(a, b);
        Assertions.assertEquals(expectResult, mainResult, 0.001);
    }

    @ParameterizedTest
    @DisplayName("Division by zero throws IllegalArgumentException")
    @CsvSource({
            "10, 0"
    })
    public void testDivideByZero(float a, float b) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.divide(a, b));
    }
}