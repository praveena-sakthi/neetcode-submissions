class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> minStack = new Stack<>();
        int len = heights.length;
        int maxArea = 0;
        for(int i=0;i<=len;i++) {
            int currHeight = i==len  ? 0 : heights[i];
            while(!minStack.isEmpty() && currHeight < heights[minStack.peek()]) {
                int height = heights[minStack.pop()];
                int left = minStack.isEmpty() ? -1 : minStack.peek();
                int width = i-left-1;
                maxArea = Math.max(maxArea, height*width);
            }
            minStack.push(i);
        }
        return maxArea;
    }
}
