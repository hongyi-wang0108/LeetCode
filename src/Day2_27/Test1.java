package Day2_27;

public class Test1 {
    public static void main(String[] args) {

    }
    public int maxValue(int[][] grid) {
        //时间复杂度 O(MN)O(MN) ： M,N 分别为矩阵行高、列宽；动态规划需遍历整个 gridgrid 矩阵，使用 O(MN)O(MN) 时间。
        //空间复杂度 O(1)O(1) ： 原地修改使用常数大小的额外空间
        int m = grid[0].length;//长
        int n = grid.length;//高 宽度
        for (int i = 0; i < n; i++) {//这题要求只能下或向右
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) continue;//这个就是【0】【0】 不能往下/右
                if(i == 0) {//第一行 只能考虑左
                    grid[i][j] += grid[i][j-1];
                }else if(j == 0) {//第一列 只能考虑上
                    grid[i][j] += grid[i-1][j];
                }else {//俩都行 所以都要考虑 找最大值
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[n-1][m-1];//把最后这个输出
    }
}
