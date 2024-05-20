package dp;

import java.util.HashMap;
import java.util.Map;

public class Palindrome2Recursive {

    public static void main(String[] args) {
        Palindrome2Recursive p = new Palindrome2Recursive();
        String output = p.longestPalindrome("cbbd");
        System.out.println(output);
    }
    private char [] input;
    public String longestPalindrome(String s) {
        this.input = s.toCharArray();

        Map<String, Boolean> map = new HashMap<>();;

        palindrome(0, input.length-1, map);

        int lgstart = 0;
        int lgend = 0;
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] split = key.split(":");
            if (entry.getValue().equals(Boolean.TRUE)) {
                int start = Integer.parseInt(split[0]);
                int end = Integer.parseInt(split[1]);
                if (end - start > lgend - lgstart) {
                    lgstart = start;
                    lgend = end;
                }
            }
        }

        return s.substring(lgstart, lgend+1);
    }


    public boolean palindrome(int i, int j, Map<String, Boolean> palindromes) {
        if (i >= j) {
            return true;
        }

        Boolean isCalculatedPalindrome = palindromes.get(i + ":" + j);
        if (isCalculatedPalindrome != null) {
            return isCalculatedPalindrome;
        }

        boolean isPalindrome = false;
        if (input[i] == input[j]) {
            isPalindrome = palindrome(i+1, j-1, palindromes);
        }

        if (!isPalindrome) {
            boolean isSubP = palindrome(i+1, j, palindromes);
            if (!isSubP)
                palindrome(i, j-1, palindromes);
        }

        palindromes.put(i + ":" + j, isPalindrome);
        return isPalindrome;
    }
}
