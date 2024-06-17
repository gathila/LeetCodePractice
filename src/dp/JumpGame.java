package dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int i = jumpGame.jump(new int[]{2,2,3,2,2,2});
        System.out.println(i);
    }
    public int jump(int[] nums) {

        return minDistanceTo(nums, nums.length-1, new HashMap<>());
    }

    public int minDistanceTo(int[] nums, int endIdx, Map<Integer, Integer> minDistToIdxMap) {

        if (endIdx == 0) {
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = endIdx-1; i >= 0; i--) {
            if (i+nums[i] >= endIdx) {
                int minStepsToI = minDistToIdxMap.containsKey(i) ?
                        minDistToIdxMap.get(i) : minDistanceTo(nums, i, minDistToIdxMap);
                minSteps = Math.min(minSteps, minStepsToI);
            }
        }
        minDistToIdxMap.put(endIdx, minSteps + 1);
        return minSteps + 1;
    }
}
