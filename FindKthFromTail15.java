package offer;
/*
 * p 与q的距离就差k-1
*/

public class FindKthFromTail15 {
    
    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head, q = head;
        if(head == null || k== 0){
            return null;
        }
        //走 k-1 步子
        while(--k> 0){
            //走到k-1步，就到达链表尾部 return null
            if(p.next == null) return null;
            p = p.next;
        }
       
        
        //p.next == null 说明p到达最后一个节点，那么q就到了倒数第k个节点
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
       return q;
    }
    
    //建立链表 头插法 与插入顺序相反
    public static ListNode InsertFromHead(ListNode head) {
         //ͷ�巨
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i);
            if(i == 0){
                head = node;
            }else{
                node.next = head.next;
                head.next = node;
            }
        }
        ListNode q = head;
        while(q != null){
            System.out.println(q.val);
            q = q.next;
        } 
        return head;
    }
    //建立链表 尾插法：等同插入顺序
    public static ListNode InsertFromTail(ListNode head){
        ListNode q = head;
        for (int i = 0; i < 5; i++) {
            ListNode node = new ListNode(i);
            if(i == 0){
                head = node;
                q = head;
            }else{
                q.next = node;
                q = node;
            }
        }
        ListNode p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = null;
        head = InsertFromTail(head);
        ListNode l = FindKthToTail(head, 6);
        System.out.println(l.val);
    }
}
