package com.example.demo.Pr4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void testReplaceNumbersInTextWhenNumberInStart() {
        String result = Converter.replaceNumbers("сто друзей");
        assertEquals("100 друзей", result);
    }

    @Test
    void testReplaceNumbersInTextWhenNumberInEnd() {
        String result = Converter.replaceNumbers("У меня около двухсот десяти копеек");
        assertEquals("У меня около 210 копеек", result);
    }
}