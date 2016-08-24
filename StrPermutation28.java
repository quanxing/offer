package offer;
import java.sql.Array;
import java.util.*;

/*
 * 字符串全排列
 */
public class StrPermutation28 {
    public ArrayList<String> Permutation(String str) {
      
        ArrayList<String> list = new ArrayList<String>();
        if(str.length() == 0){
            return list;
        }
        else{
            PermutationChar(str.toCharArray(), 0 , list);
//            list.addAll(llist);
        }
        return list;
    }
    
    public void  PermutationChar(char[] str, int st,
            List<String> list)  
    {  
        if (st == str.length - 1)  
        {  
            if(!list.contains(String.valueOf(str))){
                list.add(String.valueOf(str));
            }
        }  
        else  
        {  
            for (int i = st; i < str.length; i ++)  
            {  
                swap(str, st, i);  
                PermutationChar(str, st + 1, list);  
                swap(str, st, i);  
            }  
        }  
    }  
    
    public static void swap(char[] str, int i, int j)  
    {  
        char temp; 
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    }  
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abc";
        System.out.println(new StrPermutation28().Permutation(str));
    }

}
