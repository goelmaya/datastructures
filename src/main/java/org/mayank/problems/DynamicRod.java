package org.mayank.problems;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class DynamicRod {

    int value[];
    int len[];

    public DynamicRod(int[] value, int[] len) {
        this.value = value;
        this.len = len;
    }

    public int recursiveCutRod(int length) {
        int maxValue = Integer.MIN_VALUE;
        if (length <= 0) return 0;

        for (int i = 0; i < len.length; i++) {
            if (len[i] <= length) {
                int val = value[i] + recursiveCutRod(length - len[i]);
                if (val > maxValue) {
                    maxValue = val;
                }
            }
        }
        return maxValue;
    }

    public void dynammicProgrammingCutRod(int length) {
        if (length <= 0) System.out.println(0);
        int[] lengths = new int[length + 1];
        Arrays.fill(lengths, Integer.MIN_VALUE);
        lengths[0] = 0;
        for (int lengthTemp = 1; lengthTemp < lengths.length; lengthTemp++) {
            for (int l = 0; l < len.length; l++) {
                if (len[l] <= lengthTemp) {
                    int sub_result = lengths[lengthTemp - len[l]];
                    if (sub_result != Integer.MIN_VALUE && sub_result + value[l] > lengths[lengthTemp]) {
                        lengths[lengthTemp] = value[l] + sub_result;
                    }
                }
            }
        }
        System.out.println(lengths[length]);
    }

    public static void main(String[] args) {
        int value[] = new int[]{2,5,7,8};
        int len[] = new int[]{1, 2, 3, 4};
        DynamicRod dynamicRod = new DynamicRod(value, len);

        System.out.println("StartTimeRecursive" + System.currentTimeMillis());
        System.out.println(dynamicRod.recursiveCutRod(5));
        System.out.println("EndTimeRecursive" + System.currentTimeMillis());

        System.out.println("StartTimeDp" + System.currentTimeMillis());
        dynamicRod.dynammicProgrammingCutRod(5);
        System.out.println("EndTimeDp" + System.currentTimeMillis());
    }
}
