class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            try {
                int numVal = Integer.parseInt(str);
                stack.push(numVal);
            }catch(Exception e){
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch(str) {
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num1-num2);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    default:
                        stack.push(num1/num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
