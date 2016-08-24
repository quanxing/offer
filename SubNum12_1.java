package offer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 大数相减实现
 * 大数相加
 * 大数相减  包含了带符号的大数相加减
 * 字符串实现
 * @author fqx
 *
 */
public class SubNum12_1 {
    public static String add(char[] a, char [] b) {
        
        StringBuilder sb = new StringBuilder();
        int len = a.length >= b.length ? b.length:a.length;
        int flag = 0;
        int i = 0;
        int j = 0;
        int addTmp = 0;
        for (i = 0; i < len; i++) {
            int former = a[i] - '0';
            int latter = b[i] - '0';
            
            addTmp = former + latter + flag;
            if(addTmp >= 10){
                flag = 1;
                sb.append(addTmp - 10);
            }else{
                flag = 0;
                sb.append(addTmp);
            }
        }
        if (len==a.length){
            for (j = i; j < b.length; j++) {
                addTmp = flag + b[j] - '0';
                flag = addTmp >= 10? 1:0;
                if(flag == 1){
                    sb.append(addTmp - 10);
                }else{
                    sb.append(addTmp);
                }
            }
        }else{
            for (j = i; j < a.length; j++) {
                addTmp = flag + a[j] - '0';
                flag = addTmp >= 10? 1:0;
                if(flag == 1){
                    sb.append(addTmp - 10);
                }else{
                    sb.append(addTmp);
                }
            }
        }
        if(flag == 1){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }

    public static String sub(char[] a, char[] b) {
        StringBuilder ReturnResult = new StringBuilder();
        // ����ĳ���
        // a>=b;
        int len = b.length;
        int i = 0;
        int j = 0;
        int flag = 0;
        for (i = 0; i < len; i++) {
            int formoer = a[i] - '0' - flag;
            int latter = b[i] - '0';
            
            if (formoer >= latter) {
                //�������λ �Ƿ��� ��λ
                ReturnResult.append(formoer - latter);
                flag = 0;
            }else {
                if (i + 1 < a.length) {
                    flag = 1;
                    ReturnResult.append(flag * 10 + formoer - latter );
                   /* // ��λ
                    if((a[i + 1] - '1') < 0){
//                        a[i + 1] = '0';
                    }else{
                        a[i + 1] = (char) (a[i + 1] - '1' + 48); 
                    }*/
                }
            }
        }
        
        if (j < a.length){
            for (j = i; j < a.length; j++) {
                //����е�λ�� ��λ
                if(flag == 1){
                    if((a[j] - '0' - flag) < 0){
                        ReturnResult.append(a[j] - '0' - flag + flag*10);
                        flag = 1;
                    }else{
                        ReturnResult.append(a[j] - '0' - flag);
                        flag = 0;
                    }
                    //���û�н�λ ����ô ֱ�� ƴ�Ӹ�λ�����
                }else{
                    ReturnResult.append(a[j]);
                }
            }
        }
        //String finalResult = ReturnResult.reverse().toString();
        for (int j2 = ReturnResult.length() - 1; j2 > 0; j2--) {
            if(ReturnResult.charAt(j2) != '0'){
                break;
            }else{
                ReturnResult.deleteCharAt(j2);
            }
        }
        
        return ReturnResult.reverse().toString();
    }

    public static boolean compare(String a, String b) {
        // a.len == b.len
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 - c2 > 0) {
                return true;
            }else if (c1 - c2 < 0){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }

    public static char[] reverse(String s){
        char [] ch = s.toCharArray();
        /*for (int i = 0; i <= ( ch.length -1 ) / 2; i++) {
            char tmp = ch[i];
            ch[i] = ch[ch.length - 1];
            ch[ch.length - 1 - i] = tmp;
        }*/
        int low = 0 ;
        int high = ch.length - 1;
        while(low < high){
            char tmp = ch[low];
            ch[low] = ch[high];
            ch[high] = tmp;
            low++;
            high--;
        }
        return ch;
    }
    
    public static String subByAbsolute(String a, String b){
        String result = "";
        if (a.length() > b.length()) {
            // a > b
            result = sub(reverse(a), reverse(b));
        } else if (a.length() < b.length()) {
            // b > a
            result = "-";
            result += sub(reverse(b), reverse(a));
        } else {
            // �������    and a>=b
            if(compare(a, b)){
                result = sub(reverse(a), reverse(b));
            }else{
                result = "-";
                result += sub(reverse(b), reverse(a));
            }
        }
        return result;
    }
    /**
     *  a-b
     * a >= 0 b >= 0       a - b
     * a <= 0 b <= 0     -(|a| -|b|)
     * a >0 b < 0         (|a| + |b|)
     * a <0 b >0          -(|a| + |b|)
     * @param a
     * @param b
     * @return
     */
    public static String Subtraction(String a, String b) {
        String result = "";
        String symbol = null;
        
        if (a.charAt(0) != '-' && b.charAt(0) != '-') {
            result = subByAbsolute(a, b);
            // ͬ��
            /*if (a.length() > b.length()) {
                // a > b
                result = sub(reverse(a), reverse(b));
            } else if (a.length() < b.length()) {
                // b > a
                result = "-";
                result += sub(reverse(b), reverse(a));
            } else {
                // �������    and a>=b
                if(compare(a, b)){
                    result = sub(reverse(a), reverse(b));
                }else{
                    result = "-";
                    result += sub(reverse(b), reverse(a));
                }
            }*/
        }else if(a.charAt(0) == '-' && b.charAt(0) == '-'){
            symbol = "-";
            a = a.substring(1, a.length());
            b = b.substring(1, b.length());
            result = subByAbsolute(a, b);
        }else if(a.charAt(0) != '-' && b.charAt(0) == '-'){
            b = b.substring(1, b.length());
            result = add(a.toCharArray(), b.toCharArray());
            
        }else{
            symbol = "-";
            a = a.substring(1, a.length());
            result = add(a.toCharArray(), b.toCharArray());
        }
        if (symbol == "-"){
            if(result.charAt(0) != '-'){
                result = symbol + result;
            }else{
                result = result.substring(1, result.length());
            }
        }
        return result;
    }
    
    public static void readTxt(String path){
        String encoding = "GBK";
        File file = new File(path);
        if(file.isFile() && file.exists()){
            try {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding
                        );
                BufferedReader bf = new BufferedReader(read);
                String line = "";
                try {
                    while((line = bf.readLine()) != null){
                        String a = line.split(" ")[0];
                        String b = line.split(" ")[1];
                        System.out.println(Subtraction(a, b));
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            System.out.println("file not exist!");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * Scanner s = new Scanner(System.in); String A = s.nextLine(); String B
         * = s.nextLine();
         */
       /* StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        System.out.println(compare("101", "119"));
        System.out.println('4' - '1');*/
//      System.out.println('0' - '1');
//        String a = Subtraction("157679", "24690");
        String a = Subtraction("-9999999", "9999999");
        System.out.println(a);
        
       /* File d = new File("src\\oj\\data.txt");
        System.out.println(d.getAbsolutePath());
        readTxt(d.getAbsolutePath());*/
        
    }

}
