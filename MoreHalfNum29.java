package offer;

import java.util.Arrays;
import java.util.*;

import ds.quickSort;
public class MoreHalfNum29 {
    
    public int partition(int [] a, int i, int j){
        if(a.length == 0) return -1;
        int key = a[i];
        while(i < j){
            while(i < j && a[j] >= key) j--;
            
            if(i < j) a[i++] = a[j]; 
            
            while(i < j && a[i] <= key) i++;
            if(i < j) a[j--] = a[i];
        }
        a[i] = key;
        return i;
    }
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array.length == 0) return 0;
        
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        
        int index = partition(array, start, end );
        System.out.println("index：" + index);
        System.out.println(Arrays.toString(array));
        
        while(index != middle){
            if(index > middle){
                end = index - 1;
                index = partition(array, start, end);
            }else if(index < middle) {
                start = index + 1;
                index = partition(array, start, end);
            }
            System.out.println("index：" + index);
            System.out.println(Arrays.toString(array));
        }
        
        int result = array[index];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == result){
                count++;
            }
        }
        if(2*count <= array.length ){
            return 0;
        }else{
            return result;
        }
    }
    /*
     * 统计方法
     */
    public int MoreThanHalfNum_Solution_2(int [] array) {
        if(array == null || array.length == 0) return 0;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            //下一个新词的计数开始
            if(times == 0){
                result = array[i];
                System.out.println("resutl "+ result);
                times = 1;
            }else{
                if(result == array[i]){
                    times++;
                }else{
                    times--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int a [] = {1,2,3,2,2,2,2,4,3};
        System.out.println(new MoreHalfNum29().MoreThanHalfNum_Solution_2(a));
    }
}
