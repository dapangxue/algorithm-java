# 分苹果
## 示例代码
``` java
import java.util.Scanner;

/**
 * Create by IDEA
 * 本题是网易2017年校招笔试题
 * 题目来源：https://www.nowcoder.com/practice/a174820de48147d489f64103af152709?tpId=85&tqId=29834&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * @author wuxue
 * @date 19-1-9
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 定义奶牛的个数
        int n = scanner.nextInt();

        // 定义一个数组存储每个奶牛对应的苹果个数
        int[] a = new int[n+1];
        // 总的苹果个数
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }

        // 每个奶牛将来平分后的平均苹果个数
        int average = 0;
        if (sum % n == 0) {
            average = sum/n;
        } else {
            System.out.println(-1);
            return;
        }

        // 核心算法
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if ((a[i] - average) % 2 == 0) {
                if (a[i] - average > 0)
                    count += (a[i] - average)/2;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }
}
```
