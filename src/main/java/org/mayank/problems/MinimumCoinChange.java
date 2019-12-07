package org.mayank.problems;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * https://leetcode.com/problems/coin-change/
 */
public class MinimumCoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] amountArray = new int[amount+1];
        Arrays.fill(amountArray, Integer.MAX_VALUE); //O(n) since a loop
        amountArray[0]=0;
        for(int amountTemp=1;amountTemp<amountArray.length;amountTemp++){
            for(int coinIndex=0;coinIndex<coins.length;coinIndex++){
                if(coins[coinIndex]<=amountTemp){
                    int sub_result = amountArray[amountTemp-coins[coinIndex]];
                    if(sub_result != Integer.MAX_VALUE && sub_result+1<amountArray[amountTemp]){
                        amountArray[amountTemp] = 1+sub_result;
                    }
                }
            }
        }
        if(amountArray[amount]==Integer.MAX_VALUE)
            return -1;
        else
            return amountArray[amount];
    }

    public static void main(String[] args) {
        MinimumCoinChange minimumCoinChange = new MinimumCoinChange();
        int[] array = new int[3];
        array[0]=1;
        array[1]=2;
        array[2]=5;
        System.out.println(minimumCoinChange.coinChange(array,11));

    }
}
