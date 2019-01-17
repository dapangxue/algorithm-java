# 等差数列
## 题目描述
如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
## 示例代码
``` java
package newcoder.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by IDEA
 * 题目来源：https://www.nowcoder.com/practice/e11bc3a213d24fc1989b21a7c8b50c3f?tpId=90&tqId=30781&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author wuxue
 * @date 19-1-17
 */
public class EqualDifferenceSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 有多少个数字
        int n = scanner.nextInt();
        // 构建数组
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        // 将数组排序
        Arrays.sort(array);
        int diff = array[1] - array[0];
        for (int j = 1, length = array.length; j < length; j++) {
            if ((array[j] - array[j-1]) != diff) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
```
