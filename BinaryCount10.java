package offer;
/*
 * ������Ķ����Ƹ���
 * 
 * �߼��ľͶ����Ƶķ���
 * ��һ�������һ֮���ٺ�ԭ����������λ�����㣬�õ��Ľ���൱��
 * ������Ķ����Ʊ�ʾ�����ұߵ� 1 ��� 0 ��
 */
public class BinaryCount10 {
    public int num_1(int n){
        /*
         * 右移n，逐个与1得到1的个数
         * 但是当为负数右移会出现 死循环
         */
       /* int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }*/
        
        /*
         * 改进上面的方法
         * 移动flag ，不会出现负数移位左边补1的情况
         */
        int count = 0;
        int flag = 1;
        //移动flag
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            //flag每次与高位比较
            flag = flag <<1;
        }
        return count;
        
        //有几个1就循环几次高效地算法
       /* int count = 0;
        while(n != 0){
            //n!= 0 那么 count + 1
            count++;
            //n-1 分两种个情况
            //1:最后一位就是1，最后减一，最后一位直接=0，左边的不变，那么n-1) & n 就是最后一位变成0；
            //2：最后一位为0，那么从右到左碰到的第一个1变成0 ，右边的0全部变成1，左边的不变
            //这样的操作下来就可以统计出 从右到左 有多少个1。
            n = (n - 1) & n;
        }
        return count;*/
    }
    public static void main(String[] args) {
        System.out.println(new BinaryCount10().num_1(19934318));
    }
}
