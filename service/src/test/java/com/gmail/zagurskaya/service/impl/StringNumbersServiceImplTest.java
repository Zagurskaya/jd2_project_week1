package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.service.StringNumbersService;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringNumbersServiceImplTest {

    private static final StringNumbersService stringNumbersService = StringNumbersServiceImpl.getInstance();

    @Test
    public void testSumWithComaDelimiter() {
        int result = stringNumbersService.add("3,4");
        assertEquals(7, result);
    }

    @Test
    public void testSumWithColonDelimiter() {
        int result = stringNumbersService.add("3:4");
        assertEquals(7, result);
    }

    @Test
    public void testSumWithVerticalBarDelimiter() {
        int result = stringNumbersService.add("3|4");
        assertEquals(7, result);
    }

    @Test
    public void testSumEmptyString() {
        int result = stringNumbersService.add("");
        assertEquals(0, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testSumThrowNumberFormatException() {
        int result = stringNumbersService.add("3+4");
    }
}
