package offer;

import java.util.*;
/**
 * 两个栈实现队列：还有更复杂的考虑
 * @author fqx
 *
 */
public class StackQueue07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        /*
         * 全部移到2中
         */
        if(stack2.isEmpty()){
            while(stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        /*
         * 如果还空说明没有元素
         */
        if(stack2.isEmpty()){
            throw new NullPointerException();
        }
        int head = stack2.pop();
        return head;
    }
    
    public static void main(String []args){
        StackQueue07 s = new StackQueue07();
        s.stack1.push(1);
        s.stack1.push(2);
        s.stack1.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
