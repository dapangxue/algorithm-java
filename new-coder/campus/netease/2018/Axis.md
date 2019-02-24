# Axis
[数轴](https://www.nowcoder.com/practice/ff0e55dcb75b45b09164c56f87cdf737?tpId=90&tqId=30848&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 示例代码
``` java
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/23 0023
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        // 数组排序
        Arrays.sort(x);
        // 1. 先将数组全部向左移动s距离，这样将来只有两种情况，要么保持不动，要么向右移动2s
        for (int i = 0; i < n; i++) {
            x[i] = x[i] - s;
        }

        // 首先确定左边界,此左边界表示不可再右移的左边界
        int left = x[0] + 2 * s > x[n-1] ? x[n-1] : x[0] + 2 * s;

        // 确定初始的右边界
        int right = x[n-1];
        int distance = x[n-1] - x[0];
        for (int i = 0; i < n; i++) {
            // 当有点移动到右边边界的右侧且小于当前的左边界（如果在左右边界的内部，则保持不动）
            if (x[i] + 2 * s > right && x[i] < left) {
                int newDistance = right - x[i];
                if (newDistance < distance) {
                    distance = newDistance;
                }
                right = x[i] + 2 * s;
            }
        }
        if (right - left < distance) {
            distance = right - left;
        }
        System.out.println(distance);
    }
}
```
