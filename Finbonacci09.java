package offer;
/*
 * fibonacci����
 * 0 1 1 2 
 */
public class Finbonacci09 {
    /*
     * 跳台阶
     */
    public int JumpFloor(int n){
        int result[] = {0, 1, 2};
        if(n < 3){
            return result[n];
        }
        int first = 1;
        int two = 2;
        int fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = first + two;
            first = two;
            two = fib;
        }
        return fib;
    }
    /*
     * ��̬��̨�� 2^(n-1)
     */
    public int JumpFloorII(int target){
        int result[] = new int[target + 1];
        result[0] = 1;
        result[1] = 1;
        if(target < 2){
            return result[target];
        }
        int fib = 0;
        for (int i = 2; i <= target; i++) {
            
            for (int j = 0; j < i; j++) {
                result[i] += result[j];
            }
        }
        return result[target];
    }
    public int Fibonacci(int n) {
        int result[] = {0, 1};
        if(n < 2){
            return result[n];
        }
        int first = 0;
        int two = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = first + two;
            first = two;
            two = fib;
        }
        return fib;
    }
    public static void main(String[] args) {
        System.out.println(new Finbonacci09().JumpFloor(3));
    }
}
