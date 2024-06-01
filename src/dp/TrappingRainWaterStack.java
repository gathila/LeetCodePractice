package dp;

import java.util.Stack;

public class TrappingRainWaterStack {

    public static void main(String[] args) {
        TrappingRainWaterStack trappingRainWater = new TrappingRainWaterStack();
        int i = trappingRainWater.trap(new int[]{5,2,1,2,1,5});
        System.out.println(i);
    }

    public int trap(int[] height) {
        if (height.length < 3) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int volume = 0;

        for (int i = 1; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (height[i] > height[stack.peek()] && stack.size() > 1) {
                Integer middleIdx = stack.pop();
                Integer leftIdx = stack.peek();
                Integer rightIdx = i;

                int minHeight = Math.min(height[leftIdx], height[rightIdx]);
                volume += (minHeight-height[middleIdx]) * (rightIdx - leftIdx - 1);
            }

            if (height[i] >= height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }
        }

        return volume;
    }
}
