package com.project.solution;

public class LeetCodeSolution {

    public static void main(String[] args) {

        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));

    }

    // Check if the current sequence matches the pattern of 'I' and 'D'
    private static boolean check(String sequence, String pattern) {

        for (int index = 0; index < pattern.length(); index++) {

            if (pattern.charAt(index) == 'I') {

                // Ensure the sequence is in increasing order at 'I' positions
                if (sequence.charAt(index) > sequence.charAt(index + 1)) {
                    return false;
                }

            } else {

                // Ensure the sequence is in decreasing order at 'D' positions
                if (sequence.charAt(index) < sequence.charAt(index + 1)) {
                    return false;
                }

            }

        }

        return true;

    }

    public static String smallestNumber(String pattern) {

        int patternLength = pattern.length();
        char[] numberSequence = new char[patternLength + 1];

        // Create a sequence of numbers from '1' to 'n+1'
        for (int position = 0; position <= patternLength; position++) {
            numberSequence[position] = (char) ('1' + position);
        }

        // Generate permutations and check for the correct pattern
        while (!check(new String(numberSequence), pattern)) {
            if (!findNextPermutation(numberSequence)) {
                break;
            }
        }

        return new String(numberSequence);

    }

    // Custom implementation of the next permutation function
    private static boolean findNextPermutation(char[] numberSequence) {

        int lastIncreasingIndex = numberSequence.length - 2;

        // Find the rightmost character smaller than its next character
        while (lastIncreasingIndex >= 0 &&
                numberSequence[lastIncreasingIndex] >= numberSequence[lastIncreasingIndex + 1]) {
            lastIncreasingIndex--;
        }

        if (lastIncreasingIndex == -1) return false;

        // Find the rightmost character greater than numberSequence[lastIncreasingIndex] and swap
        int swapIndex = numberSequence.length - 1;

        while (numberSequence[swapIndex] <= numberSequence[lastIncreasingIndex]) {
            swapIndex--;
        }

        swapCharacters(numberSequence, lastIncreasingIndex, swapIndex);

        // Reverse the suffix to get the next lexicographically smallest permutation
        reverseSuffix(numberSequence,lastIncreasingIndex + 1,numberSequence.length - 1);

        return true;

    }

    private static void swapCharacters(char[] array, int firstIdx, int secondIdx) {

        char temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;

    }

    private static void reverseSuffix(char[] array, int startIdx, int endIdx) {

        while (startIdx < endIdx) {
            swapCharacters(array, startIdx, endIdx);
            startIdx++;
            endIdx--;
        }

    }

}
