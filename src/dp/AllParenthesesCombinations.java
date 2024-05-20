package dp;

import java.util.ArrayList;
import java.util.List;

public class AllParenthesesCombinations {

    public static void main(String[] args) {
        AllParenthesesCombinations cls = new AllParenthesesCombinations();
        List<String> strings = cls.generateParenthesis(4);

        for (String pair : strings) {
            System.out.println(pair);
        }
    }

    List<String> allPairs = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateParenthesis("", 0, n);

        return allPairs;
    }

    public void generateParenthesis(String pairs, int remainingRight, int remainingLeft) {

        if (remainingRight == 0 && remainingLeft == 0) {
            allPairs.add(pairs);
            return;
        }

        if ("".equals(pairs)) {
            pairs += "(";
            remainingRight++;
            remainingLeft--;
        }

        if (remainingRight > 0) {
            generateParenthesis(pairs + ")", remainingRight - 1, remainingLeft);
        }

        if (remainingLeft > 0) {
            generateParenthesis(pairs + "(", remainingRight+1, remainingLeft - 1);
        }
    }
}
