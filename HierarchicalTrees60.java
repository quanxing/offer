package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 层次打印二叉树
 */
public class HierarchicalTrees60 {
    /**
     * 以前写的方法一；队列中每一层的节点后面加一个-1，表示此层的结束
     * @param node
     */
    public static void HierarchicalOrder(TreeNode23 node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode23> q = new LinkedList<TreeNode23>();
        q.add(node);
        TreeNode23 t = new TreeNode23(-1);
        q.add(t);
        
        while (!q.isEmpty()) {
            TreeNode23 tmp = q.poll();
            if (tmp.data != -1) {
                System.out.print(tmp.data + " ");
            }

            if (tmp.left != null) {
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                q.add(tmp.right);
            }

            //如果碰到了队列的队头是   -1说明，该弹出-1，且换行
            //并在队列的尾部添加-1,表示该层的节点都在队列中。-1为结束标志
            if (!q.isEmpty() && q.peek().data == -1) {
                q.poll();
                q.add(t);
                System.out.println();
            }
        }
    }

    /**
     * 方法二就是需要
     * @param pRoot：
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode23 pRoot) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        Queue<TreeNode23> q = new LinkedList<TreeNode23>();
        q.add(pRoot);
        //当前层的节点数目
        int printed = 1;
        //记录节点的所有下层的节点数目
        int nextLevel = 0;
        
        if(pRoot == null){
            return arr;
        }
        while(!q.isEmpty()){
            TreeNode23 node = q.poll();
            layerList.add(node.data);
            
            if(node.left != null){
                q.add(node.left);
                nextLevel++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLevel++;
            }
            --printed;
            /*
             * 队列中上一层的每个节点已经访问完毕（出队），打印
             */
            if(printed == 0){
                arr.add(layerList);
                layerList = new ArrayList<Integer>();
                printed = nextLevel;
                nextLevel = 0;
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] a = { 8, 6, 10, 5,7,9,11};
        TreeNode23 root = null;
        root = new TreeOperate23().createSquence(a,0);
        ArrayList<ArrayList<Integer>> list = new HierarchicalTrees60().Print(root);
        System.out.println(list);
    }
}
