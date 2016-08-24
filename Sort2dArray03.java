package offer;
/*
 * 在一个数组中查找一个元素是否存在
 */
public class Sort2dArray03 {
    public boolean find(int [][] array, int target){
        // row ����col����
        int row = array.length;
        int col = array[0].length;
        
        boolean found = false;
        //从第一行的最后一行数据查找
        int i = 0; 
        int j = col - 1;
        
        while( i <= row -1 && j >=0 ){
            //如果大于，则在下一行查找 i++
            if(target > array[i][j]){
                i++;
            //小于 则在当前行的前一列查找 j--
            }else if(target < array[i][j]){
                j--;
            }else{
                found = true;
                break;
            }
        }
        return found;
    }
    public static void main(String[] args) {
        int [][] a = {{1,2,8,9},
                     {2,4,9,12},
                     {4,7,10,13},
                     {6,8,11,15}};
        System.out.println(new Sort2dArray03().find(a, 7));
    }
}
