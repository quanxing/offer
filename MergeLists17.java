package offer;

import java.util.Random;

public class MergeLists17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p = list1, q = list2;
        ListNode list3 = null;
        ListNode pre = list3;
        if(p == null){
            return list2;
        }else if(q == null){
            return list1;
        }
        //新链表 的头结点
        if(p.val <= q.val) {
            list3 = p;
            pre = list3;
            p = p.next;
        }else {
            list3 = q;
            pre = list3;
            q = q.next;
        }        
        while(p != null && q != null){
            if(p.val <= q.val){
                pre.next = p;
                pre = p;
                p = p.next;    
            }else{
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }
        pre.next = (p != null) ? p:q;
        return list3;
    }
    public static ListNode create(int s, int e){
        ListNode head = null;
        ListNode q = null;
        for (int i = s; i < e; i++) {
            if (i == s){
                head = new ListNode(i);
                q = head;
            }else{
                ListNode node = new ListNode(i);
                q.next = node;
                q = node;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head1 = create(0,5);
        ListNode head2 = create(2,7);
       /* while(head2 != null){
            System.out.println(head2.val);
            head2 = head2.next;
        }*/
        ListNode l = new MergeLists17().Merge(head1, head2);
        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}
