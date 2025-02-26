package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(constructSmallestNumber("IIIDIDDD", ""));

    }

    public static String constructSmallestNumberFromDIString(String pattern) {

        return null;

    }

    private static String constructSmallestNumber(String pattern, String output) {

        // System.out.println(output);

        int startIndex = -1;
        int endIndex = -1;

        if (output.isEmpty()) {

            if (pattern.charAt(0) == 'I') {
                startIndex = 1;
                endIndex = 8;
            } else if (pattern.charAt(0) == 'D') {
                startIndex = 2;
                endIndex = 9;
            }

        } else {

            int latestDigit = Integer.parseInt(String.valueOf(output.charAt(output.length() - 1)));

            if (pattern.charAt(output.length() - 1) == 'I') {
                startIndex = latestDigit + 1;
                endIndex = 9;
            } else if (pattern.charAt(output.length() - 1) == 'D') {
                startIndex = 1;
                endIndex = latestDigit - 1;
            } else {
                System.exit(0);
            }

        }

        for (int i = startIndex; i <= endIndex; i++) {

            String newOutput = output;

            if (!output.contains(Integer.toString(i))) {

                newOutput = newOutput + i;
                if (newOutput.length() > pattern.length()) {
                    return newOutput;
                }
                newOutput = constructSmallestNumber(pattern, newOutput);
                if (newOutput == null) { continue; }
//                System.out.println("New Output: " + newOutput + ", Pattern: " + pattern);
//                System.out.println("Start Index: " + startIndex + ", End Index: " + endIndex);

            }

        }

        return null;

    }

}
