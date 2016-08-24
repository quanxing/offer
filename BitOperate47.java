package offer;
/*
 * 位运算
 * 实现加减乘除
 */
public class BitOperate47 {
    //位运算加法
    static int add(int a, int b ){
     /*   while(b != 0){
            int ans = a ^ b;
            b = (a & b ) << 1;
            a = ans;
        }
        return a;*/
        /*
         * 递归
         */
        if(b == 0) return a;
        //不带进位的二进制加法
        int sum = a ^ b ;
        //进位左移相当于在产生  进位的位置  的高位 加上进位
        int carry = (a&b) << 1;
        return add(sum, carry);
        
    }
    //位运算减法
    //位运算乘法
    //尾位运算除法
    
    //位运算交换变量的值，不用第三变量
    static void swap( int a , int b ){
        System.out.println("转换前：" + a + " " +  b);
        /*a = a + b ;
        b = a - b; // a
        a = a - b; // b;
*/        
        a = a ^ b;
        b = a ^ b; // a^b^ b 可定等于    a => b = a 
        a = a ^ b; //a^b^ a 等于b
        System.out.println("转换前：" + a + " " +  b);
    }
    public static void main(String[] args) {
        System.out.println(add(5, 17));
        System.out.println(add(-1,-2));
        swap(-1, -2);
    }
}
