package offer;
import java.util.*;
/*
 * 和为s 的两个数VS 和为s的连续正数序列
 */
public class equalSum41 {
    //和为s  连续正数  序列
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > list = 
                new ArrayList<ArrayList<Integer>>();
        
        if(sum < 3){
            return list;
        }
        int small = 1;
        int big = 2;
        // two num ; good 
        //两个数的和sum那么最近的就是7+8 ;所以small=7,big=8
        int middle = (1 + sum )/ 2;
        
        int curSum = big + small;
        
        ArrayList<Integer> ll = null;
        while(small < middle){
            if(curSum == sum){
                ll = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    ll.add(i);
                }
                list.add(ll);
                
                big++;
                curSum += big;
            }else if(curSum < sum){
                big++;
                curSum += big;
            }else{
                curSum -= small;
                small++;
            }
        }
        return list;
    }
    
    //和为s的两个数;数组是递增排序的
    /**
     * 这里实现的是 一个排序的数组 任意的元素的和为 sum的组合
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null) return list;
        
        int low = 0;
        int high = array.length - 1;
        boolean found = false;
        int multiMin = 0;
        while(low < high){
            int result = array[low] + array[high];
            if(result > sum){
                high -= 1;
            }else if(result < sum ){
                low += 1;
            }else{
                
               if(found){
                   //已经找到了
                   if(multiMin <= array[low] * array[high]){
                   }else{
                       list = new ArrayList<Integer>();
                       list.add(array[low]);
                       list.add(array[high]);
                   }
               }else{
                   //第一次找到一组数据
                   found = true;
                   list = new ArrayList<Integer>();
                   multiMin = array[low] * array[high];
                   list.add(array[low]);
                   list.add(array[high]);
               }
               low += 1;
               high -= 1;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(new equalSum41().FindNumbersWithSum(data, 8));
        System.out.println(new equalSum41().FindContinuousSequence(15));
    }
}
