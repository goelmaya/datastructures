package org.mayank.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */
public class TwoSum {

    //O(n)
    public int[] twoSumHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] indexes = new int[2];
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                indexes[1]= i;
                indexes[0]= hashMap.get(target-nums[i]);
                return indexes;
            }
            else {
                hashMap.put(nums[i],i);
            }
        }
        return indexes;
    }

    //O(nlogn in case of merge sort or heapsort)
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int[] indexes = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                indexes[0] = left;
                indexes[1] = right;
                return indexes;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(array, 9);

        for (int i=0;i<twoSum.twoSum(array, 9).length;i++){
            System.out.println(twoSum.twoSum(array, 9)[i]);
        }

        for (int i=0;i<twoSum.twoSumHashTable(array, 9).length;i++){
            System.out.println(twoSum.twoSumHashTable(array, 9)[i]);
        }
    }
}

