package offer;
/*
 * 平衡二叉树
 */
public class BalanceTree39 {
    /*
     * 后序遍历
     */
    public boolean IsBalanced_Solution(TreeNode23 root) {
        int [] depth = {0};
        return isBalanced_2(root, depth);
    }
    
    //效率高的方法
    /**
     * 
     * @param root
     * @param depth
     *            当前以root为根节点的树的高度
     * @return
     */
    boolean isBalanced_2(TreeNode23 root, int[] depth){
        if (root == null) {
            depth[0] = 0;
            return true;
        }

        int[] left = {0};
        int[] right = {0};

        if (isBalanced_2(root.left, left) && isBalanced_2(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    /*
     *下面的方法是中序遍历的思想
     */
    boolean isBalanced(TreeNode23 root){
        if(root == null){
            return true;
        }
        
        int left = new depthTree39_1().TreeDepth(root.left);
        int right = new depthTree39_1().TreeDepth(root.right);
        int diff = left - right;
        if(diff > 1 || diff < -1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public static void main(String[] args) {
        int[] a = { 8, 5, 12, 4, 7, -1, -1, -1, 3};
        TreeNode23 root = null;
        root = new TreeOperate23().createSquence(a, 0);
        System.out.println(new  BalanceTree39().IsBalanced_Solution(root));
    }
}
