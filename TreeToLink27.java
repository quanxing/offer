package offer;

import java.util.*;

/*
 * 二叉查找树转链表---中序思想
 */
public class TreeToLink27 {
    public TreeNode23 Convert(TreeNode23 root){
        if (root == null) return null;
        TreeNode23 head = null;
        TreeNode23 p = null;
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            if(!s.isEmpty()){
                TreeNode23 top = s.pop(); 
                //头结点
                if(head == null){
                    head = top;
                    p = head;
                }
                //双向连接
                else{
                    p.right = top;
                    top.left = p;
                    p = top;
                }
                root = top.right;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {10, 6 ,14, 4, 8, 12, 16};
        TreeNode23 root = null;
        //������
        root = new TreeOperate23().createSquence(a, 0);
        TreeNode23 lroot = new TreeToLink27().Convert(root);
        TreeNode23 p = lroot;
        while(p.right != null){
            System.out.println(p.data);
            p = p.right;
        }
        System.out.println(p.data);
        System.out.println("=====");
        while(p.left != null){
            System.out.println(p.data);
            p = p.left;
        }
        System.out.println(p.data);
    }

}
