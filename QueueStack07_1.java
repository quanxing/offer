package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStack07_1 {
    Queue<Integer> q1; 
    Queue<Integer> q2;
    public QueueStack07_1() {
        // TODO Auto-generated constructor stub
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    public void push(int node) {
        if(q1.isEmpty() && q2.isEmpty()){
            q1.add(node);
        }
        if(q1.size() != 0){
            q1.add(node);
        }
        if(q2.size() != 0){
            q2.add(node);
        }
    }
    
    public Integer pop() {
        if(q1.size()==0 && q2.size() == 0){
            return null;
        }else{
            int result = 0;
            if(q2.size() == 0){
                while(q1.size() > 1){
                    q2.add(q1.poll());
                }
                result = q1.poll();
            }else if(q1.size() == 0){
                while(q2.size() > 1){
                    q1.add(q2.poll());
                }
                result = q2.poll();
            }
            return result;
        }
    }
    
   
    
    public static void main(String []args){
        QueueStack07_1 q = new QueueStack07_1();
        q.q1.add(1);
        q.q1.add(2);
        q.q1.add(3);
        q.q1.add(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.q1.add(5);
        q.q1.add(7);
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
