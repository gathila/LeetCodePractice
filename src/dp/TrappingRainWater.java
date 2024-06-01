package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int i = trappingRainWater.trap(new int[]{1,7,8});
        System.out.println(i);
    }
    public int trap(int[] height) {

        if (height.length < 3) return 0;

        List<Integer> indexes = new ArrayList<>();

        int startIdx = findStartIndx(1, height);
        if (startIdx == -1) return 0;

        indexes.add(startIdx);


        Stack<Integer> tmp = new Stack<>();
        for (int i=startIdx+1; i<height.length-1; i++) {
            if (height[i] < height[i+1]) {
                int lastStartingIdx = indexes.get(indexes.size() - 1);

                if (height[lastStartingIdx] <= height[i+1]) {
                    indexes.add(i+1);
                    startIdx = findStartIndx(i+2, height);

                    if (startIdx != -1) {
                        indexes.add(startIdx);
                        i = startIdx;
                    }

                    tmp = new Stack<>();

                } else {
                    while (!tmp.isEmpty() && height[tmp.peek()] < height[i+1]) {
                        tmp.pop();
                    }
                    tmp.push(i+1);
                }
            }
        }

        int maxTrap = 0;

        for (int i=0; i<indexes.size(); i+=2) {
            if (i+1 <indexes.size()) {
                int start = indexes.get(i);
                int end = indexes.get(i+1);
                maxTrap += findTrap(height, start, end);
            }
        }

        while (!tmp.isEmpty()) {
            int endIdx = tmp.pop();
            int stIdx = tmp.isEmpty() ? indexes.get(indexes.size() - 1) : tmp.peek();
            maxTrap += findTrap(height, stIdx, endIdx);
        }

        return maxTrap;
    }

    public int findTrap(int [] height, int startIdx, int endIdx) {

        int smallest = height[startIdx] <= height[endIdx] ?  height[startIdx] : height[endIdx];
        int vol = 0;

        for (int i=startIdx+1; i<endIdx; i++) {
            if (smallest > height[i]) {
                vol += smallest-height[i];
            }
        }

        return vol;
    }


    public int findStartIndx(int start, int[] height) {
        int startIdx = -1;
        for (int i=start; i<height.length; i++) {
            if (height[i] < height[i-1]) {
                startIdx = i-1;
                break;
            }
        }

        return startIdx;
    }

}
