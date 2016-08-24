package offer;

import java.util.*;
/**
 * 分层打印二叉树
 * 但是每层的打印顺序  互相相反
 * @author fqx
 *
 */
public class printTreeInverse61 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode23 pRoot) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> layerList = new ArrayList<Integer>();
        Queue<TreeNode23> q = new LinkedList<TreeNode23>();

        q.add(pRoot);

        // 当前层的节点数目
        int printed = 1;
        // 记录节点的所有下层的节点数目
        int nextLevel = 0;
        // 从右往左打印:从第二层开始；第一层只有一个节点
        boolean leftToRight = false;

        if (pRoot == null) {
            return arr;
        }
        while (!q.isEmpty()) {
            TreeNode23 node = q.poll();
            layerList.add(node.data);

            if (node.left != null) {
                q.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                q.add(node.right);
                nextLevel++;
            }

            --printed;
            /*
             * 队列中上一层的每个节点已经访问完毕（出队），打印
             */
            if (printed == 0) {
                // 逆序
                if(!leftToRight){
                    arr.add(layerList);
                }else{
                    arr.add(reverse(layerList));
                }
                //打印顺序变换
                leftToRight = !leftToRight;
                
                layerList = new ArrayList<Integer>();
                // 统计  层之间变换的
                printed = nextLevel;
                nextLevel = 0;
            }
        }
        return arr;
    }
    
    private ArrayList reverse(ArrayList<Integer> layerList) {    
        int length = layerList.size();
        ArrayList<Integer> reverseList = new ArrayList<Integer>();
        for(int i = length-1; i >= 0;i--){
            reverseList.add(layerList.get(i));
        }
        return reverseList;
    }
    
    
    public static ArrayList<ArrayList<Integer> > printTree(TreeNode23 pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode23> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;
         
        while (queue.size() != 1) {
            TreeNode23 node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode23> iter = null;
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode23 temp = (TreeNode23)iter.next();
                    list.add(temp.data);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
         
        return ret;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreeNode23 root = null;
        root = new TreeOperate23().createSquence(a, 0);
        ArrayList<ArrayList<Integer>> list = new printTreeInverse61().Print(root);
        System.out.println(list);
        
        System.out.println("其他方法");
        list = printTree(root);
        System.out.println(list);
    }

}
