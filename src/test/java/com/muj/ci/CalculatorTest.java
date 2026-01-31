package com.muj.ci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calc = new Calculator();

    @Test
    void adds() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtracts() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    void multiplies() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void divides() {
        assertEquals(2.5, calc.divide(5, 2));
    }

    @Test
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
    }
}
