# 完全背包问题
## 问题描述
有N种物品和一个容量为V的背包，每种物品都有无限件可用。放入第i种物品的费用是Ci，价值是Wi。求解：将哪些物品装入背包，可使这些物品的耗费的费用总和不超过背包容量，且价值总和最大。
## 问题分析
完全背包问题和01背包问题的区别在于完全背包问题没有对每种物品的容量做出限制，及每种物品取值可以是0，1，2。。。v/Ci
F[i,v]表示前i种物品达到v容量时的最大价值，状态转移方程为：
F[i, v] = Max{F[i - 1, v - kCi] + kWi | 0 <= kCi <= v}
## 示例代码
``` JAVA
package basic.bag;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * 完全背包问题
 * @author WuXue
 * @date 2019/3/26 0026
 */
public class CompleteBagProblem {

    /**
     * 获取最大价值
     * @param consume 物品的最大花费
     * @param value 每个物品的价值
     * @param v 背包的容量
     * @return 最大价值
     */
    public int getMaxValue(int[] consume, int[] value, int v) {
        int kind = consume.length;

        // 定义一个dp数组
        int[] dp = new int[v + 1];

        // 第一个for循环表示物品的种类
        for (int i = 0; i < kind; i++) {
            // 转化为0,1背包问题，及每种物品最大存放v/Ci
            for (int j = consume[i]; j <= v; j++) {
                // 比较是否使用当前物品，前面可能已经使用过，如果不使用，那么dp[j]不变
                dp[j] = Math.max(dp[j], dp[j - consume[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[v];
    }

    public static void main(String[] args) {
        CompleteBagProblem completeBagProblem = new CompleteBagProblem();
        int[] consume = new int[]{2, 4, 6, 8};
        int[] value = new int[]{1, 2, 5, 7};
        int v = 200;
        System.out.println(completeBagProblem.getMaxValue(consume, value, v));
    }

}
```
