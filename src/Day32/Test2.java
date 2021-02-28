package Day32;

public class Test2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{1,0,0}};//hang
        int i = 0;
        while (i == 0){
            System.out.println(i++);
        }
        System.out.println(arr.length);//行数
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //时间复杂度 O(M+N)：其中，NN 和 MM 分别为矩阵行数和列数，此算法最多循环 M+N 次。
        //空间复杂度 O(1) : i, j 指针使用常数大小额外空间。
        int i = matrix.length-1;//i控制的是从下往上走
        int j = 0;//j是确定行了，从左往右走
        while (i >= 0 && j < matrix[0].length){//注意j的取值 是matrix[0].length
            if(matrix[i][j] > target) i--;//因为是横着竖着都是递增
            else if(matrix[i][j] < target) j++;//往右边走
            else return true;
        }
        return false;
    }
}
