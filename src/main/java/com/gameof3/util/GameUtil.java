package com.gameof3.util;

public class GameUtil {

    /**
     *
     * @param adjustment
     * @return if adjustment exits in adjustmentArray
     */
    public static boolean adjustmentArrayContains(int adjustment) {
        int[] adjustmentArray = { -1, 0, 1 };
        for (int i = 0; i < adjustmentArray.length; i++) {
            if (adjustmentArray[i] == adjustment) {
                return true;
            }
        }
        return false;
    }

    public static int getAdjustment(String adj, int number) {
        int adjustment = 0;
        if (adj.equals("")) {
            adjustment = GameUtil.getAdjustmentToDivide3(number);
        } else {
            adjustment = Integer.parseInt(adj);
        }
        return adjustment;
    }

    /**
     *
     * @param number
     * @return adjustment value to divide number to 3
     */
    public static int getAdjustmentToDivide3(int number) {
        int sum = GameUtil.sumOfDigits(number);
        for (int i = -1; i < 2; i++) {
            if ((sum + i) % 3 == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     *
     * @param number
     * @return sum of digits for given number
     */
    public static int sumOfDigits(int number) {
        if (number < 10) {
            return number;
        }
        int sum = 0;
        while (number > 9) {
            sum = 0;
            while (number > 0) {
                int rem;
                rem = number % 10;
                sum = sum + rem;
                number = number / 10;
            }
            number = sum;
        }
        return sum;
    }

    private GameUtil() {
        // Utility class
    }

}
