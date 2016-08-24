package offer;
/*
 * 数组中只出现一次的数字
 */
public class oneExitArr40 {
    public void FindNumsAppearOnce(int [] array, int num1[] , int num2[]) {
        if(array == null || array.length < 2){
            return;
        }
        int XOR = 0;
        //相同的会变成0；
        for (int i = 0; i < array.length; i++) {
            XOR ^= array[i];
        }
        
        int index = FindFirstBit(XOR);
        for (int i = 0; i < array.length; i++) {
            if(isBit1(array[i], index) == 1){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    
    int FindFirstBit(int num){
        int index = 0;
        while((num & 1) == 0 && (index < 32)){
            num = num >> 1;
            ++index;
        }
        return index;
    }
    /*
     * 判断index位置上的位 是不是 1
     */
    int isBit1(int num, int index){
        num = num >> index;
        return num & 1;
    }
    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int [] num1 = {0};
        int [] num2= {0};
        new  oneExitArr40().FindNumsAppearOnce(data1, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }
}
