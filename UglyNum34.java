package offer;

import java.util.Arrays;

public class UglyNum34 {
    //判断一个数为丑数的基本原理
    boolean IsUgly(int num){
        while(num % 2 == 0){
            num /= 2;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 5 == 0){
            num /= 5;
        }
        return num == 1 ? true:false;
    }
    
    int get(int n){
        if(n <= 0)  return 0;
        
        int number = 0; // 个数
        int uglyFound = 0; //c丑数
        
        while(number < n){
            uglyFound++;
            if(IsUgly(uglyFound)){
                number++;
            }
        }
        return uglyFound;
    }
    /*
     * num 表示求 第num个丑数
     */
    public  int getUglyNum(int N){
        if(N < 0) return 0;
        
        int [] UglyArr = new int[N];
        UglyArr[0] = 1;
        int nextIndex = 1;
        
        int multiBy1 = 0;
        int multiBy3 = 0;
        int multiBy5 = 0;
        
        while(nextIndex < N){
            int min = min(UglyArr[multiBy1] *2, UglyArr[multiBy3] *3, UglyArr[multiBy5]*5);
            UglyArr[nextIndex++] = min;
            
            /*
             * 下面就是下一轮while 循环 找到大于当前min   中的最小值
             * 
             * 找到max1, max2,max3中最小的值
             * 所以就要记住下标 max1 的multiBy1；max2的multiBy3....在下一次循环中用
             */
            while(UglyArr[multiBy1] * 2 <= min){
                multiBy1++;
            }
            //max1 =multiBy1 *2; 
            
            while(UglyArr[multiBy3] * 3 <= min){
                multiBy3++;
            }
            //max2 =multiBy3 *3; 
            
            while(UglyArr[multiBy5] * 5 <= min){
                multiBy5++;
            }
            //max3 =multiBy5 *5; 
        }
        System.out.println(Arrays.toString(UglyArr));
        return UglyArr[nextIndex - 1];
    }
    
    public int min(int by1, int by3, int by5){
        int min = (by1 < by3)?by1:by3;
        return min < by5 ? min:by5;
    }
    
    public static void main(String[] args) {
        int N = 11;
        System.out.println(new UglyNum34().getUglyNum(N));
    }
}
