package Day2_26;

public class Test1 {
    public static void main(String[] args) {

    }
    public int[] spiralOrder(int[][] matrix) {
        //时间复杂度 O(MN)O(MN) ： M, NM,N 分别为矩阵行数和列数。
        //空间复杂度 O(1)O(1) ： 四个边界 l , r , t , b 使用常数大小的 额外 空间（ res 为必须使用的空间）。
        if(matrix.length == 0) return new int[]{};
        int t = 0,l = 0 ,r = matrix[0].length - 1,b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r+1)*(b+1)];//b的值是矩阵的高，r的值是矩阵的宽度
        while (true){
            for (int i = l; i <= r ; i++) {//第一步：从l起点r终点 左往右走，第一排被输出了，所以向下移动一排 t会+1
                res[x++] = matrix[t][i];//x++ 先res赋值再+1  从左往右i是后面 t不变 所以[t][i]
            }
            if(++t > b)//t会+1
                break;

            for (int i = t; i <= b ; i++) {//第二步：从t上往下b走  最右边的一排被输出  r减去1
                res[x++] = matrix[i][r];
            }
            if(--r < l )
                break;

            for (int i = r; i >= l ; i--) {//第三步：从r右往左l走 最下面被消耗 b-1
                res[x++] = matrix[b][i];
            }
            if(--b < t)
                break;

            for (int i = b; i >= t ; i--) {//第四步：从b下往上t走， 最左边被消耗 l+1
                res[x++] = matrix[i][l];
            }
            if(++l > r)
                break;
        }
        return res;
    }
}
