package offer;

public class InversPairs36 {
    
    /*
     * 利用归并排序实现 逆序对 个数的统计
     */
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0) return 0;
        return MSort(array, 0, array.length - 1);
    }
    
    /*
     * i have no idea, just define i point to the s, j point to the m + 1, then
     * proceed to compare the array[i] and array[j], tmp store the smaller.
     * MergSort like two link in DataStructure written by yanweimin.
     */
    static int Merge(int[] array, int[] tmp, int s, int m, int e) {
        // when start merger, we use the tmp array store the sorted element
        // version_2 ;k pos store the current small element
        //start swap
        int swap = 0;
        int i = s, j = m + 1, k = s;
        while (i <= m && j <= e) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                //indicate exit inversOrder pairs
                tmp[k++] = array[j++];
            }

        }
        // if right part haved add to the tmp, so left part copy to the tmp
        // directly
        /*
         * change: 统计逆序对
         * i<=m 因为array[i] <= array[j]
         * j - m - 1就是右半部分有几个小于左半部分(m-s+1)；j-m-1中的-1就是为了去掉array[i] == array[j]
         */
        if(i <= m){
            swap = (j - m - 1)*(m - s + 1);
        }
        
        while (i <= m) {
            tmp[k++] = array[i++];
        }
        // as the above
        while (j <= e) {
            tmp[k++] = array[j++];
        }

        // copy the sorted tmp to the original array; my idea by myself
        for (int r = s; r <= e; r++) {
            array[r] = tmp[r];
            // System.out.print(array[r] + "  ");
        }
        return swap;
    }
  
    /*
     * s start of the array e the end of the array
     */
    static int MSort(int[] array, int s, int e) {

        int[] tmp = new int[array.length];
        /*
         * when s < e , we can start merge if s== e ,we need not do anything
         */
        // if (s == e) return ;
        if (s < e) {
            int m = (s + e) / 2;
            int left = MSort(array, s, m);
            int right = MSort(array, m + 1, e);
            return left + right + Merge(array, tmp, s, m, e);
        }
        else{
            return 0;
        }
        // here alse can return array , just modify the return type to int array
        // just like static int [] array
    }
    
    public static void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int [] a = {1,2,1,2,1};//{7,5,6,4};
        System.out.println(new InversPairs36().InversePairs(a));
        show(a);
    }
}
