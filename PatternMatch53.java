package offer;

/**
 * 题目：请实现一个函数用来匹配包含‘.’和‘*’的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而‘*’表示它前面的字符可以出现任意次（含0次）。
 * 本题中，匹配是指字符串的所有字符匹配整个模式。
 *
 * @param input
 * @param pattern
 * @return
 */
public class PatternMatch53 {
    public boolean match(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str, 0 , pattern , 0);
    }
    
    private boolean matchCore(char[] str, int i, char[] pattern, int j) {
        // TODO Auto-generated method stub
        return false;
    }

    public static void main(String[] args) {
        
    }
}
