package offer;

/*
 * 字符串转整数
 */

enum InputStatus {
    Valid, InValid
}

public class StrToInt49 {
    /**
     * 题目：实现一个函数stringToInt,实现把字符串转换成整数这个功能， 不能使用atoi或者其他类似的库函数。
     * @param num
     * @return
     */
    
    static InputStatus status = InputStatus.Valid;
    
    public  int stringToInt(String num) {

        int result = 0;

        /**
         * 异常输入: 空字符串 或者 Null
         */
        if (num == null || num.length() == 0) {
            status = InputStatus.InValid;
            return result;
        }

        /**
         * 判断第一个字符是 什么？
         */
        char first = num.charAt(0);
        //正 = true;
        boolean flag = true;

        /**
         * 判断第一个字符 
         * 首先是无符号；
         * 其次有符号；
         * 最后异常字符；
         */
        if (isDigit(first)) {
            return parseString(num, 0, true);
        } else if (first == '-' || first == '+'){
            if (first == '-') {
                flag = false;
            }
            return parseString(num, 1, flag);
        } else {
            status = InputStatus.InValid;
            return result;
        }
    }

    /**
     * 判断字符是否是数字
     *
     * @param c
     *            字符
     * @return true是，false否
     */
    private  boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 对字符串进行解析
     *
     * @param num
     *            数字串
     * @param index
     *            开始解析的索引
     * @param positive
     *            是正数还是负数
     * @return 返回结果
     */
    private  int parseString(String num, int index, boolean positive) {

        /**
         * 只有一个符号；例如 "+", "-",
         * 先假设是错误输入，然后当正常输入时变成true即可
         */
        status = InputStatus.InValid;
        
        if(index == num.length()){
            //这个属于异常情况，就是字符串=="+" 或者"-"
            return 0;
        }
        /**
         * 因为可能出现溢出，所以用long数据类型就可以
         * 判断出溢出的数字
         * 又因为此处的result都是正数，long数据类型正好满足他们之间的比较
         */
        
        long result = 0;
        while(index < num.length()){
            /**
             * 0x7FFFFFFF int类型的正数==2147483647 
             * 0x80000000 int 类型 == -2147483648
             * 
             * 0x7FFFFFFFL long类型 == 2147483647
             * 0x80000000L long 类型 ==  2147483648
             * 
             * 所以下面的比较都是L long型数据
             */
            if(isDigit(num.charAt(index))){
                result = result * 10 + num.charAt(index) - '0';
                //全部变成无符号的数，而且考虑了溢出情况
                //大于或者小于int能表示的最大最小就溢出，
                //但是只能用long保存那些溢出的数据
                if( (positive && result > 0x7FFFFFFFL) || 
                        (!positive && result > 0x80000000L)){
                    result = 0;
                    break;
                }
                index++;
            }else{
                result = 0;
                break;
            }
        }
        if(index == num.length()){
            status = InputStatus.Valid;
        }
        if(!positive){
            result *= -1;
        }
        return (int)result;
    }

    public static void main(String[] args) {
//         System.out.println(Integer.parseInt(Integer.MIN_VALUE + ""));
         System.out.println(0x8000_0000);
         System.out.println(0x8000_0000l);
         System.out.println(0x7FFFFFFFL);
         System.out.println(0x7FFFFFFF);
         String [] str = {"0", " ", "  ", "+", "-", "+123", "-1233", "123a",
                 "123 ","+2147483647", "-2147483647", "+2147483648",
                 "-2147483648", "+2147483649", "-2147483649"};
      /*  String [] str = {"+2147483647", "-2147483647", "+2147483648",
                "-2147483648", "+2147483649", "-2147483649"};*/
         for (int i = 0; i < str.length; i++) {
            int output =  new StrToInt49().stringToInt(str[i]);
            if(status == InputStatus.InValid){
                System.out.println("输入错误： 输出" + output);
            }
            else{
                System.out.println("正确输入：输出" + output);
            }
        }
    }
}
