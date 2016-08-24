package offer;

import java.util.*;

/*
 * 
 */
public class minStack21 {
    Stack data = new Stack();
    Stack min = new Stack();

    public void push(int node) {
        data.push(node);
        
        //开始min栈的最小元素就是当前入栈的元素
        if (min.isEmpty()) {
            min.push(node);
        }
        //min栈不空的时候，那么就开始比较了。
        //原始栈中的每一层都对应着一个最小值
        if (node < (int) min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return (int) data.peek();
    }

    public int min() {
        return (int) min.peek();
    }

    public static void main(String[] args) {
        minStack21 st = new minStack21();
        st.push(3);
        int min = st.min();
        System.out.println(min);
        st.push(4);
        min = st.min();
        System.out.println(min);
    }
}
