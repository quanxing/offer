package offer;

import java.util.HashMap;

/**
 * 判断链表中环的起始位置 一个链表中包含环，请找出该链表的环的入口结点。
 *  1）可以通过hash存储节点判断有没有环的。
 *  总结： http://blog.csdn.net/doufei_ccst/article/details/10578315
 *        http://www.cnblogs.com/xudong-bupt/p/3667729.html
 * @author fqx
 *
 */
public class LoopStart56 {
    /**
     * 如果有环，则 返回 快慢指针相遇的节点 
     * 如果没有环，那么返回null
     * 
     * @param pHead
     * @return
     */
    public ListNode meetingNode(ListNode pHead) {
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //at the start point to Head.
        ListNode slow = pHead;
        ListNode fast = pHead;

        //each loop; slow move one step,fast move two step
        while(slow != null && fast.next != null){
            //one step
            slow = slow.next;
            //because the fast.next != null
            // so fast.next.next don't call exception
            //two step
            fast = fast.next.next;
            // slow and fast meet with each other
            if(slow == fast){
//                return fast;
                break;
            }
           
        }
        
        /**
         * 如果要求环长度
         * 就是slow 再次碰到 slow时就走过了环长
         */
//        return null;
        /**
         * if there is no loop so ,the fast.next will null
         * then this condition will return null/.
         */
        
        if(slow == null || fast.next == null) return null;
        /*
         * lenA+x =s
         * lenA+x + n*R = 2s
         */
        ListNode p1 = pHead;
        ListNode p2 = slow;
        
        //the entry node of the loop
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 创建一个有环的单链表
     * 
     * @param head
     * @return
     */
    public static ListNode InsertFromTail(ListNode head) {
        // β���뷨
        ListNode pre = head;
        ListNode joinNode = null;
        for (int i = 1; i <= 6; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                head = node;
                pre = head;
            } else {
                pre.next = node;
                pre = node;
                if (i == 3) {
                    joinNode = node;
                }
            }
        }
        // 环连接点在第三个位置
        pre.next = joinNode;

        ListNode p = head;
        /**
         * 此处又重新使用了containsKey：注意equals方法和hashCode()
         *  也可以通过这个实现环的判断，以及环的长度等问题。
         */
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while (p != null) {
            if (!map.containsKey(p)) {
                map.put(p, p.val);
            } else {
                break;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = InsertFromTail(head);
        ListNode node = new LoopStart56().EntryNodeOfLoop(head);
        System.out.println(node.val);
    }
}
