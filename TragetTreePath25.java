package offer;
import java.util.*;


public class TragetTreePath25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode23 root,
            int target) {
       
        ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        if(root == null){
            return pathlist;
        }
        int sum = 0;
        findPathC(root, target, sum, pathlist, s);
        return pathlist;
    }
    
    private void findPathC(TreeNode23 node, int target, int sum,
            ArrayList<ArrayList<Integer>> path,Stack<TreeNode23> s){
        
        if(node == null) return ;
        
        s.push(node);
        sum += node.data;
        //叶子节点
        if(node.left == null && node.right == null){
            if(sum == target){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (TreeNode23 treeNode : s) {
                    arr.add(treeNode.data);
                }
                path.add(arr);
            }
        }
        
        if(node.left != null){
            findPathC(node.left, target, sum, path, s);
        }
        if(node.right != null){
            findPathC(node.right, target, sum, path, s);
        }
        s.pop();
    }
    
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode23 root, int target){
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        
        int sum = 0;
        TreeNode23 last = null; //
        while(root != null){
            while(root != null){
                sum += root.data;
                s.push(root);
                last = root;
//                root.isVistied = true;
                if(root.left == null && root.right == null){
                    if(sum == target){
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        for (TreeNode23 nodet : s) {
                            arr.add(nodet.data);
                        }
                        path.add(arr);
                    }
                    //Ҷ�ӽڵ���ȥ��
                    sum -= s.pop().data;
                }
                root = root.left;
            }
            if(!s.isEmpty()){
                TreeNode23 top = s.peek();
//                if(!top.right.isVistied){
                if(top.right != last){
                    root = top.right;
                }else{
                    sum -= s.pop().data;
                    if(sum == 0){
                        break;
                    }
                    root = s.peek().right;
                }
            }
        }
        return path;
    }
    public static void main(String[] args) {
        TreeOperate23 op = new TreeOperate23();
        int[] a = { 10, 5, 12, 4, 7, -1, -1, -1, 2};
//        int [] a = {5,4,-1,3,-1,-1,-1,-1,-1,-1,-1};
        TreeNode23 root = null;
        //������
        root = op.createSquence(a,0);
        ArrayList<ArrayList<Integer>> ll1 = new TragetTreePath25().FindPath(root,22);
        System.out.println(ll1);
        ArrayList<ArrayList<Integer>> ll = new TragetTreePath25().FindPath2(root, 22);
        System.out.println(ll);
    }
}
