package offer;
/*
 * ��������˳��ʹ����λ��ż��ǰ��
 */
public class OrderArray14 {
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            int end = 0;
            if(array[i] % 2 ==0) {
                int j = 0;
                for (j = i + 1; j < array.length; j++) {
                    if(array[j] % 2 == 0){
                        //��һ��ż����滹��ż��
                    }else{
                        int swap = array[j];
                        end = j;
                        while(j > i){
                            array[j] = array[j - 1]; 
                            j--;
                        }
                        array[i] = swap;
                        break;
                    }
                }
                if(end == array.length){
                    break;
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        new OrderArray14().reOrderArray(array);
    }
}
