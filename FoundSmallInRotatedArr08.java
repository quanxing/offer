package offer;
/*
 *旋转数组的最小数字
 */
public class FoundSmallInRotatedArr08 {
    public int minInArray(int[] array){
        if(array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        int minNum = Integer.MAX_VALUE;
        //low == high �ǿ���Ӧ��ֻ��һ��Ԫ�ص����
        while(low <= high){
            mid = (low + high)/2;
            //��������ʱ����ô�ȼ�¼������������С��Ԫ�أ�Ȼ��϶�Ҫ��
            //�ұߵ���Сֵ�Ƚϡ����ڵ�ǰ�ҵ���Сֵ��һ��Ҫȥ��һ�������ռ�
            if(array[low] < array[mid]){
                //left sorted
                if(array[low] < minNum){
                    minNum = array[low];
                }
                low = mid + 1;
            }
            //����ͬ��
            else if(array[low] > array[mid]){
                //right sorted
                if(array[mid] <= minNum){
                    minNum = array[mid];
                }
                high = mid - 1;
            }else{
                //array[low] == array[mid]
                //low == mid 1, 0, 1, 1, 1
                // when low == mid ==> high - low == 1 or low == high
                if(low == mid){
                    //只取两者最小的即可
                    minNum = minNum < Math.min(array[low], array[high]) ? minNum:
                        Math.min(array[low], array[high]);
                    break;
                }else{
                    //
                    low = low + 1;
                }
            }
        }
        return minNum;
    }
    public static void main(String[] args) {
        int[] a = {1,0,1,1,1};
//        int[] a = {1,2};
//        int [] a = {3,4,5,1,2};
        System.out.println(new FoundSmallInRotatedArr08().minInArray(a));
    }
}
