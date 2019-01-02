# 合唱团
## 示例代码
``` java
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获得学生的个数
        int n = scanner.nextInt();

        int[] a = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            a[i] = scanner.nextInt();
        }
        // 选取k名学生
        int k = scanner.nextInt();
        // 相差不超过d
        int d = scanner.nextInt();

        long[][] max = new long[k+1][n+1];
        long[][] min = new long[k+1][n+1];
        long res = Integer.MIN_VALUE;
        // max[k][i]表示选中了k个学生并以第i个学生结尾，所产生的最大乘积
        for (int i = 1; i < n+1; i++) {
            max[1][i] = a[i];
            min[1][i] = a[i];
            // 选k个人
            for (int j = 2; j <= k; j++) {
                // 只能从第i-1个开始选
                for (int m = i-1; m > 0 && i - m <= d; m--) {
                    max[j][i] = Math.max(max[j][i], Math.max(max[j-1][m]*a[i], min[j-1][m]*a[i]));
                    min[j][i] = Math.min(min[j][i], Math.min(max[j-1][m]*a[i], min[j-1][m]*a[i]));
                }
            }
            res = Math.max(res, max[k][i]);
        }
        System.out.println(res);
    }
}

```
