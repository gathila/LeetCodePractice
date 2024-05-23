package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {

//    private int longestStart;
//    private int longestEnd;
    private List<Integer> left = new ArrayList<Integer>();
    private List<Integer> right = new ArrayList<Integer>();

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int i = longestValidParentheses.longestValidParentheses(")(())))(())())");

        System.out.println(i);

    }

    public int longestValidParentheses(String s) {

        char[] parentheses = s.toCharArray();
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        while (current < parentheses.length) {
            if (parentheses[current] == '(') {
                stack.push(current);
            } else {
                if (!stack.empty()) {
                    Integer matchingLeftPosition = stack.pop();
                    addToPositionArray(matchingLeftPosition, current);
                }
            }
            current++;
        }

        return maxLength();
    }


    private void addToPositionArray(int currentStart, int currentEnd) {
        if (left.isEmpty()) {
            left.add(currentStart);
            right.add(currentEnd);
            return;
        }
        int longestStart = left.get(left.size()-1);
        int longestEnd = right.get(right.size()-1);
        if (longestEnd + 1 == currentStart) {
            longestEnd = currentEnd;
            right.set(right.size()-1, longestEnd);
        } else if (longestStart-1 == currentStart) {
            longestStart = currentStart;
            longestEnd = currentEnd;
            left.set(left.size()-1, longestStart);
            right.set(right.size()-1, longestEnd);
        } else {
            left.add(currentStart);
            right.add(currentEnd);
        }

        if (left.size() >= 2) {
            int lastStart = left.get(left.size()-1);
            int lastEnd = right.get(right.size()-1);
            int previousEnd = right.get(right.size()-2);
            if (previousEnd + 1 == lastStart) {
                right.set(right.size()-2, lastEnd);
                left.remove(left.size()-1);
                right.remove(right.size()-1);
            }
        }
    }

    private int maxLength() {
        int maxLeft = 0;
        int maxRight = 0;

        for (int i=0; i<left.size(); i++) {
            int currentLeft = left.get(i);
            int currentRight = right.get(i);
            if (currentRight-currentLeft > maxRight-maxLeft) {
                maxLeft = currentLeft;
                maxRight = currentRight;
            }
        }

        int maxLength = maxRight-maxLeft;
        return maxLength != 0 ? maxRight-maxLeft+1 : 0;
    }

}
