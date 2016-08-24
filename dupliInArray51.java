package offer;

import java.util.*;

/*
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
public class dupliInArray51 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        List<Integer> ll = new ArrayList<Integer>();
        if(numbers == null || numbers.length < 1){
            return  false;
        }
        // 数字是否有效
        for(int i : numbers){
            if(i < 0 || i >= numbers.length){
                return false;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    if(!ll.contains(numbers[i])){
                        ll.add(numbers[i]);
                    }
                }
                else{
                    swap(numbers, i, numbers[i]);
                }
                
            }
        }
        System.out.println("重复元素:" + ll);
        return false;
    }
    private static void swap(int[] data, int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
    public static void main(String[] args) {
        int[] numbers1 = {1,2,2,2,1,3,3,5};
        int [] result = new int [1];
        System.out.println(new dupliInArray51().duplicate(numbers1, numbers1.length - 1, result));
        System.out.println(Arrays.toString(result));
    }
}
