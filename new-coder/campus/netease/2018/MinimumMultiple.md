# MinimumMultiple最小众倍数
[最小众倍数](https://www.nowcoder.com/practice/3e9d7d22b7dd4daab695b795d243315b?tpId=90&tqId=30844&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 题目描述
给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。 给定5个不同的正整数, 请计算输出它们的最小众倍数。
## 示例代码
``` java
package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-15
 */
public class MinimumMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        int res = 0;
        while (count < 3) {
            res++;
            count = 0;
            for (int x : arr) {
                if (res % x == 0) {
                    count++;
                }
            }
        }
        System.out.println(res);
    }
}

```
