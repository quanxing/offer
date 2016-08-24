package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * REFS: http://blog.csdn.net/fightforyourdream/article/details/16843303
 * 面试大总结之二：Java搞定面试中的二叉树题目
 * http://blog.csdn.net/luckyxiaoqiang/article/details/7518888 轻松搞定面试中的二叉树题目
 * http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html 算法大全（3） 二叉树
 * 
 * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
 * 2. 求二叉树的深度:
 * getDepthRec（递归），getDepth 
 * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec,
 * preorderTraversal, inorderTraversalRec, postorderTraversalRec
 * (https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_2)
 * 4.分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法） 
 * 5.将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL 
 * 6.求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel 
 * 7.求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf 
 * 8. 判断两棵二叉树是否相同的树：isSameRec,isSame 
 * 9. 判断二叉树是不是平衡二叉树：isAVLRec 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）： mirrorRec,
 * mirrorCopyRec mirror, mirrorCopy 
 * 10.1 判断两个树是否互相镜像：isMirrorRec isMirror 
 * 11.求二叉树中两个节点的最低公共祖先节点： LAC 求解最小公共祖先, 
 * 使用list来存储path. LCABstRec 递归求解BST树. LCARec
 * 递归算法 . 
 * 12.求二叉树中节点的最大距离：getMaxDistanceRec 
 * 13.由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec 
 * 14.判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec 
 * 15.找出二叉树中最长连续子串(即全部往左的连续节点，或是全部往右的连续节点）findLongest
 * 16.判断是不是子树 SubTree18.java
 */

/*
 * class TreeNode{ public int data; public TreeNode left; public TreeNode right;
 * public TreeNode(int data) { // TODO Auto-generated constructor stub this.data
 * = data; } }
 */

public class TreeOperate23{

    // 顺序创建二叉树
    public static TreeNode23 createSquence(int[] a, int i) {
        // -1 null node
        if (a.length < 0 || i < 0 || i >= a.length)
            return null;
        if (a[i] == -1) {
            return null;
        }
        TreeNode23 T;
        T = new TreeNode23(a[i]);
        T.left = createSquence(a, 2 * i + 1);
        T.right = createSquence(a, 2 * i + 2);
        return T;
    }

    public static void create(int[] a, int i, TreeNode23 node) {
        if (a.length < 0 || i < 0 || i >= a.length)
            return;

        node = new TreeNode23(a[i]);
        create(a, 2 * i + 1, node.left);
        create(a, 2 * i + 2, node.right);
    }

    /**
     * 非递归中序遍历
     */
    public static void NonRecusOrder(TreeNode23 root) {
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        TreeNode23 cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            if (!s.isEmpty()) {
                TreeNode23 top = s.pop();
                System.out.println(top.data);
                cur = top.right;
            }
        }
    }

    /**
     * 非递归前序遍历--用栈实现
     */
    public static void NonRecusPreOrder(TreeNode23 root) {
        Stack<TreeNode23> s = new Stack<TreeNode23>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode23 node = s.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
        /*
         * while(root != null || !s.isEmpty()){ while(root != null){
         * s.push(root); System.out.println(root.data); root = root.left; }
         * if(!s.isEmpty()){
         * 
         * TreeNode top = s.pop(); root = top.right; } }
         */
        
    }

    /**
     * 非递归后序遍历1
     */
    public static void NonRecusPostOrder(TreeNode23 root) {

        Stack<TreeNode23> s = new Stack<TreeNode23>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                if (root.isVistied == true) {
                    break;
                } else {
                    s.push(root);
                    root.isVistied = true;
                    root = root.left;
                }
            }
            if (!s.isEmpty()) {
                // 先入栈 父节点的右孩子
                if (s.peek().right != null) {
                    root = s.peek().right;
                    // 右孩子被访问过了那么就打印并弹出，root重新指向栈顶元素
                    if (root.isVistied == true) {
                        System.out.print(s.pop().data + " ");
                        if (!s.isEmpty()) {
                            root = s.peek();
                        } else {
                            break;
                        }
                    }
                }
                // 如果右孩子为空，那么该节点可以打印并出栈了，此节点为叶子节点
                else {
                    TreeNode23 top = s.pop();
                    System.out.print(top.data + " ");
                    root = s.peek();
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历2 两个栈实现后序
     */
    public static void postorderTraversal(TreeNode23 root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode23> s = new Stack<TreeNode23>(); // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode23> output = new Stack<TreeNode23>();// 第二个stack用于翻转第一个stack输出

        s.push(root);
        while (!s.isEmpty()) { // 确保所有元素都被翻转转移到第二个stack
            TreeNode23 cur = s.pop(); // 把栈顶元素添加到第二个stack
            output.push(cur);

            if (cur.left != null) { // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            }
        }

        while (!output.isEmpty()) { // 遍历输出第二个stack，即为后序遍历
            System.out.print(output.pop().data + " ");
        }

    }

    /**
     * 递归前序遍历
     * 
     * @param node
     */
    public static void preOrder(TreeNode23 node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 递归中序遍历
     * 
     * @param node
     */
    public void inOrder(TreeNode23 node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    /**
     * 递归后序遍历
     * 
     * @param node
     */
    public void postOrder(TreeNode23 node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    /**
     * 从上到下打印二叉树
     * 
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode23 root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode23> q = new LinkedList<TreeNode23>();
        if (root == null)
            return list;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode23 node = q.poll();
            list.add(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return list;
    }

    /*
     * HierarchicalTrees60 这个类中的方法更科学一些 本方法就是自己为解题二想的方法 TreeNode(-1)
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

            if (!q.isEmpty() && q.peek().data == -1) {
                q.poll();
                q.add(t);
                System.out.println();
            }
        }
    }

    /**
     * 对换二叉树--二叉树镜像
     * 
     * @param node
     */
    public static void InvertTree(TreeNode23 node) {
        if (node == null) {
            return;
        } else {
            TreeNode23 tmp = node.right;
            node.right = node.left;
            node.left = tmp;

            InvertTree(node.left);
            InvertTree(node.right);
        }
    }

    /**
     * 求二叉树的节点个数 非递归 0(n) 若非递归则用到了队列：出队入队可以对节点进行计数
     * 
     * @param root
     * @return
     */

    public static int getNodeNumRec(TreeNode23 root) {
        if (root == null) {
            return 0;
        } else {
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
        }
    }

    /**
     * 求二叉树的深度（高度） 非递归解法： O(n) （1）如果二叉树为空，二叉树的深度为0 （2）如果二叉树不为空，二叉树的深度 =
     * max(左子树深度， 右子树深度) + 1 非递归：类似于分层打印二叉树的方法
     */
    public static int getDepthRec(TreeNode23 root) {
        /*
         * if(root == null){ return 0; } int leftDepth = getDepthRec(root.left);
         * int rightDepth = getDepthRec(root.right); return Math.max(leftDepth,
         * rightDepth) + 1;
         */

        Queue<TreeNode23> q = new LinkedList<TreeNode23>();
        q.add(root);
        int CurLevelNodes = 1;
        int NextLevelNodes = 0;
        int depth = 0;
        while (!q.isEmpty()) {
            TreeNode23 node = q.poll();
            CurLevelNodes--;

            if (node.left != null) {
                q.add(node.left);
                NextLevelNodes++;
            }
            if (node.right != null) {
                q.add(node.right);
                NextLevelNodes++;
            }
            // CurLevelNodes == 0说明当一层遍历完 depth += 1
            if (CurLevelNodes == 0) {
                depth++;
                CurLevelNodes = NextLevelNodes;
                NextLevelNodes = 0;
            }
        }
        return depth;
    }

    /**
     * 求二叉树第K层的节点个数 迭代解法： 同getDepth的迭代解法
     */
    public static int getNodeNumKthLevel(TreeNode23 root, int k) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode23> queue = new LinkedList<TreeNode23>();
        queue.add(root);

        int i = 1; // 第1层
        int currentLevelNodes = 1; // 当前Level，node的数量
        int nextLevelNodes = 0; // 下一层Level，node的数量

        while (!queue.isEmpty() && i < k) {
            TreeNode23 cur = queue.remove(); // 从队头位置移除
            currentLevelNodes--; // 减少当前Level node的数量
            if (cur.left != null) { // 如果有左孩子，加到队尾
                queue.add(cur.left);
                nextLevelNodes++; // 并增加下一层Level node的数量
            }
            if (cur.right != null) { // 如果有右孩子，加到队尾
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
                currentLevelNodes = nextLevelNodes; // 下一层的结点个数
                nextLevelNodes = 0;
                i++; // 进入到下一层
            }
        }

        return currentLevelNodes;
    }

    /**
     * 求二叉树中叶子节点的个数（递归）； 递归思想
     */
    public static int getNodeNumLeafRec(TreeNode23 root) {
        // 当root不存在，返回空
        if (root == null) {
            return 0;
        }

        // 当为叶子节点时返回1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 把一个树拆成左子树和右子树之和，原理同上一题
        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    /**
     * 求二叉树中叶子节点的个数（迭代） 层次遍历时判断每个节点比较简单； 其实中序遍历也可以实现，加一句代码即可
     */
    public static int getNodeNumLeaf(TreeNode23 root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode23> queue = new LinkedList<TreeNode23>();
        queue.add(root);

        int leafNodes = 0; // 记录上一个Level，node的数量

        while (!queue.isEmpty()) {
            TreeNode23 cur = queue.remove(); // 从队头位置移除
            if (cur.left != null) { // 如果有左孩子，加到队尾
                queue.add(cur.left);
            }
            if (cur.right != null) { // 如果有右孩子，加到队尾
                queue.add(cur.right);
            }
            if (cur.left == null && cur.right == null) { // 叶子节点
                leafNodes++;
            }
        }

        return leafNodes;
    }

    /**
     * 判断两棵二叉树是否相同完全一致。 
     * 递归解法： （1）如果两棵二叉树都为空，返回真 （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     */
    public static boolean isSameRec(TreeNode23 r1, TreeNode23 r2) {
        // 如果两棵二叉树都为空，返回真
        if (r1 == null && r2 == null) {
            return true;
        }
        // 如果两棵二叉树一棵为空，另一棵不为空，返回假
        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.data != r2.data) {
            return false;
        }
        boolean leftRes = isSameRec(r1.left, r2.left); // 比较对应左子树
        boolean rightRes = isSameRec(r1.right, r2.right); // 比较对应右子树
        return leftRes && rightRes;
    }

    /**
     * 判断二叉树是不是平衡二叉树 递归解法： （1）如果二叉树为空，返回真
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     * 
     * 
     * BalanceTree 实现了两种方法
     */

    /**
     * 求二叉树的镜像 递归解法： （1）如果二叉树为空，返回空 （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
     * 
     */
    // 1. 破坏原来的树，把原来的树改成其镜像--递归
    public static TreeNode23 mirrorRec(TreeNode23 root) {
        if (root == null) {
            return null;
        }

        TreeNode23 left = mirrorRec(root.left);
        TreeNode23 right = mirrorRec(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    // 1. 破坏原来的树，把原来的树改成其镜像 --循环的方法
    public static void mirror(TreeNode23 root) {  
        if(root == null){  
            return;  
        }  
          
        Stack<TreeNode23> stack = new Stack<TreeNode23>();  
        stack.push(root);  
        while( !stack.isEmpty() ){
            TreeNode23 cur = stack.pop();  
              
            // 交换左右孩子  
            TreeNode23 tmp = cur.right;  
            cur.right = cur.left;  
            cur.left = tmp;  
              
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
        NonRecusPreOrder(root);
    }  
    
    
    
    
    // 2. 不能破坏原来的树，返回一个新的镜像树 递归
    public static TreeNode23 mirrorCopyRec(TreeNode23 root) {
        if (root == null) {
            return null;
        }

        TreeNode23 newNode = new TreeNode23(root.data);
        newNode.left = mirrorCopyRec(root.right);
        newNode.right = mirrorCopyRec(root.left);

        return newNode;
    }
    // 2_1. 不能破坏原来的树，返回一个新的镜像树 非递归 
    public static TreeNode23 mirrorCopy(TreeNode23 root) {
        if (root == null) {
            return null;
        }

        TreeNode23 newRoot = new TreeNode23(root.data);
        Queue<TreeNode23> q = new LinkedList<TreeNode23>();
        q.add(root);
        
        Queue<TreeNode23> q1 = new LinkedList<TreeNode23>();
        q1.add(newRoot);
        
        while(!q.isEmpty() && !q1.isEmpty()){
            TreeNode23 oldcur = q.poll();
            TreeNode23 newcur = q1.poll();
            
            if(oldcur.right != null){
                newcur.left = new TreeNode23(oldcur.right.data);
                q.add(oldcur.right);
                q1.add(newcur.left);
            }
            if(oldcur.left != null){
                newcur.right =  new TreeNode23(oldcur.left.data);
                q.add(oldcur.left);
                q1.add(newcur.right);
            }
            
        }
        return newRoot;
    }
    /**
     * SymmetricalTree59 实现二叉树是否对称 等同于 判断两个树是否互相镜像
     * 
     * @param args
     */

    /**
     *  求二叉树中两个节点的最低公共祖先节点 递归解法： （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     */
    public static TreeNode23 getLastCommonParentRec(TreeNode23 root, TreeNode23 n1,
            TreeNode23 n2) {
        // 如果n1在树的左子树
        if (findNodeRec(root.left, n1)) {
            // 如果n2在树的右子树
            if (findNodeRec(root.right, n2)) {
                // 返回根节点
                return root;
            } else { // 如果n2也在树的左子树
                // 递归处理
                return getLastCommonParentRec(root.left, n1, n2);
            }
        } else { // 如果n1在树的右子树
            if (findNodeRec(root.left, n2)) { // 如果n2在左子树
                return root;
            } else { // 如果n2在右子树
                return getLastCommonParentRec(root.right, n1, n2); // 递归处理
            }
        }
    }

    // 递归判断一个点是否在树里;常用的方法
    //会重复查找子树
    private static boolean findNodeRec(TreeNode23 root, TreeNode23 node) {
        if (root == null || node == null) {
            return false;
        }
        
        if (root == node) {
            return true;
        }

        // 先尝试在左子树中查找
        boolean found = findNodeRec(root.left, node);

        // 如果查找不到，再在右子树中查找
        if (!found) {
            found = findNodeRec(root.right, node);
        }
        return found;
    }

    /**
     * 非递归解法： 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
     */
    public static TreeNode23 getLastCommonParent(TreeNode23 root, TreeNode23 n1,
            TreeNode23 n2) {
        if(root == null || n1 == null || n2 == null) return null;
        ArrayList<TreeNode23> p1 = new ArrayList<TreeNode23>();
        boolean found_n1 = getNodePath(root, n1, p1);
        
        ArrayList<TreeNode23> p2 = new ArrayList<TreeNode23>();
        boolean found_n2 = getNodePath(root, n2, p2);
        if(!found_n1 || !found_n2) return null;
        int len = 0;
        int i = 0;
        for ( i = 0; i < ( len = p1.size() > p2.size() ? p2.size() : p1.size()); i++) {
            if(p1.get(i) != p2.get(i)){
                break;
            }
        }
        i--;
        return p1.get(i);
    }
    // 把从根节点到node路径上所有的点都添加到path中  
    private static boolean getNodePath(TreeNode23 root, TreeNode23 node,
            ArrayList<TreeNode23> path){
        
        if(root == null){
            return false;
        }
        //尽力将root加入path，如果到叶子节点没有找到，那么会将路径中最后一个节点删除
        path.add(root);
        
        if(root.data == node.data){
            return true;
        }
        //左子树
        boolean found = false;
        found = getNodePath(root.left, node, path);
        //右子树查找
        if(!found){
            found = getNodePath(root.right, node, path);
        }
        
        //如果没找到，且当前节点的左右孩子节点均为空，那么删除
        if(!found){
            path.remove(root);
        }
        
        return found;
    }

    /**
     * 1各种方法方法建立二叉树
     * 2完全二叉树
     * 3求二叉树中节点的最大距离
     * @param args
     */
    
    
    
    // 2. 不能破坏原来的树，返回一个新的镜像树 递归
    public static void CopyRec(TreeNode23 root,TreeNode23 rootb) {
        if (root == null) {
            return ;
        }

        rootb = new TreeNode23(root.data);
        CopyRec(root.right,rootb.left);
        CopyRec(root.left,rootb.right);

    }
    
    public static void main(String[] args) {
        // int[] a = { 2, 1, 12, 45, 21, 6, 111 };
        int[] a = { 8, 5, 12, 4, 7, -1, -1, 9, 3 };
        /*
         *      8  
         *   5     12 
         * 4     7 
         *9    3
         */

        TreeNode23 root = null;
        root = createSquence(a, 0);
        TreeNode23 rootb = null;
        CopyRec(root, rootb);
        System.out.println("\n非递归前序");
        NonRecusPreOrder(rootb);
        System.out.println("\n非递归后序1");
        NonRecusPostOrder(rootb);
        System.out.println("\n非递归后序2");
        postorderTraversal(rootb);
        /*
         * //锟斤拷锟斤拷锟斤拷 new TreeOperate().postOrder(root);
         */
        /*
         * //锟斤拷转锟斤拷 InvertTree(root); System.out.println(); preOrder(root);
         * System.out.println(); HierarchicalOrder(root);
         */

        // System.out.println(PrintFromTopToBottom(root));
        /*System.out.println("\n二叉树结点个数");
        int n = getNodeNumRec(root);
        System.out.println(n);
        System.out.println("\n二叉树的高度");
        int depth = getDepthRec(root);
        System.out.println(depth);
        System.out.println("\n二叉树第k层的节点数目");
        int num = getNodeNumKthLevel(root, 4);
        System.out.println(num);
        System.out.println("\n非递归求二叉树的镜像");
        TreeNode23 ro = mirrorCopyRec(root);
        NonRecusPreOrder(ro);
        System.out.println("\n==");
        TreeNode23 root_new = mirrorCopy(root); //ok
        NonRecusPreOrder(root_new);
        
        System.out.println("\n两个节点中的最低公共节点");
        TreeNode23 n1 = new TreeNode23(3);
        TreeNode23 n2 = new TreeNode23(7);
        TreeNode23 node = getLastCommonParent(root, n1, n2);
        if(node != null){
            System.out.println(node.data);
        }else{
            System.out.println("not found");
        }*/
    }
}
