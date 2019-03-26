# 01背包问题
## 问题描述
有N件物品和一个容量为V的背包。放入第i件物品耗费的费用是Ci，得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。
## 问题分析
采用F[i, v]表示取前i种物品满足不大于容量v时的最大价值，01问题每种物品可以放入包中，也可以不放入其中
F[i, v] = max{F[i - 1, v], F[i - 1, v - Ci] + Wi}
## 代码
``` JAVA
public class Soulution {
    /**
     * 01背包问题解法一
     * 此方法时间复杂度为O(M*N) 空间复杂度也为O(M*N)
     * @param consume 背包需要消耗的空间
     * @param value 放入物品后产生的价值
     * @param v 背包的总容量
     * @return 最大的价值
     */
    public int getMaxValue(int[] consume, int[] value, int v) {
        // 1.首先定义一个二维数组，dp[i][j]表示前i件中选择让价值最大且消费小于等于容量j的最大价值
        int[][] dp = new int[consume.length][v+1];

        // 第一个物品放进背包
        for (int j = 1; j < v+1; j++) {
            if (j < consume[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < consume.length; i++) {
            for (int j = 1; j < v+1; j++) {
                if (j - consume[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - consume[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[consume.length - 1][v];
    }

    public int getMaxValue2(int[] consume, int[] value, int v) {
        // dp[j] 表示对应物品行的最大价值，只是在空间上缩小了复杂度
        int[] dp = new int[v + 1];

        for (int j = 1; j < v + 1; j++) {
            if (j >= consume[0]) {
                dp[j] = value[0];
            }
        }

        for (int i = 1; i < kind; i++) {
            for (int j = v; j >= 1; j--) {
                if (j - consume[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - consume[1]] + value[i]);
                }
            }
        }
        return dp[v];
    }
}
```
