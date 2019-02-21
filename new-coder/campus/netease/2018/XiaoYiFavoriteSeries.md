# XiaoYiFavoriteSeries小易喜欢的数列
`动态规划`
[小易喜欢的数列](https://www.nowcoder.com/practice/49375dd6a42d4230b0dc4ea5a2597a9b?tpId=90&tqId=30787&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 示例代码
```java
package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * 本题是网易2018校招题目，题目来源：https://www.nowcoder.com/practice/49375dd6a42d4230b0dc4ea5a2597a9b?tpId=90&tqId=30787&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author WuXue
 * @date 2019/2/20 0020
 */
public class XiaoYiFavoriteSeries {

    private static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 数列的长度
        int n = scanner.nextInt();
        // 数字的范围 1~k之间
        int k = scanner.nextInt();

        int[][] c = new int[n+1][k+1];

        c[0][1] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum = (sum + c[i-1][j]) % mod;
            }
            for (int j = 1; j <= k; j++) {
                int invalid = 0;
                int p = 2;
                while (p * j <= k) {
                    invalid = (invalid + c[i-1][p * j]) % mod;
                    p++;
                }
                c[i][j] = (sum - invalid + mod) % mod;
            }
        }
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = (result + c[n][i]) % mod;
        }
        System.out.println(result);
        scanner.close();
    }
}

```
