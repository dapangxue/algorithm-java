# 牛牛找工作
本题是网易2018校招实习生招聘题目https://www.nowcoder.com/question/next?pid=10780940&qid=168787&tid=21370714
## 示例代码
```java
package netease;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/25 0025
 */
public class FindWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 工作的数量
        int n = scanner.nextInt();
        // 小伙伴的数量
        int m = scanner.nextInt();

        // 存储工作的难度和报酬
        Map<Integer, Integer> map = new HashMap<>();
        // 用于存储工作的难度Di和小伙伴的能力值
        int[] a = new int[n+m];
        // 用于存储小伙伴的能力值
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int p = scanner.nextInt();
            a[i] = d;
            if (!map.containsKey(d) || map.containsKey(d) && map.get(d) < p) {
                map.put(d, p);
            }
        }

        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            a[i+n] = temp;
            b[i] = temp;
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            }
        }
        System.out.println(map);
        Arrays.sort(a);

        // 动态规划，当前a[i]下最大的报酬
        int max = 0;
        for (int i = 0; i < n+m; i++) {
            max = Math.max(max, map.get(a[i]));
            map.put(a[i], max);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(b[i]));
        }
    }
}

```
