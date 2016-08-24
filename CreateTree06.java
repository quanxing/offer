package offer;

import java.util.Arrays;
/*
 * 根据前序遍历和中序遍历构建二叉树
 * 
 * 根据中序遍历和后序遍历构建二叉树
 */


public class CreateTree06 {

    //递归方法1
    public TreeNode23 reConstructBinaryTree(int[] pre, int[] in) {
        // ����
        if (((pre.length == 0 || in.length == 0)) || pre.length != in.length) {
            return null;
        }
        
        int i = 0, j = 0;
        TreeNode23 node = new TreeNode23(pre[i]);
        while(in[j] != node.data){
            j++;
        }
        
        int[] left_pre = new int[j];
        int[] left_in = new int[j];
        int[] right_pre = new int[pre.length - j -1];
        int[] right_in = new int[in.length - j - 1];
        for(i = 0; i < in.length ; i++){
            if(i < j){
                left_in[i] = in[i];
                left_pre[i] = pre[i + 1];
            }else if(i > j){
                //����J ֮�� �������������˵��ͬ��
                //ǰ���Ѿ���j+1��Ԫ���ˣ���ʱ��i = j + 1�����ұߵ�������±�Ӧ��i - (j + 1)��ʼ����0��ʼ
                right_in[i - (j + 1)]= in[i];
                right_pre[i - (j + 1)] = pre[i];
            }
        }
        node.left = reConstructBinaryTree(left_pre, left_in);
        node.right = reConstructBinaryTree(right_pre, right_in);
        return node;
    }
    
    //中序遍历树
    public static void midTraverse(TreeNode23 node) {
        if (node != null) {
            if (node.left != null) {
                midTraverse(node.left);
            }
            System.out.print(node.data + " ");
            if (node.right != null) {
                midTraverse(node.right);
            }
        }
    }
    
  //后序遍历  
   static void PostOrder(TreeNode23 T){  
        if(T != null){  
            //访问左子结点  
            PostOrder(T.left);  
            //访问右子结点  
            PostOrder(T.right);  
            //访问根节点  
            System.out.print(T.data + " ");
        }  
    } 

    //递归版本2
    public TreeNode23 reConstructBinaryTree2(int[] pre, int[] in){
        TreeNode23 root = create(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
    public TreeNode23 create(int[]pre, int pre_start, int pre_end, int []in, 
            int in_start, int in_end){
        if(pre_start > pre_end || in_start > in_end){
            return null;
        }
        TreeNode23 root = new TreeNode23(pre[pre_start]);
        //在中序中找到根节点将数据分为两半
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[pre_start]){
                root.left = create(pre, pre_start + 1, pre_start + i - in_start,
                        in, in_start, i - 1);
                //i - in_start == 左子树元素个数
                root.right = create(pre, pre_start + i - in_start + 1, pre_end, 
                        in, i + 1, in_end);
            }
        }
        return root;
    }
    
    
    /**
     * 递归版本3 根据中序和后序建立二叉树
     * @param pre
     * @param post
     * @return
     */
    public TreeNode23 reConstructBinaryTree3(int[] post, int[] in){
        TreeNode23 root = create3(post, 0, post.length - 1, in, 0, in.length - 1);
        return root;
    }
    public TreeNode23 create3(int[]post, int post_start, int post_end, int []in, 
            int in_start, int in_end){
        if(post_start > post_end || in_start > in_end){
            return null;
        }
        TreeNode23 root = new TreeNode23(post[post_end]);
        //在中序中找到根节点将数据分为两半
        for (int i = 0; i < in.length; i++) {
            if(in[i] == post[post_end]){
                //后序序列中：左子树范围[post_start,post_start + i - in_start - 1]
                //中序序列中：左子树范围[in_start, i - 1]
                root.left = create3(post, post_start, post_start + i - 1 - in_start,
                        in, in_start, i - 1);
                //i - in_start == 左子树元素个数
                //后序序列中：右子树范围[post_start,post_start + i - in_start]
                //中序序列中：右子树[i + 1, in_end]
                root.right = create3(post, post_start + i - in_start, post_end - 1, 
                        in, i + 1, in_end);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {

        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
//        int[] a = Arrays.copyOfRange(pre, 0 + 1, 4);
//        System.out.println(Arrays.toString(a));
        System.out.println("\n前序和中序建立二叉树");
        TreeNode23 root = new CreateTree06().reConstructBinaryTree2(pre, in);
        PostOrder(root);
        
        System.out.println("\n中序和后序建立二叉树");
        int [] post = { 7, 4 ,2, 5, 8, 6, 3, 1 };
        
        TreeNode23 root_1 = new CreateTree06().reConstructBinaryTree3(post, in);
        new TreeOperate23().preOrder(root_1);
    }
}
