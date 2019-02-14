# CrazyQueue
[疯狂队列](https://www.nowcoder.com/practice/d996665fbd5e41f89c8d280f84968ee1?tpId=90&tqId=30786&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 题目说明
小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
## 示例代码
``` java
import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-14
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入学生人数
        int n = scanner.nextInt();

        // 存储学生的身高
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }

        // 1.将数组排序
        Arrays.sort(h);
        int maxValue = h[n-1];
        int minValue = h[0];
        int diff = maxValue - minValue;
        int minIndex = 1;
        int maxIndex = n-2;

        while (minIndex < maxIndex) {
            diff += maxValue - h[minIndex];
            diff += h[maxIndex] - minValue;
            maxValue = h[maxIndex--];
            minValue = h[minIndex++];
        }
        diff += Math.max(maxValue - h[minIndex], h[maxIndex] - minValue);
        System.out.println(diff);
    }

}

```
