# 拼凑钱币
`动态规划`
## 示例代码
``` java
package meituan;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/4 0004
 */
public class Coins {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 存储钱的面值
        int[] money = new int[]{0, 1, 5, 10, 20, 50, 100};
        // 钱的面值
        int n = scanner.nextInt();
        // 动态规划，dp[i][j]表示前i种纸币构成值为j的所有组合总数
        long[][] dp = new long[7][n+1];

        for (int i = 0; i < 7; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < n+1; j++) {
                if (money[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else if (money[i] < j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j - money[i]];
                } else {
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }
        System.out.println(dp[6][n]);
        scanner.close();
    }

}

```
**压缩空间**
``` java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = {1, 5, 10, 20, 50, 100};

        long[] dp = new long[n+1];
        // 对于面值为1的钱币
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= n; j++) {
                // 存在两种情况：1.不使用当前对应的coins[i]；2.使用当前对应的coins[i]
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[n]);
        scanner.close();
    }
}
```
+ https://blog.csdn.net/lizhentao0707/article/details/82414522
