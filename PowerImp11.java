package offer;
/*
 * ʵ�� ��ƽ���ĺ���
 */
public class PowerImp11 {
    public double Power(double base, int expoent){
        /*
         * base=0 && ex < 0;
         */
        boolean flag = true;
        if(Math.abs(base - 0) < 10E-10 && expoent < 0){
            //0的负指数；异常
            flag = false;
            return 0;
        }
        //指数处理
        int absexpoent = expoent;
        if(expoent < 0) 
            absexpoent = -1 * expoent;
        
        double result = powerWithEx(base, absexpoent);
        
        if(expoent < 0) result = 1.0 / result;
        return result;
    }
    
    public double powerWithEx(double n , int ex){
        //比较低效的方法
        /*double result = 1.0;
        for (int i = 1; i <= ex; i++) {
            result *= n;
        }
        return result;*/
        
        
        //�高效的方法 递归出口
        if(ex == 0){
            return 1;
        }
        if(ex == 1){
            return n;
        }
        /*
         * a^n = a^(n/2) * a^(n/2) n 为偶数
         * a^n = a^((n - 1)/2) * a^((n - 1)/2) * a n 为奇数
         */
        double result = powerWithEx(n, ex >> 1);
        result *= result;
        
        if((ex&1) == 1){
            result *= n;
        }
        return result;
    }
    public static void main(String[] args) {
        PowerImp11 p = new PowerImp11();
        System.out.println(p.Power(-1, -1));
        System.out.println(p.Power(-1, 0));
        System.out.println(p.Power(0, 0));//1
        System.out.println(p.Power(0, 1));
        System.out.println(p.Power(2, 3));
    }
}
