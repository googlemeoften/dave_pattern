package cn.edu.datastructure.beibao;

/***
 * 动态规划背包问题
 */
public class BeiBao {

    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};//重量
        int[] v = {6, 3, 5, 4, 6};//价值
        int c = 10;//背包容量
        int[][] dp = knapsack(w, v, c);
        int[] x = buildSolution(dp, w, c);

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

    /**
     * 查找到对应的物品
     * @param m
     * @param w
     * @param c
     * @return
     */
    public static int[] buildSolution(int[][] m, int[] w, int c) {
        int i, j = c, n = w.length;
        int[] x = new int[n];
        for (i = n; i >= 1; i--) {
            if (m[i][j] == m[i - 1][j]) {
                x[i - 1] = 0;
            } else {
                x[i - 1] = 1;
                j -= w[i - 1];
            }
        }

        return x;
    }

    /**
     * 动态规划
     * @param w
     * @param v
     * @param c
     * @return
     */
    public static int[][] knapsack(int[] w, int[] v, int c) {
        int i, j, n = w.length;
        int[][] dp = new int[n + 1][c + 1];
        for (i = 1; i < n + 1; i++)
            dp[i][0] = 0;
        for (j = 0; j < c + 1; j++)
            dp[0][j] = 0;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i - 1] <= j) {
                    int temp = v[i - 1] + dp[i - 1][j - w[i - 1]];
                    if (temp > dp[i - 1][j]) {
                        dp[i][j] = temp;
                    }
                }
            }
        }
        return dp;
    }
}
