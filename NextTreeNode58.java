package offer;
/**
 * 二叉树某节点的下一个节点
 * 
 * 根据offer上讲的是  中序线索化。还有后序线索化等
 * @author fqx
 *
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextTreeNode58 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode target = null;
        if(pNode == null) return null;
        /*
         * if pNode has right child, then next node must in the right 
         * subTree. so the next node is the subTree's  most left node 
         */
        if(pNode.right != null){
            target = pNode.right;
            while(target.left != null){
                target = target.left;
            }
        }else if(pNode.next != null){
            target = pNode.next;
            TreeLinkNode cur = pNode;
            /*
             * if pNode has no right 
             * and pNode is parent's right
             * so to find a node is the node's parent's left node
             */
            while(target != null && target.left != cur){
                cur = target;                                                                                                           
                target = target.next;
            }
        }
        return target;
    }
}
