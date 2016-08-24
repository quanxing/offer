package offer;

import java.sql.Array;
import java.util.Arrays;

/*
 * ��һ�����飬�ж��ǲ��Ƕ����������ĺ����������
 */
public class LastOrderTree24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        //��ڵ�
        int root = sequence[sequence.length - 1];
        //�ҵ����ڸ�ڵ��λ��i
        int i = 0;
        for (i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] > root) {
                break;
            }
        }
        //����ҵ��˴��ڸ�ڵ��i������Ӧ [i---len-2] �� > root,
        //���� ��Ȼ���Ǻ����������
        for (int j = i; j < sequence.length; j++) {
            if(sequence[j] < root){
                return false;
            }
        }
        
        //��ͬ���ж����������ǲ��Ƿ���������
        boolean left = true, right = true;
        //��������
        if(i > 0){
            int [] leftarr = new int[i];
            for (int j = 0; j < i; j++) {
                leftarr[j] = sequence[j];
            }
            left = VerifySquenceOfBST(leftarr);
        }
        //��������
        if(i < sequence.length - 1){
            int [] rightarr = new int[sequence.length - 1 - i];
            for (int j = 0; j < rightarr.length; j++) {
                rightarr[j] = sequence[j];
            }
            right = VerifySquenceOfBST(rightarr);
        }
        return left&&right;
    }
    public static void main(String[] args) {
        int [] a = {5, 7, 6, 9,11, 10 ,8};
        boolean b = new LastOrderTree24().VerifySquenceOfBST(a);
        System.out.println(b);
    }
}
