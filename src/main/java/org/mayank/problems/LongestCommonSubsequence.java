package org.mayank.problems;

/**
 *
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (text1.equals(text2)) {
            return text1.length();
        }
        int lcs = 0;
        if (text1.charAt(0) == text2.charAt(0)) {
            lcs = 1 + longestCommonSubsequence(text1.substring(1), text2.substring(1));
        }
        int lcs2 = Math.max(longestCommonSubsequence(text1.substring(1), text2), longestCommonSubsequence(text1, text2.substring(1)));
        return Math.max(lcs, lcs2);
    }


    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}
