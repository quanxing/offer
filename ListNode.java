package offer;

import java.awt.List;

public class ListNode {
    int val;
    ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.val == ((ListNode)obj).val){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public int hashCode() {
        return val;
    }
}
