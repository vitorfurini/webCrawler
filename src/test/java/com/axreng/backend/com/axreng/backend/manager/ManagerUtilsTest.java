package com.axreng.backend.com.axreng.backend.manager;

import com.axreng.backend.com.axreng.backend.manager.exception.Exceptions;
import com.axreng.backend.com.axreng.backend.manager.utils.ManagerUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ManagerUtilsTest {

    private static ManagerUtils managerUtils;

    @BeforeAll
    public static void setUp() {
        managerUtils = new ManagerUtils();
    }

    @Test
    void testWhenUrlIsNull() {
        assertThrows(Exceptions.class, () -> managerUtils.verifyBaseURL(null));
    }

    @Test
    void testWhenUrlIsInvalidTest(){
        assertThrows(Exceptions.class, () -> managerUtils.verifyBaseURL("http://fac%book.com/"));
    }

    @Test
    void testWhenKeywordIsNull() {
        assertThrows(Exceptions.class, () -> managerUtils.verifyKeyword(null));
    }

    @Test
    void testWhenIsInvalidKeywordSizeTest(){
        assertThrows(Exceptions.class, () -> managerUtils.verifyKeyword("fou"));
        assertThrows(Exceptions.class, () -> managerUtils.verifyKeyword("fourfourfourfourfourref"));
    }

    @Test
    void testWhenIsInvalidKeywordNotAlphaNumeric(){
        assertThrows(Exceptions.class, () -> managerUtils.verifyKeyword("fou%"));
    }

    @Test
    void testWhenIsTestWhenVerifyResultsInvalidValue(){
        assertThrows(NumberFormatException.class, () -> managerUtils.verifyMaxResults(""));
    }


}