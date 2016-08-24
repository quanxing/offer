package offer;

public class TreeNode23 implements Cloneable {
    int data;
    TreeNode23 left;
    TreeNode23 right;
    boolean isVistied;

    public TreeNode23(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
        left = null;
        right = null;
        isVistied = false;
    }

    public Object clone() {
        Object o = null;
        try {
            o = (TreeNode23) super.clone();// Object 中的clone()识别出你要复制的是哪一个对象。
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

}
