# 数对
本题是网易2018招聘Java实习生题目https://www.nowcoder.com/question/next?pid=10780940&qid=168811&tid=21402910
## 题目说明
牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。

但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
牛牛希望你能帮他计算一共有多少个可能的数对。


输入描述:
输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。

输出描述:
对于每个测试用例, 输出一个正整数表示可能的数对数量。

输入例子1:
5 2

输出例子1:
7

例子说明1:
满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
## 示例代码
``` java
package netease;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/26 0026
 */
public class NumberPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // x,y均不大于n
        int n = scanner.nextInt();
        // x%y <= k
        int k = scanner.nextInt();

        long count = 0;
        if (k == 0) {
            System.out.println((long)n * n);
            return;
        }
        for (int i = 1; i <= n; i++) {
            count += i - 1 >= k ? (i - k) * (n / i) : 0;
            // 剩下不满足一轮循环的
            int remain = n - (n / i) * i;
            count += remain >= k ? remain - k + 1 : 0;
        }
        System.out.println(count);
    }
}

```
