package offer;

import java.util.ArrayList;

public class printMatrixWithCircle20 {
    
    public ArrayList<Integer> printMatrix(int [][] matrix){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int cols = matrix[0].length;
        int rows = matrix.length;
        if(matrix.length == 0 || cols < 0 || rows < 0){
        }
        int start = 0;
        //方阵的最里面一层对 start最多是 cols = rows  / 2;
        while(cols / 2 >= start && rows / 2 >= start){
            printMatInCircle(matrix, cols, rows, start, result);
            start++;
        }
        return result;
    }
    
    private void printMatInCircle(int [][] mat, int cols, int rows, int start,
            ArrayList<Integer> result){
        //start,start表示最外层一圈的左上角坐标；
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        /*
         * 每一行左到右  都是从[start--endX](列数)
         */
        for (int i = start; i <= endX; i++) {
            result.add(mat[start][i]);
        }
        //从上到下打印列，开始的行数要 写小于可寻找的行数endY
        /*
         * 上--下：此时的start还可以表示行号了；
         * 如果start == endY说明当前只有一行了，就不存在上下找了。
         * 因为数据从左到右已经over了。
         */
        if(start < endY){
            for (int i = start + 1; i <= endY; i++) {
                result.add(mat[i][endX]);
            }
        }
        /*
         * 右到左；
         * 起码有两行两列所以
         */
        if(start < endX && start < endY){
          //从循环就能看出if条件必须为：start < endX
            for (int i = endX - 1 ; i >= start; i--) {
                result.add(mat[endY][i]);
            }
        }
        /*
         * 以(start,start)为左上角的矩阵要满足三行两列
         * 从下到上打印一列数据：行 start 与 endY 之间至少还有一行，
         * 且 start 要小于 endX（最大的列数）
         */
        if(start < endX && start < endY - 1){
            //此时要打印的要求满足3行一列即可，列号不超出范围
            //因为该列上的最开始，最末尾都已经访问过了
            for (int i = endY - 1; i > start; i--) {
                result.add(mat[i][start]);
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {
                {1}
        };
        ArrayList<Integer> list = new printMatrixWithCircle20().printMatrix(matrix);
        System.out.println(list);
    }
}
