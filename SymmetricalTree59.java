package offer;
/**
 * 对称的二叉树
 * @author fqx
 *
 */
public class SymmetricalTree59 {
    boolean isSymmetrical(TreeNode23 pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }
    /**
     * 
     * @param pRoot1
     * @param pRoot2
     *              root1,root2均为同一个树的根节点
     * @return
     *              如果两个树的左结构与右结构相同那么返回true
     */
    boolean isSymmetrical(TreeNode23 pRoot1, TreeNode23 pRoot2){
        //two compare element has null;
        //if all null true; else either null false;
        if(pRoot1 == null  && pRoot2 == null) return true;
        if(pRoot1 == null || pRoot2 == null) return false;
        // not null;
        //if tow tree : left'data not equals right'data; false;
        if(pRoot1.data != pRoot2.data) return false;
        /*
         * 如果isSymmetrical(pRoot1.left, pRoot2.left) && isSymmetrical(pRoot1.right, pRoot2.right)
         * 那么就是判断两个独立的树是否相同
         */
        return isSymmetrical(pRoot1.left, pRoot2.right) 
                && isSymmetrical(pRoot1.right, pRoot2.left);
    }
    public static void main(String[] args) {
        int[] a = {7,7,7,7,7,7};
//            { 8, 6, 6, 5, 7 ,7, 5};
//      {8,6,9,5,7,7,5};
//      {7,7,7,7,7,7}
        TreeNode23 root = null;
        //������
        root = new TreeOperate23().createSquence(a,0);
        System.out.println(new SymmetricalTree59().isSymmetrical(root));
    }
}
