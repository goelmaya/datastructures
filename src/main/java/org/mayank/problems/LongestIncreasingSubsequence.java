package org.mayank.problems;

import java.util.Arrays;

/**
 * Created by mayank.goel on 05/12/19.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] lisArray = new int[nums.length];
        Arrays.fill(lisArray,1);
        for(int i=1;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    lisArray[i] = Math.max(lisArray[i],lisArray[j]+1);
                }
            }
        }
        int max = 1;
        for(int i: lisArray){
            if(i>max){
                max=i;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
