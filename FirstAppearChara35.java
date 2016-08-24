package offer;
/*
 * 第一次只出现一次的字符 的位置;
 */

public class FirstAppearChara35 {
    
    public static String chinaToUnicode(String str){  
        String result="";  
        for (int i = 0; i < str.length(); i++){  
            int chr1 = (char) str.charAt(i);  
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
                result+="\\u" + Integer.toHexString(chr1);  
            }else{  
                result+=str.charAt(i);  
            }  
        }  
        return result;  
    }  
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0) return -1;
        
        int [] hashTable = new int[256];
        for (int i = 0; i < str.length(); i++) {
            hashTable[(int)str.charAt(i)] += 1;
        }
        /*
         * 可能有多个出现次数 是 1
         */
        for (int i = 0; i < str.length(); i++) {
            if(hashTable[(int)str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(new FirstAppearChara35().FirstNotRepeatingChar(str));
        
        String[] chara = {"我","是"};
        String unicode = "";
        for (int i = 0; i < chara.length; i++) {
            unicode += chinaToUnicode(chara[i]);
        }
        System.out.println( unicode );
        
    }
}
