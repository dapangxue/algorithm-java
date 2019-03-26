# 多重背包问题
## 问题描述
有N种物品和一个容量为V的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci，价值是Wi。求解将哪些物品装入背包可使这些物品的耗费的空间总和不超
## 示例代码
``` JAVA
package basic.bag;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/26 0026
 */
public class MultiBagProblem {

    /**
     * 进行一趟01背包处理
     * @param dp 动态数组
     * @param consume 当前物品的花费
     * @param value 当前物品的价值
     * @param v 背包的容量
     */
    public void oneZeroBagProblem(int[] dp, int consume, int value, int v) {
        for (int j = v; j >= consume; j--) {
            dp[j] = Math.max(dp[j], dp[j - consume] + value);
        }
    }

    /**
     * 进行一趟完全背包排序
     * @param dp 动态数组
     * @param consume 当前物品的花费
     * @param value 当前物品的价值
     * @param v 背包的容量
     */
    public void completeBagProblem(int[] dp, int consume, int value, int v) {
        for (int j = consume; j <= v; j++) {
            dp[j] = Math.max(dp[j], dp[j - consume] + value);
        }
    }

    /**
     * 多重背包问题，处理一件多重背包中物品的过程
     * @param dp 当前的动态规划数组
     * @param consume 物品装进背包的花费
     * @param value 物品装进背包的价值
     * @param m 当前物品的数量
     * @param v 背包的容量
     */
    public void multiBagProblem(int[] dp, int consume, int value, int m, int v) {
        // 判断花费和数量相乘是否超过总容量，超过的话，看做数量无限大处理，转化成完全背包问题
        if (consume * m > v) {
            completeBagProblem(dp, consume, value, v);
            return;
        }
        int k = 1;
        // 如果花费和数量相乘小于总容量，转化为01背包问题
        // 此处经过优化，如果不优化，则转化为01问题后，需要一个一个物品的判断
        // 现在转为1,2,4。。。2的k次方和剩余的m - 2的k次方 + 1
        while (k < m) {
            oneZeroBagProblem(dp, k * consume, k * value, v);
            m -= k;
            k = 2 * k;
        }
        oneZeroBagProblem(dp, consume * m, value * m, v);
    }

    public static void main(String[] args) {
        MultiBagProblem multiBagProblem = new MultiBagProblem();
        int v = 4;
        int[] dp = new int[v + 1];
        int[] consume = new int[]{1, 2, 3, 4};
        int[] value = new int[]{2, 5, 6, 8};
        int[] nums = new int[]{1, 5, 9, 7};
        for (int i = 0; i < consume.length; i++) {
            multiBagProblem.multiBagProblem(dp, consume[i], value[i], nums[i], v);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[v]);
    }
}

```
