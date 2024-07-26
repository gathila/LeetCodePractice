package dp;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public record Tuple(int bottom, int right){}

    public int uniquePaths(int bottom, int left, int bottomPosition, int rightPosition, Map<Tuple, Integer> calcPositions) {


        if (bottomPosition == 1 || rightPosition == 1) {
            return 1;
        }

        int fromRightPaths = 0;
        int fromBottomPaths = 0;
        Tuple tuple1 = new Tuple(bottomPosition, rightPosition - 1);
        if (calcPositions.containsKey(tuple1)) {
            fromRightPaths = calcPositions.get(tuple1);
        } else {
            fromRightPaths = uniquePaths(bottom, left, bottomPosition, rightPosition - 1, calcPositions);
            calcPositions.put(tuple1, fromRightPaths);
        }

        Tuple tuple2 = new Tuple(bottomPosition - 1, rightPosition);
        if (calcPositions.containsKey(tuple2)) {
            fromBottomPaths = calcPositions.get(tuple2);
        } else {
            fromBottomPaths = uniquePaths(bottom, left, bottomPosition - 1, rightPosition, calcPositions);
            calcPositions.put(tuple2, fromBottomPaths);
        }

        return fromRightPaths
                + fromBottomPaths;
    }

    public int uniquePaths(int m, int n) {
        return uniquePaths(m, n, m, n, new HashMap<>());
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths2 = new UniquePaths();
        int i = uniquePaths2.uniquePaths(5, 4);
        System.out.println(i);
    }
}
