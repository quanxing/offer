package offer;

/*
 * 求两个链表的第一个公共节点；即存在k,是两链表的倒数第k个相同
 * 可以用栈实现
 * 不可能开始就相同，说明相同节点必然是从某点开始知道结束
 */
public class CommonOfLink37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
       
        int length1 = lenLink(current1);
        int length2 = lenLink(current2);
        // 两连表的长度差
         
        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len-- > 0) {
                current1 = current1.next;
            }
 
        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len-- > 0) {
                current2 = current2.next;
            }
 
        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1 != null && current2 != null){
            if(current1.val == current2.val){
                break;
            }else{
                current1=current1.next;
                current2=current2.next;
            }
        }
        return current1;
    }
    
    int lenLink(ListNode pHead1){
        int count = 0;
        while(pHead1 != null){
            count++;
            pHead1 = pHead1.next;
        }
        return count;
    }
    
    
    static void show(ListNode l){
        while(l != null){
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }
    public static void main(String [] args){
        ListNode l1 = new ListNode(5);
        ListNode node = new ListNode(4);
        l1.next = node;
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(7);
        show(l1);
        ListNode l2 = new ListNode(9);
        node = new ListNode(6);
        l2.next = node;
        l2.next.next = new ListNode(5);
        show(l2);
        ListNode result = new CommonOfLink37().FindFirstCommonNode(l1,l2);
        if(result != null){
            System.out.println(result.val);
        }
    }
}
