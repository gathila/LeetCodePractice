package dp;


/*
This is iterative approach
 */
public class Palindrome3Iterative {

    public static void main(String[] args) {
        Palindrome3Iterative p = new Palindrome3Iterative();
        String output = p.longestPalindrome("cbbd");
        System.out.println(output);
    }

    public String longestPalindrome(String s) {


        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            int l1 = palindromeLength(s, i, i);
            int l2 = palindromeLength(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > endIdx + 1 - startIdx) {
                startIdx = i - (l - 1) / 2;
                endIdx = i + l / 2;
            }
        }

        return s.substring(startIdx, endIdx + 1);
    }


    public int palindromeLength(String s, int middle, int nextToMiddle) {

        while (middle >= 0 && nextToMiddle < s.length() &&
            s.charAt(middle) == s.charAt(nextToMiddle)) {
            middle--;
            nextToMiddle++;
        }

        int matchingFrom = middle + 1;
        int matchingTo = nextToMiddle - 1;
        int length = matchingTo - matchingFrom + 1;

        return length > 0 ? length : 1;
    }
}
