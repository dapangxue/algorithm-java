# 操作序列
[操作序列](https://www.nowcoder.com/practice/b53bda356a494154b6411d80380295f5?tpId=90&tqId=30783&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking)
## 题目描述
小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
1、将a_i放入b序列的末尾
2、逆置b序列
小易需要你计算输出操作n次之后的b序列。
## 示例代码
``` java
package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-12
 */
public class SequenceOfOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入n个数字
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        StringBuilder stringBuilder = new StringBuilder();

        if ((n & 1) == 0) {
            for (int i = n-1; i >= 1; i -= 2) {
                stringBuilder.append(a[i] + " ");
            }
            for (int i = 0; i <= n-2; i += 2) {
                if (i == n-2) {
                    stringBuilder.append(a[i]);
                } else {
                    stringBuilder.append(a[i] + " ");
                }
            }
        } else {
            for (int i = n-1; i >= 0; i -= 2) {
                stringBuilder.append(a[i] + " ");
            }
            for (int i = 1; i <= n-2; i += 2) {
                if (i == n-2) {
                    stringBuilder.append(a[i]);
                } else {
                    stringBuilder.append(a[i] + " ");
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
```
``` java
package newcoder.netease;

import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-12
 */
public class SequenceOfOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入n个数字
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // StringBuilder stringBuilder = new StringBuilder();

        if ((n & 1) == 0) {
            for (int i = n-1; i >= 1; i -= 2) {
                System.out.print(a[i] + " ");
            }
            for (int i = 0; i <= n-2; i += 2) {
                if (i == n-2) {
                    System.out.print(a[i]);
                } else {
                    System.out.print(a[i] + " ");
                }
            }
        } else {
            for (int i = n-1; i >= 0; i -= 2) {
                System.out.print(a[i] + " ");
            }
            for (int i = 1; i <= n-2; i += 2) {
                if (i == n-2) {
                    System.out.print(a[i]);
                } else {
                    System.out.print(a[i] + " ");
                }
            }
        }
        System.out.println();
    }
}
```
``` java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 输入n个数字
    int n = scanner.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = n-1; i >= 0; i -= 2) {
        stringBuilder.append(a[i] + " ");
    }
    for (int i = (n & 1); i <= n-2; i += 2) {
        if (i == n-2) {
            stringBuilder.append(a[i]);
        } else {
            stringBuilder.append(a[i] + " ");
        }
    }

    System.out.println(stringBuilder.toString());
}
```
