package offer;

/*
 * ��ָoffer 4
 */
public class RplaceBlock04 {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0) return "";
        //oldָ����Ǿɵ��ַ�����һ��λ��
        int oldIndex = str.length() - 1;
        int blockLen = 0;
        char[] replace = "%20".toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                blockLen++;
            }
        }
        //因为每个替换位置已经包含了一个空格了，所以每个替换只需blockLen*(replace.length - 1)
        str.setLength(str.length() + blockLen*(replace.length - 1));
        //���ַ�����һ��λ��
        int newLen = str.length() - 1;
        /*
         * 1) ���ֻ��һ�����ַ� �� ��ôoldIndex ��newIndex���滻������Ϊ-1��
         * ����ʵ���Ѿ��滻��ɣ����while is ok
         * 2��1�����Ѿ������˵�һ���ַ���� �ո�����
         * 3�� ���һ���ַ��ǿո�ֱ�Ӹ�ֵ�� newIndex����λ��
         * 4��һ��ı߽�������
         *   1. ����ȫû���ַ��� oldIndex == newIndex;��Ϊ����û����
         *   2. oldIndex >= 0 ����Ϊ ������ޣ�����һ���ǿո�ʱҲҪ�ж�
         *   3. oldIndex < 0 ʱ ˵�� newIndex�Ѿ�����oldIndex�� �滻���
         */
        /*
         *1 oldIndex 必须>=0; 当oldIndex = newLen 说明没有空格
         *2 old遇到空格之后，new--知道被替换完成，old--;
         *3 old与new 总差空格数目
         *4 old == new  到起始位置全部替换完成
         */
        while(oldIndex >= 0 && oldIndex < newLen){
            if(str.charAt(oldIndex) == ' '){
                //old-- 放在这更容易理解；new 的目的就是追上old
//                oldIndex--;
                for (int i = replace.length - 1; i >= 0; i--) {
                    str.setCharAt(newLen--, replace[i]);
                }
                
            }else{
                str.setCharAt(newLen--, str.charAt(oldIndex));
            }
            oldIndex--;
        }
        //oldIndex == newLen退出了 还有相等且等于-1的
        System.out.println(oldIndex + "  " + newLen);
        return str.toString();
    }
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" ab ");
        //֤����StringBuffer�������ó�������
/*        str.setLength(20);
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
        System.out.print("+");*/
//        str = null;
        System.out.println(new RplaceBlock04().replaceSpace(str));
    }
}
