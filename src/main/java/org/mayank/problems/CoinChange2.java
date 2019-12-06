package org.mayank.problems;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int solution[][] = new int[coins.length + 1][amount + 1];
        int row=0;
        int column=0;

        for (row = 0; row < coins.length + 1; row++) {
            solution[row][0] = 1;
        }
        for (row = 1; row < coins.length + 1; row++) {
            for (column = 1; column < amount + 1; column++) {
                solution[row][column] = solution[row - 1][column];
                if(coins[row-1]<=column){
                    solution[row][column]+= solution[row][column - coins[row - 1]];
                }
            }
        }
        return solution[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int[] array = new int[3];
        array[0]=1;
        array[1]=2;
        array[2]=5;
        System.out.println(coinChange2.change(5,array));
    }
}
