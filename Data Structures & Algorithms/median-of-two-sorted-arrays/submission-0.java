class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length, n= nums2.length;
        int low = 0, high = m;
        while(low <= high) {
            int partA = low + (high-low)/2;
            int partB = ((m+n+1)/2) - partA;
            int left1 = partA == 0 ? Integer.MIN_VALUE : nums1[partA-1];
            int right1 = partA == m ? Integer.MAX_VALUE : nums1[partA];
            int left2 = partB==0 ? Integer.MIN_VALUE : nums2[partB-1];
            int right2 = partB == n ? Integer.MAX_VALUE : nums2[partB];
            if(left1 <= right2 && left2 <= right1) {
                if((m+n)%2==1) {
                    return Math.max(left1,left2);
                }
                return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
            }else if(left1 > right2) {
                high = partA-1;
            }else{
                low = partA+1;
            }
        }
        return 0.0;
        
    }
}
