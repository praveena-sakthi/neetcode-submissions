class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length-1;
        int row = 0;
        while(top <= bottom) {
            int mid = top+(bottom-top)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target) {
                row = mid;
                break;
            }else if(matrix[mid][0] > target) {
                bottom = mid-1;
            }else{
                top = mid+1;
            }
        }
        // System.out.println("Row : "+row);
        int left = 0, right = matrix[0].length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(matrix[row][mid]==target) {
                return true;
            }else if(matrix[row][mid] > target) {
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
