package offer;
/*
 * 求连续子数组的最大和
 */
public class getMaxSumArray31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(curSum <= 0){
                curSum = array[i];
            }else{
                curSum += array[i];
            }
            
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int [] arr = {-2,-8,-1,-5,-9};
        //
        System.out.println(
                new getMaxSumArray31().FindGreatestSumOfSubArray(arr));
    }
}
