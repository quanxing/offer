package offer;

import java.awt.List;

public class ReverseList16 {
    //��RversePrintList.java
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            if(next == null){
                break;
            }
            pre = head;
            head = next;
        }
        return head;
    }
    public static void main(String[] args) {
        
    }
}
