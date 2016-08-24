package offer;

import java.util.Scanner;
/**
 * sentence reverse O(N);
 * @author fqx
 *1）有的题目明确说明 字符串中是以空格分隔的 那么改程序就可以解决该问题
 *2）如果字符串中有空格，再以空格分开就不合适了。
 *题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。为简单起见，
 *标点符号和普通字母一样处理。
 *
 */
public class ReSentence42 {
    
    /* 有的题目明确说明 字符串中是以空格分隔的 
     * 那么改程序就可以解决该问题
     * z转换后的多个空格以一个代替
     * 
     * split()方法慎用
     */
    public static String RevSen(String str) {
        if(str.length() == 0) return "";
        //下面的意思就是 如果有多个空格照样去掉，以他们为分隔
        String[] word = str.split(" +");
        //如果分隔之后,word长度还是0，那么说明只有空格了.str长度不可能为0。就是说有字符的
        if(word.length == 0) return str;
        
        String result = "";
        for (int i = word.length - 1; i >= 0 ; i--) {
           /* if (word[i].length() == 0) {
                //这里是为了处理输出保持原样设计的。当 String[] word = str.split(" ");
                //那么可能word中也会出现空格元素。但不知道这样有什么意义
                continue;
            }else{
                result += word[i] + " ";
            }*/
            if(i == 0){
                result += word[i];
            }else{
                result += word[i] + " ";
            }
        }
        return result.trim();
        
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String sent = "S lksdfsal  ldskf    lksdjf "; //"i am s studn.";
//        System.out.println("原始长度： " + sent.length());
//        System.out.println(RevSen(sent));
//        System.out.println("转换后长度：" + RevSen(sent).length());
        
        String testStr = "i  AM a student. ";
        System.out.println( "\n源字符串长度" + testStr.length());
        String resutlStr = RevSen(testStr);
        System.out.println("\n转换后字符串长度" + resutlStr);
    }
}
