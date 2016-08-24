package offer;
/*
 *输入两颗二叉树A，B，判断B是不是A的子结构。
 */
public class SubTree18 {
    public boolean isSubTree(TreeNode23 root1, TreeNode23 root2){
        boolean result = false;
        if(root1 != null && root2 != null){
          //简化问题：如果从根节点开始的树不相等，再从左子树开始
            if(root1.data == root2.data){
                result = hasTree(root1, root2);
            }
            if(!result){
                result = isSubTree(root1.left, root2);
            }
            if(!result)
                result = isSubTree(root1.right, root2);
        }
        return result;
    }
    private boolean hasTree(TreeNode23 root1, TreeNode23 root2) {
        //若比较到B中的某个节点，为空，就说明这边比较完成了
        //当然此时A为空与否没有关系，所以只需首先判断B中的比较节点是否为空
        //而且 这个顺序防止了 空指针的引用
        /*if (r1 == null && r2 == null) {
            return true;
        }
        else if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.data != r2.data) {
            return false;
        }*/
        if(root2 == null){
            return true;
        }else if(root1 == null){
          //如果B节点不空，A空，说明当前比较不匹配
            return false;
        }
        if(root1.data != root2.data){
            //若当前节点的值不相等，也不匹配
            //单单两个节点的值相等并不能判断是否子树是否匹配，还得接着比较
            //但是不等的话肯定是false
            return false;
        }
        //r若匹配的话接着比较
        return hasTree(root1.left, root2.left) && hasTree(root1.right, root2.right);
    }
    public static void main(String[] args) {
        int[] a = { 2, 1, 12, 45, 21, 6, 111 };
        int[] b = {1, 45,21};
        TreeNode23 rootA = new TreeOperate23().createSquence(a, 0);
        TreeNode23 rootB = new TreeOperate23().createSquence(b, 0);
        System.out.println(new SubTree18().isSubTree(rootA, rootB));
    }
}
