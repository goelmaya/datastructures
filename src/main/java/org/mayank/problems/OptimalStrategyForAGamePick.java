package org.mayank.problems;

/**
 * geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 */
public class OptimalStrategyForAGamePick {

    public int recursiveFindStrategy(int[] arr, int startIndex, int endIndex) {
        int value = 0;
        if (startIndex == endIndex) {
            value = arr[endIndex];
        } else if (startIndex > endIndex) {
            value = 0;
        } else {
            int strategy1 = arr[startIndex] + Math.min(recursiveFindStrategy(arr, startIndex + 2, endIndex), recursiveFindStrategy(arr, startIndex + 1, endIndex - 1));
            int strategy2 = arr[endIndex] + Math.min(recursiveFindStrategy(arr, startIndex + 1, endIndex - 1), recursiveFindStrategy(arr, startIndex, endIndex - 2));
            value = Math.max(strategy1, strategy2);
        }
        return value;
    }

    public void dpFindStrategy(int[] arr) {
        int[][] results = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    results[i][i] = arr[i];
                }
                if (i > j) {
                    results[i][i] = 0;
                }
            }

        }


        for (int startIndex = 0; startIndex < arr.length-1; startIndex++) {
            for (int endIndex = 0; endIndex < arr.length-1; endIndex++) {
                if (startIndex < endIndex) {
                    int strategy1 = 0;
                    try {
                        strategy1 = results[startIndex + 2][endIndex];
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        strategy1 =0;
                    }

                    int strategy2 = 0;
                    try {
                        strategy2 = results[startIndex + 1][endIndex - 1];
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        strategy2 =0;
                    }

                    int strategy3 = 0;
                    try {
                        strategy3 = results[endIndex - 2][startIndex];
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        strategy3 =0;
                    }

                    results[startIndex][endIndex] = Math.max(arr[startIndex] + Math.min(strategy1, strategy2), arr[endIndex] + Math.min(strategy2, strategy3));
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(results[i][j]+ "");
            }
            System.out.println();
        }

        int endIndex = 3;
        for (int startIndex = arr.length - 2;startIndex>=0; startIndex--) {
            int strategy1 = 0;
            try {
                strategy1 = results[startIndex + 2][endIndex];
            }
            catch (ArrayIndexOutOfBoundsException e){
                strategy1 =0;
            }

            int strategy2 = 0;
            try {
                strategy2 = results[startIndex + 1][endIndex - 1];
            }
            catch (ArrayIndexOutOfBoundsException e){
                strategy2 =0;
            }

            int strategy3 = 0;
            try {
                strategy3 = results[endIndex - 2][startIndex];
            }
            catch (ArrayIndexOutOfBoundsException e){
                strategy3 =0;
            }
            results[startIndex][endIndex] = Math.max(arr[startIndex] + Math.min(strategy1, strategy2), arr[endIndex] + Math.min(strategy2, strategy3));
        }
        System.out.println(results[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {8, 15, 3, 7};
        OptimalStrategyForAGamePick optimalStrategyForAGamePick = new OptimalStrategyForAGamePick();
        System.out.println(optimalStrategyForAGamePick.recursiveFindStrategy(arr, 0, arr.length - 1));
        optimalStrategyForAGamePick.dpFindStrategy(arr);
    }
}
