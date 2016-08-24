package offer;

import org.w3c.dom.ls.LSInput;

/**
 * delete the duplicate element of a link
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author fqx
 *
 */
public class DeleteDulipLink57 {
    /**
     * 不带头结点的链表
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return null;
        /**
         * the first node will also dupicate, so delete then return null;
         */
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode p = pHead;
        while(p != null && p.next != null){
            if(p.val == p.next.val){
                p = p.next;
                int val = p.val;
                //删除所有重复的
                while(p.next != null && p.next.val == val){
                    p = p.next;
                }
                pre.next = p.next;
            }else{
                pre = p;
            }
            p = p.next;
        }
        return head.next;
    }
    
    /*
     * 删除重复但是保留一个
     */
    public static ListNode deleteDuplication_1(ListNode pHead){
        if(pHead == null) return null;
        /**
         * the first node will also dupicate, so delete then return null;
         */
        ListNode pre = pHead;
        ListNode p = pHead.next;
        
        while(p != null){
            while(p != null && p.val == pre.val){
                p = p.next;
            }
            pre.next = p;
            p = pre.next;
        }
        return pHead;
    }
    public static void main(String[] args) {
        /*test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
        test09();
        test10();*/
        
    }

    private static void show(ListNode l){
        if(l == null) System.out.println("null链表");
        while(l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }
    // 1->2->3->3->4->4->5
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
           show(result);
        }
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
       
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // 1->2
    private static void test08() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // 1
    private static void test09() {
        ListNode n1 = new ListNode(1);
        ListNode result = deleteDuplication(n1);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }

    // null
    private static void test10() {
        ListNode result = deleteDuplication(null);
        if(result == null){
            System.out.println("null");
        }else{
            show(result);
        }
    }
}
