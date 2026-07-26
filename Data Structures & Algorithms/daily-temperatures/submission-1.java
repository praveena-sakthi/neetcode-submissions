class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        Stack<Integer> stack = new Stack<>();
        int res [] =new int[len];
        res [len-1] = 0;
        stack.push(len-1);
        for(int i=len-2;i>=0;i--) {
            System.out.println(stack);
            int count = 1;
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
                count++;
            }
            if(!stack.isEmpty()){
                res[i]=stack.peek()-i;
            }
            stack.push(i);
            
        }
        return res;
    }
}
