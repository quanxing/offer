package offer;
import java.util.*;
/*
 * 打印1到最大的n位数
 */
public class PrintToN12 {
    public void printN(int n){
        if(n <= 0){
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while(!Increment(number)){
            PrintNumber(number);
        }
    }
    
    public void PrintNumber(char[] c){
        String str = new String(c);
        int i = 0;
        //开始的0不打印
        for (i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) - '0' != 0) {
                break;
            }
        }
        System.out.println(str.substring(i, str.length()));
    }
    
    public boolean Increment(char[] c){
        boolean isOverflow = false;
        //进位
        int nTakeOver = 0;
        int nsum = 0;
        //从低位开始
        for (int i = c.length - 1; i >= 0; i--) {
            //得到当前位的值是多少
            nsum = c[i] - '0' + nTakeOver;
            //然后最低位加1，其他高位只能是加上进位
            if(i == c.length - 1) nsum++;
            
            if(nsum >= 10){
                if(i == 0){
                    //溢出了，最高位等于9时，加1后
                    isOverflow = true;
                }else{
                    c[i] = '0';
                    nTakeOver = 1;
                }
            }else{
                c[i] = (char)(nsum + '0');
                break;
            }
        }
        return isOverflow;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        new PrintToN12().printN(n);
        
    }
}
