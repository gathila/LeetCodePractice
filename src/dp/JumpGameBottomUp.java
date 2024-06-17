package dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGameBottomUp {

    public static void main(String[] args) {
        JumpGameBottomUp jumpGame = new JumpGameBottomUp();
        int i = jumpGame.jump(new int[]{2,2,3,2,2,2});
        System.out.println(i);
    }
    public int jump(int[] nums) {

        Map<Integer, Integer> minDistanceToIdxMap = new HashMap<>();
        minDistanceToIdxMap.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            Integer distanceToI = minDistanceToIdxMap.get(i);

            for (int j=1; j<=nums[i] && (i+j)<nums.length; j++) {
                Integer calculatedDistance = minDistanceToIdxMap.get(i+j);
                if (calculatedDistance == null || calculatedDistance > distanceToI+1) {
                    minDistanceToIdxMap.put(i+j, distanceToI + 1);
                }
            }
        }

        return minDistanceToIdxMap.get(nums.length-1);
    }
}