package com.gameof3.util;

public final class GameUtil {

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
        for (int i = -1; i < 2; i++) {
            if ((number + i) % 3 == 0) {
                return i;
            }
        }
        return 0;
    }

    private GameUtil() {
        // Utility class
    }

}
