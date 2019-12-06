package org.mayank.problems;

import java.util.HashMap;

/**
 * Created by mayank.goel on 29/11/19.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void curdeWay() {
        int count = 0;
        String a = "GEEKSFORGEEKS";
        String sub;
        String maxString = a.substring(0, 1);
        HashMap<String, Integer> hashMap;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 0; j <= a.length() - i; j++) {
                sub = a.substring(j, j + i);
                hashMap = new HashMap<String, Integer>();
                String current = sub.substring(0, 1);
                hashMap.put(sub.substring(0, 1), 1);
                for (int k = 1; k < sub.length(); k++) {
                    if (!hashMap.containsKey(sub.substring(k, k + 1))) {
                        current = current + sub.substring(k, k + 1);
                        hashMap.put(sub.substring(k, k + 1), 1);
                    } else {
                        break;
                    }
                }
                if (current.length() > maxString.length()) {
                    maxString = current;
                }
            }
        }
        System.out.println(maxString);
    }

    public static void optimalWay() {
        String a = "aabaab!bb";
        if(a==null || a.equals("")){
            System.out.println("");
        }
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        String maxString = a.substring(0, 1);
        String currentMax = a.substring(0, 1);
        hashMap.put(a.substring(0, 1), 0);
        for (int i = 1; i < a.length(); i++) {
            if (hashMap.containsKey(a.substring(i, i + 1))) {
                int prev_index = hashMap.get(a.substring(i, i + 1));
                if (prev_index >= i - currentMax.length()) {
                    currentMax = currentMax.substring(currentMax.indexOf(a.substring(i, i + 1)) + 1);
                }
            }
            hashMap.put(a.substring(i, i + 1), i);
            currentMax += a.substring(i, i + 1);
            if (maxString.length() <= currentMax.length()) {
                maxString = currentMax;
            }
        }
        System.out.println(maxString);
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters.optimalWay();
    }
}
