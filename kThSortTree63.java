package offer;

import java.util.Stack;

/*
 * 二叉搜索树 第k个节点
 */
public class kThSortTree63 {
    TreeNode23 KthNode(TreeNode23 pRoot, int k){
        if (pRoot == null || k < 1) {
            return null;
        }

        int[] tmp = {k};
        return kthNodeCore(pRoot, tmp);
    }
    
    private TreeNode23 kthNodeCore(TreeNode23 pRoot, int[] tmp) {
        // TODO Auto-generated method stub
        TreeNode23 result = null;
        
        if(pRoot.left != null){
            result = kthNodeCore(pRoot.left, tmp);
        }
        if (result == null) {
            // 说明当前的根结点是所要找的结点
            if(tmp[0] == 1) {
                result = pRoot;
            } else {
                // 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
                tmp[0]--;
            }
        }

        // 根结点以及根结点的左子树都没有找到，则找其右子树
        if (result == null && pRoot.right != null) {
            result = kthNodeCore(pRoot.right, tmp);
        }

        return result;
    }
    /**
     * 二叉搜索树 中序排序第k个就是所求
     * 即可以用中序遍历求
     * @param root
     * @param k
     * @return
     */
    public static TreeNode23 kthNodeCore(TreeNode23 root, int k) {
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        TreeNode23 cur = root;
        int i = 0;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                TreeNode23 top = s.pop();
                i++;
                if(i == k){
                    return top;
                }
                cur = top.right;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] a = { 8,6,10,5,7,9,11 };
        TreeNode23 root = null;
        root = new TreeOperate23().createSquence(a, 0);
        TreeNode23 node = new kThSortTree63().kthNodeCore(root, 1);
        System.out.println(node.data);
    }
}
