package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void smallestNumberTest() {

        assertEquals("123549876", LeetCodeSolution.smallestNumber("IIIDIDDD"));
        assertEquals("4321", LeetCodeSolution.smallestNumber("DDD"));

    }

}
