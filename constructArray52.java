package offer;

import java.util.Arrays;
/*
 * ��ָoffer ����˻�������
 */
public class constructArray52 {
    /* �� result[i] = a[0][1]...a[i-1]a[i+1]..a[n-1]; 
     * define :
     * result[0] = 1;
     * result[1] = a[0];
     * result[2] = a[0]*a[1];
     * result[3] = a[0]*a[1]*a[2];
     * so :
     * result[i] = result[i-1]a[i-1];
     * 
     * then :
     * result[0] *=  a[1]a[2]....a[n-1]
     * result[1] *=  a[2]a[3] ....a[n-1];
     * result[n-2] *= a[n-1];
     * 因为result[n-1][n-1] = 1
     */
    public int[] multiply(int [] a){
        if(a == null || a.length == 0){
            return null;
        }
        int [] result = new int[a.length];
        result[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }
        tmp = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            result[i] *= tmp;
        }
        return result;
    }
    public static void main(String[] args) {
       int[] array1 =  {1,2,3};
       System.out.println(Arrays.toString(
               new constructArray52().multiply(array1)));
    }
}
