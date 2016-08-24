package offer;

import java.util.*;

public class JudgeStackOrder22 {
    /*
     * 
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length <= 0 || popA.length <= 0) {
            return false;
        }
        int j = 0;
        int i = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (; i < popA.length; i++) {
            while (s.isEmpty() || s.peek() != popA[i]) {
                if (j < pushA.length) {
                    s.add(pushA[j]);
                    j++;
                } else {
                    // j ����pushA�ĳ���
                    break;
                }
            }
            // �ڶ��֣���ջ����û���ҵ�һ������ջԪ����ȵ�Ԫ�أ�
            // ��������ջ��Ԫ���Ѿ�ȫ����ջ��
            // break ������
            if (s.peek() != popA[i]) {
                break;
            }
            // ��һ�֣���ջ�����ҵ���һ������ջԪ����ȵ�Ԫ��
            s.pop();
        }
        if (s.isEmpty()) {
            return true;
        } else
            return false;
    }

    /*
     * pushA 入栈序列，popA 出栈序列
     */
    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA.length <= 0 || popA.length <= 0) {
            return false;
        }

        Stack<Integer> s = new Stack<Integer>();
        int i = 0, j = 0;
        for (i = 0, j = 0; i < pushA.length; i++) {
            // 一直要将入队元素 全部入队
            s.push(pushA[i]);
            // 直到碰到相等那么j++,且弹出
            // while用于将所有已经能匹配的全部出栈
            // 如果j == popA.length 其实也是对的，说明，入栈没有完全出栈
            // 如输入：1 2 3 4 5 6出栈：1 2 3 4 5：对的 true
            // 但是 入 1 2 3 4 出 1 2 3 4 5 false
            /*
             * 改进版本
             */
            while (j < popA.length && !s.isEmpty() && s.peek() == popA[j]) {
                s.pop();
                j++;
            }
        }
        // return s.isEmpty();
        /*
         */
        if (j == popA.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] push = { 1, 2, 3, 4, 5, 6 , 7 };
        int[] pop1 = { 1,2,3,4,5};
        /*
         * int[] pop2 = {3, 5, 4, 2, 1}; int[] pop3 = {4, 3, 5, 1, 2}; int[]
         * pop4 = {3, 5, 4, 1, 2};
         */

        System.out.println("true: " + IsPopOrder2(push, pop1));
        /*
         * System.out.println("true: " + IsPopOrder2(push, pop2));
         * System.out.println("false: " + IsPopOrder2(push, pop3));
         * System.out.println("false: " + IsPopOrder2(push, pop4));
         */
    }
}
