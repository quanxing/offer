package offer;

/*
 * 数据流中第一个出现的字符
 */
public class OneExitStream55 {
    //Insert one char from stringstream
    private int index = 0;
    private int [] ouccrence = new int [256];
    
    public OneExitStream55() {
        // TODO Auto-generated constructor stub
        for (int i = 0; i < ouccrence.length; i++) {
            ouccrence[i] = -1;
        }
    }
    
    public void Insert(char ch)
    {
        if(ch > 255) {
            throw new IllegalArgumentException(ch + "  ASCII");
        }
        if(ouccrence[ch] == -1){
            ouccrence[ch] = index;
        }else{
            ouccrence[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(ouccrence[i] >=0 && ouccrence[i]<minIndex){
                ch = (char)i;
                minIndex = ouccrence[i];
            }
        }
        if(ch == '\0')
            return '#';
        return ch;
    }
}
