# DiceGame骰子游戏
`动态规划`
[骰子游戏](https://www.nowcoder.com/practice/0e83797c34e54cca91179fe9ad681bc4?tpId=90&tqId=30849&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 示例代码
``` java
package netease;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/19 0019
 */
public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 有n骰子
        int n = scanner.nextInt();
        // 临界值x
        int x = scanner.nextInt();

        long[][] c = new long[n+1][x+1];
        c[0][0] = 1;

        // 动态规划结果预存
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                for (int m = 1; m <= 6 && m + j < x; m++) {
                    c[i][j+m] += c[i-1][j];
                }
            }
        }

        // 打印二维数组
        /*for (int i=0; i< c.length;i++) {
            System.out.println ( Arrays.toString (c[i]));
        }*/

        // 不符合条件的情况数
        long ans = 0;
        for (int i = 0; i < x; i++) {
            ans += c[n][i];
        }
        // 计算总的情况数
        long y = (long)Math.pow(6, n);

        // 没有符合条件的情况数
        if (y - ans == 0) {
            System.out.println(0);
        } else if (y - ans == y) {
            System.out.println(1);
        } else {
            long[] result = simplify(y-ans, y);
            System.out.println(result[0] + "/" + result[1]);
        }
    }

    /**
     * 将分数约分
     *
     * @param fenzi
     * @param fenmu
     * @return
     */
    private static long[] simplify(long fenzi, long fenmu) {
        long gcd = BigInteger.valueOf(fenzi).gcd(BigInteger.valueOf(fenmu)).longValue();
        return new long[]{fenzi / gcd, fenmu / gcd};
    }
}
```
