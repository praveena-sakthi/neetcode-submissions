class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int len = nums.length;
        int res[]= new int[len];
        int [] leftProd = new int[len];
        for(int i=0;i<len;i++) {
            if(nums[i]==0) {
                zeroCount++;
                if(zeroCount>1) {
                    return res;
                }
            }
            if(i==0) {
                leftProd[i] = nums[i];
            }else {
                leftProd[i] = leftProd[i-1]*nums[i];
            }
        }
        // System.out.println(Arrays.toString(leftProd));
        int rightProd = 1;
        for(int i=len-1;i>=0;i--) {
            // rightProd = rightProd * nums[i];
            if(i==0) {
                res[i] = rightProd;
            }else{
                res[i] = leftProd[i-1] * rightProd;
            }
            rightProd = rightProd * nums[i];
            
        }
        return res;
    }
}  
