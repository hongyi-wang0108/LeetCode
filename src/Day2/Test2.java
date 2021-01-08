package Day2;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {

    }
}
class CQueue {
    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int value;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    /*public void appendTail(int value) {
        if(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }*/
    public void appendTail(int value) {//优化版

        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }
}
