package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(constructSmallestNumberFromDIString("IIIDIDDD"));
        System.out.println(constructSmallestNumberFromDIString("DDD"));

    }

    // This method returns the lexicographically smallest string that meets the challenge specifications.
    public static String constructSmallestNumberFromDIString(String pattern) {

        // We will use recursion to produce the lexicographically smallest string needed.
        return constructSmallestNumber(pattern, "");

    }

    // This is a helper method that uses recursion to produce the lexicographically smallest
    // that meets the challenge specifications. We will use string output to gradually build the
    // lexicographically smallest string and string pattern will help decide whether the next digit
    // is lower or higher than the previous digit that has been placed in string output.
    private static String constructSmallestNumber(String pattern, String output) {

        // int startIndex and int endIndex indicates the index that we will start looping from, and
        // the index that we will loop until (inclusive) respectively in the upcoming for-loop. We use
        // custom ranges to account for the constraints mentioned by the challenge specifications. The
        // for-loop will be using these indexes as digits that can be placed into string output later.
        int startIndex = -1;
        int endIndex = -1;

        // If string output is longer than string pattern, it means we have reached the maximum length
        // of string output, and we simply return its current value without any further logic.
        if (output.length() > pattern.length()) { return output; }

        // If string output is empty, then this means that this is the very first call of the method
        // before any recursion has taken place. We have no previous digit to look at, so we simply
        // set the range as 1-8 if the first character in string pattern is "I" and 2-9 if it is "D".
        // This is because only digits 1-9 can be used in string output, so only the first 8 digits
        // can work if the next digit is expected to be higher than it, and only the last 8 digits can
        // work if the next digit is expected to be lower than it.
        if (output.isEmpty()) {

            if (pattern.charAt(0) == 'I') {
                startIndex = 1;
                endIndex = 8;
            } else if (pattern.charAt(0) == 'D') {
                startIndex = 2;
                endIndex = 9;
            }

        } else {

            // Otherwise, we look at what the latest digit in string output is.
            int latestDigit = Integer.parseInt(String.valueOf(output.charAt(output.length() - 1)));

            // If the corresponding character in string pattern is "I", then we want to restrict the
            // range of indexes we're looping through to be higher than the latest digit.
            if (pattern.charAt(output.length() - 1) == 'I') {
                startIndex = latestDigit + 1;
                endIndex = 9;
            // If the corresponding character in string pattern is "D", then we want to restrict the
            // range of indexes we're looping through to be lower than the latest digit.
            } else if (pattern.charAt(output.length() - 1) == 'D') {
                startIndex = 1;
                endIndex = latestDigit - 1;
            } else {
                // While it should be normally impossible to reach this point assuming the arguments
                // passed in follow the challenge specifications, if a character other than "I" or "D"
                // is detected in string pattern, shut down the program.
                System.exit(0);
            }

        }

        // String finalOutput will contain the string that we want to actually return.
        String finalOutput = "";

        // We will start looping from int startIndex to int endIndex.
        // We will treat index i as digits that can be placed at the end of string output.
        for (int i = startIndex; i <= endIndex; i++) {

            // String newOutput will record the longest string that can be generated from
            // recursion when the current index(digit) i is placed at the end of string output.
            String newOutput = output;

            // Since each digit between 1-9 can only be used once, we want to make sure that the
            // current digit (index i) being looped through has not already been used in string
            // output. Our earlier logic already ensures that index i follows the constraints set
            // by the corresponding character ("I" or "D") in string pattern, so if the current digit
            // or index i has not already been used in string output, we will proceed to add it to the
            // end of string output and perform recursion on it to see the maximum length we can get.
            if (!output.contains(Integer.toString(i))) {

                // We will add digit i to the end of string newOutput, and perform recursion on it.
                newOutput = newOutput + i;
                newOutput = constructSmallestNumber(pattern, newOutput);

                // If string newOutput is longer than string finalOutput after the recursion,
                // we replace string finalOutput with the value of string newOutput. The way this
                // recursive method is designed, the first string to reach maximum length will be
                // the lexicographically smallest string (as the for-loop always starts from the
                // smallest valid digit to the largest valid digit), so once we have our first string
                // that hits maximum length we do not want to replace it, hence why we only replace
                // string finalOutput if and only if it is strictly shorter than string newOutput.
                if (newOutput != null && newOutput.length() > finalOutput.length()) {
                    finalOutput = newOutput;
                }

            }

        }

        // Finally, return string finalOutput once we have finished our loops.
        return finalOutput;

    }

}
