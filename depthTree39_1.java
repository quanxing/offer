package offer;
/*
 * 求二叉树深度
 */
public class depthTree39_1 {
    public int TreeDepth(TreeNode23 pRoot){
        if(pRoot == null) return 0;
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        //叶子节点左右孩子的高度为0，所以该叶子节点的高度必然是高度+1 
        return 1 + (left > right ? (left):(right ));
    }
    public static void main(String[] args) {
        int[] a = { 10, 5, 12, 4, 7, -1, -1, -1, 3};
        TreeNode23 root = null;
        //������
        root = new TreeOperate23().createSquence(a, 0);
        System.out.println(new depthTree39_1().TreeDepth(root));
    }
}
