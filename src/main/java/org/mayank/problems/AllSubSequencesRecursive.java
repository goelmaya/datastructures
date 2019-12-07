package org.mayank.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mayank.goel on 07/12/19.
 */
public class AllSubSequencesRecursive {

    Set<String> subSequences = new HashSet<String>();

    public void findAllSubsequences(String input, String currentString){
        if(input.length()==0){
            subSequences.add(currentString);
            return;
        }

        findAllSubsequences(input.substring(1), currentString);
        findAllSubsequences(input.substring(1), currentString + input.charAt(0));
    }
    public static void main(String[] args) {
        AllSubSequencesRecursive allSubSequencesRecursive = new AllSubSequencesRecursive();
        String string = "aaaa";
        allSubSequencesRecursive.findAllSubsequences(string, "");
        System.out.println(allSubSequencesRecursive.subSequences.toString());
    }
}
