package offer;

import java.util.ArrayList;
/*
 * 
 */


public class RversePrintList05 {
    /*
     * 修改指针，不是插入法
     */
    
    public void printListByInsert(ListNode head){
        //这个解法更高端
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            //因为next等于空的话，head = next 再次循环head.next Nullpointer
            if(next == null){
                break;
            }
            pre = head;
            head = next;
        }
        
        /*
         * 根据上面的解法的自己版本
         */
/*        if(head == null){
            return ;
        }
        //只有一个节点
        if(head.next == null){
            return ;
        }
        //有两个以上的节点
        ListNode p = head.next;
        ListNode r = p.next;
        head.next = null;
        while(p != null){
            p.next = head;
            head = p;
            p = r;
            if(r != null){
                r  = r.next;
            }
        }
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }*/
        
    }
    
    /*
     * 
     * 通过插链表总插入在头部0的位置
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode != null){
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
    /*
     * �ݹ鷽��
     */
    public void printList(ListNode node){
        if(node != null){
            if(node.next != null){
                printList(node.next);
            }
            System.out.println(node.val);
        }
    }
    /*
     * ���취����
     */
    public ArrayList<Integer> reverse(ListNode head){
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        if(head == null){
            return list2;
        }
        ListNode q = head, p = head.next;
        if(p == null){
            list2.add(q.val);
            return list2;
        }
        ListNode r = p.next;
        q.next = null;
        while(r != null){
            p.next = q;
            q = p;
            p = r;
            r = r.next;
        }
        p.next = q;
       
        while(p != null){
            list2.add(p.val);
            p = p.next;
        }
        return list2;
    }
    
    
    public static void main(String[] args) {
        /*
         * ����ͷ���
         */
        int length = 6;
        ListNode head = null;
        ListNode q = null;
        for (int i = 0; i < length; i++) {
            if (i == 0){
                head = new ListNode(i);
                q = head;
            }else{
                ListNode node = new ListNode(i);
                q.next = node;
                q = node;
            }
        }
    /*    q = head;
        while(q!= null){
            System.out.print(q.val + " ");
            q = q.next;
        }*/
      /*  System.out.println("\n插入逆序");
        new RversePrintList05().printListByInsert(head);*/
        
        System.out.println("\n从尾部打印");
        ArrayList<Integer> list = new RversePrintList05().printListFromTailToHead(head);
        System.out.println(list);
        System.out.println("====");
        System.out.println(new RversePrintList05().reverse(head));
        
       
    }
}
