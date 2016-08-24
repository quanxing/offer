package offer;
/*
 * 左旋转字符串
 * abcdef--->defgabc
 * n < 0 但是可等于length - 1
 * 
 */
public class LeftRotate42 {
    public void reverse(char[] chars , int s, int e){
        while(s < e){
            char c = chars[s];
            chars[s++] = chars[e];
            chars[e--] = c;
        }
    }
    
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0 || n < 0 || n > str.length())
            return "";
        char [] strRevse = str.toCharArray();
        //(aTbT)T == ba
        reverse(strRevse, 0 ,n - 1);
        reverse(strRevse,n , strRevse.length - 1);
        reverse(strRevse, 0 , strRevse.length - 1);
        
        return String.valueOf(strRevse);
    }
    
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(new LeftRotate42().LeftRotateString(str, 3));
    }
}
