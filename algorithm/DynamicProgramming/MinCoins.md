# 换钱的最少货币数问题
## 示例代码
``` java
package zuo.mincoins;

/**
 * Created with IntelliJ IDEA.
 * 本题是左神算法中的“换钱的最少货币数”问题
 * @author WuXue
 * @date 2019/3/5 0005
 */
public class MinCoins {
    /**
     * 获取构成fix的最小钱币张数
     * @param coins 钱币的种类
     * @param fix 需要凑出的金额
     * @return 如果返回-1，则证明通过coins里的钱币无法凑出fix
     */
    public int minCoins1(int[] coins, int fix) {
        int length = coins.length;
        if (length <= 0) {
            return -1;
        }

        // 动态规划,dp[i][j]表示可以使用任意钱币conis[0...i]的情况下，构成j的最小纸张数
        int[][] dp = new int[length][fix + 1];
        int max = Integer.MAX_VALUE;

        for (int j = 1; j <= fix; j++) {
            dp[0][j] = max;
            if (j - coins[0] >= 0 && dp[0][j - coins[0]] != max) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        // 定义一个中间变量
        int left = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= fix; j++) {
                left = max;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != max) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i-1][j]);
            }
        }
        return dp[length - 1][fix] != max ? dp[length - 1][fix] : -1;
    }

    // 空间压缩
    public int minCoins2(int[] coins, int fix) {
        if (coins == null || coins.length == 0 || fix <= 0) {
            return -1;
        }
        int length = coins.length;

        int max = Integer.MAX_VALUE;
        int[] dp = new int[fix + 1];

        for (int i = 1; i <= fix; i++) {
            dp[i] = max;
            if (i - coins[0] >= 0 && dp[i - coins[0]] != max) {
                dp[i] = dp[i-coins[0]] + 1;
            }
        }

        int temp = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= fix; j++) {
                temp = max;
                if (j - coins[i] >= 0 && dp[j - coins[i]] != max) {
                    temp = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(temp, dp[j]);
            }
        }
        return dp[fix] != max ? dp[fix] : -1;
    }

    public static void main(String[] args) {
        MinCoins minCoins = new MinCoins();
        int[] coins = {1, 2, 5};
        System.out.println(minCoins.minCoins1(coins, 10));
        System.out.println(minCoins.minCoins2(coins, 10));
    }
}

```
