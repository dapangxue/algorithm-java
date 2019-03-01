# NiuniuBackpackProblem牛牛的背包问题
## 题目描述
牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。

输入描述:
输入包括两行
第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。

输出描述:
输出一个正整数, 表示牛牛一共有多少种零食放法。
## 示例代码
```java
package netease;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/1 0001
 */
public class NiuniuBackpackProblem {
    private static long result = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 零食的数量
        int n = scanner.nextInt();
        // 背包的容量
        long w = scanner.nextInt();

        // 零食的体积
        long[] v = new long[n];

        // 零食的总体积
        long total = 0;
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
            total += v[i];
        }

        if (total <= w) {
            System.out.println((int)Math.pow(2, n));
        } else {
            helper(0, w, 0, v);
            System.out.println(result);
        }
    }

    private static void helper(int low, long w, long sum, long[] v) {
        if (sum > w) {
            return;
        }
        if (sum <= w) {
            result++;
        }
        for (int i = low; i < v.length; i++) {
            helper(i+1, w, sum+v[i], v);
        }
    }
}

```
