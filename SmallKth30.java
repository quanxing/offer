package offer;
import java.util.*;
/*
 * 最小的K个数
 * 同时也可以求第k个最小的数
 * 同时通过降序排列，那么第K个就是第K个最大的数了，需要修改partition方法-降序排列即可
 * 利用partition方法：partitoin一次就有 第index 的位置固定了。
 */
public class SmallKth30 {
    
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
    
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //异常情况
        if(input == null || input.length == 0 ) return list;
        if(k <= 0 || k > input.length ) return list;
        
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        
        System.out.println("index: " + index);
        System.out.println(Arrays.toString(input));
        
        while(index != k - 1){
            if(index < k -1){
                index = partition(input, index + 1 , end);
            }else if(index > k - 1){
                index = partition(input, start, index - 1);
            }
        }
        
        System.out.println("第k小的数：" + input[k-1]);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    //用堆得方法解决这个问题；建成K个元素大根堆  big heap
    
    /*
     * 调整堆
     */
    public static void adjust(int [] array, int s, int m){
        //save array[s] to variable   rc;
        int rc = array[s];
        //for (int i = 2 * s + 1; i < m; i = i * 2 + 1) {
        int i = 2 * s + 1;
        while(i <= m){
            //step 1:find ith node's child nodes, choose the max,
            if ( i < m && array[i] < array[i + 1]) i++;
            // step2:the max compare with the ith node,
            if (rc >= array[i]){
                break;
            }
            // step3:finally then change the position.
            array[s] = array[i];
            s = i;
            //下一个待比较的节点
            i = 2 * s + 1;
        }
        //i = 2*s + 1 > m时 s为上一个合法的i
        array[s] = rc; 
    }
    /**
     * 堆排序 
     * @param array
     *            堆是一个数组
     * @param k
     *            第K个元素
     */
    public void sortHeap(int [] array, int k){
        
        for (int i = (k - 1 - 1)/2; i >= 0; --i) {
            adjust(array, i, k - 1);
        }
        
    }
    
    public ArrayList<Integer> getSmallK_Heap(int [] array, int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array == null || array.length == 0 ) return list;
        if(k <= 0 || k > array.length ) return list;
        
        //维持k个最下的元素
        sortHeap(array , k);
        
        //维持k个最下的元素
        for (int i = k; i < array.length; i++) {
            if(array[i] < array[0]){
                array[0] = array[i];
                sortHeap(array , k);
            }
        }
        
        for (int i = 0; i < k; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public static void show(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String [] args){
        int a [] = {4, 5, 1, 6, 2, 7, 3, 8};
        //这个打印出来是最小的升序的结果
        System.out.println( new SmallKth30().GetLeastNumbers_Solution(a,3));
        //这是堆排序的结果，打印出来并不是升序的情况
        System.out.println( new SmallKth30().getSmallK_Heap(a,4));
    }
}
