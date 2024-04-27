package dp;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String output = p.longestPalindrome("abbcccbbbcaaccbababcbcabca");
        System.out.println(output);
    }

    private String s;

    public String longestPalindrome(String s) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        this.s = s;
        longestPalindrome(0, s.length()-1, map);
        int start = 0;
        int end = 0;
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue().equals(Boolean.TRUE)) {
                int diff = end - start;

                String[] split = entry.getKey().split(":");
                int tmpStart = Integer.parseInt(split[0]);
                int tmpEnd = Integer.parseInt(split[1]);
                int tmpDiff = tmpEnd - tmpStart;

                if (tmpDiff > diff) {
                    start = tmpStart;
                    end = tmpEnd;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public void longestPalindrome(int start, int end, Map<String, Boolean> isPalindrome) {
        Boolean isSubPal = isPalindrome.get(start + ":" + end);
        if (isSubPal != null) {
            if (isSubPal) {
                return;
            } else {
                if (start == end) {
                    return;
                }
            }
        }

        char[] charArray = s.toCharArray();
        int j=0;
        int i = start;
        while (i < (end-j)) {
            if (charArray[i] != charArray[end - j]) {
                isPalindrome.put(start+":"+end, false);
                longestPalindrome(start, end-1, isPalindrome);
                longestPalindrome(start+1, end, isPalindrome);
                return;
            }
            i++;
            j++;
        }
        isPalindrome.put(start+":"+end, true);
    }
}
