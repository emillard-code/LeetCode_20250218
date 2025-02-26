package com.project.attempt;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        System.out.println(constructSmallestNumberFromDIString("IIIDIDDD"));
        System.out.println(constructSmallestNumberFromDIString("DDD"));

    }

    public static String constructSmallestNumberFromDIString(String pattern) {

        return constructSmallestNumber(pattern, "");

    }

    private static String constructSmallestNumber(String pattern, String output) {

        // System.out.println(output);

        int startIndex = -1;
        int endIndex = -1;

        if (output.length() > pattern.length()) { return output; }

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

        String finalOutput = "";

        for (int i = startIndex; i <= endIndex; i++) {

            String newOutput = output;

            if (!output.contains(Integer.toString(i))) {

                newOutput = newOutput + i;
                newOutput = constructSmallestNumber(pattern, newOutput);
                if (newOutput != null && newOutput.length() > finalOutput.length()) {
                    finalOutput = newOutput;
                }

            }

        }

        return finalOutput;

    }

}
