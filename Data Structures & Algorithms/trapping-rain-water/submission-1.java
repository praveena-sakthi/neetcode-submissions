class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int [] leftMax = new int[len];
        leftMax[0]=0;
        int maxSoFar = height[0];
        for(int i=0;i<height.length;i++) {
            maxSoFar = Math.max(height[i],maxSoFar);
            leftMax[i]=maxSoFar;
        }
        // System.out.println(Arrays.toString(leftMax));
        maxSoFar = height[len-1];
        int result = 0;
        for(int i=len-1;i>=0;i--) {
            maxSoFar = Math.max(height[i],maxSoFar);
            int minPossible = Math.min(leftMax[i],maxSoFar);
            result += minPossible-height[i];
        }
        return result;
    }
}
