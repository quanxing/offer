package offer;
/*
 * 数字在有序数组中出现的次数
 */
public class getNumOfArr38 {
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array != null && array.length > 0){
            int first = getFirstK(array, k, 0, array.length - 1);
            int end = getLastK(array, k, 0, array.length - 1);
            
            if(first > -1 && end > -1){
                number = end - first + 1;
            }
        }
        return number;
    }
    public int getFirstK(int [] array, int k, int s, int e){
        if(s > e) return -1;
        int index = (s + e) / 2;
        int midData = array[index];
        if(midData == k){
            //如果是第一个k
            if(index > 0 && array[index - 1] != k || index == 0){
                return index;
            }else{
                e = index - 1;
            }
        }else if(midData > k){
            e = index - 1;
        }else{
            s = index + 1;
        }
        
        return getFirstK(array, k, s, e);
    }
    
    public int getLastK(int [] array, int k, int s, int e){
        if(s > e) return -1;
        int index = (s + e) / 2;
        int midData = array[index];
        if(midData == k){
            if(index < array.length - 1 && array[index + 1] != k 
                    || index == array.length - 1){
                return index;
            }else{
                s = index + 1;
            }
        }else if(midData < k){
            s = index + 1;
        }else{
            e = index - 1;
        }
        
        return getLastK(array, k, s, e);
    }
    public static void main(String[] args) {
        int [] a = null;
        System.out.println(new getNumOfArr38().GetNumberOfK(a, 1));
    }
}
