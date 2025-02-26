package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void constructSmallestNumberFromDIStringTest() {

        assertEquals("123549876", LeetCodeAttempt.constructSmallestNumberFromDIString("IIIDIDDD"));
        assertEquals("4321", LeetCodeAttempt.constructSmallestNumberFromDIString("DDD"));

    }

}
