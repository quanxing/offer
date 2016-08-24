package offer;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Given an array nums containing n + 1 integers 
 * where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * 
 * Assume that there is only one duplicate number, find the duplicate one.
 */

//这一题同数组中重复数字 51
public class FindDupInArray51_1 {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                duplicate = nums[i];
                break;
            }
        }
        return duplicate;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,2};
        System.out.println(new FindDupInArray51_1().findDuplicate(arr));
       /* String a = "[aaa]vvvv[cc]";
        Pattern pp = Pattern.compile("\\[.*?\\]");
        Matcher m = pp.matcher(a);
        while(m.find()){
           System.out.println(m.group());
           System.out.println(m.start() +  ":" + m.end() + " ");
        }
        System.out.print("\n=====\n");
        //�滻ÿ���ʵ�����������
        System.out.println(a.replaceAll("\\[.*?\\]", ""));*/
    }
}
