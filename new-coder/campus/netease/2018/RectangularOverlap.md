# 矩形重叠
## 示例代码
``` java
package netease;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/26 0026
 */
public class RectangularOverlap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 矩阵的个数
        int n = scanner.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x1[i] = scanner.nextInt();
            x.add(x1[i]);
        }
        for (int i = 0; i < n; i++) {
            y1[i] = scanner.nextInt();
            y.add(y1[i]);
        }
        for (int i = 0; i < n; i++) {
            x2[i] = scanner.nextInt();
            x.add(x2[i]);
        }
        for (int i = 0; i < n; i++) {
            y2[i] = scanner.nextInt();
            y.add(y2[i]);
        }

        int res = 1;
        for (Integer a : x) {
            for (Integer b : y) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (x1[i] < a && y1[i] < b && x2[i] >= a && y2[i] >= b) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        System.out.println(res);
    }
}

```
