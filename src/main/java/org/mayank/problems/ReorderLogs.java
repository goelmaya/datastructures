package org.mayank.problems;


import org.mayank.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * Return the final order of the logs.
 * Example:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 **/

public class ReorderLogs {

    public TreeNode<String> insertIntoBST(TreeNode<String> node, String value) {
        if (node == null) {
            TreeNode<String> treeNode = new TreeNode<String>(value);
            treeNode.left = null;
            treeNode.right = null;
            return treeNode;
        }
        if (node.val.substring(node.val.indexOf(" "),node.val.length()).compareTo(value.split(" ")[1]) > 0) {
            node.left = insertIntoBST(node.left, value);
        } else if (node.val.substring(node.val.indexOf(" "),node.val.length()).compareTo(value.split(" ")[1]) < 0) {
            node.right = insertIntoBST(node.right, value);
        } else {
            if (node.val.split(" ")[0].compareTo(value.split(" ")[0]) > 0) {
                node.left = insertIntoBST(node.left, value);
            } else {
                node.right = insertIntoBST(node.right, value);
            }
        }
        return node;
    }

    public void inorderTraversal(TreeNode<String> treeNode, List<String> logs) {
        if(treeNode == null){
            return;
        }
        inorderTraversal(treeNode.left, logs);
        logs.add(treeNode.val);
        inorderTraversal(treeNode.right, logs);
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> listDigits = new LinkedList<String>();
        TreeNode<String> rootLetterLogs = null;
        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                listDigits.add(log);
            } else {
                rootLetterLogs = insertIntoBST(rootLetterLogs, log);
            }
        }
        List<String> listLetters = new LinkedList<String>();
        inorderTraversal(rootLetterLogs, listLetters);
        listLetters.addAll(listDigits);

        String[] output = new String[listLetters.size()];
        return listLetters.toArray(output);
    }

    public static void main(String[] args) {
        //String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        //ReorderLogs reorderLogs = new ReorderLogs();
        //System.out.println(reorderLogs.reorderLogFiles(logs).toString());


        //["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]

        String a= "g1 act car";
        String b= "a8 act zoo";

        System.out.println(a.substring(a.indexOf(" "),a.length()));

    }
}
