# WorkingPlan工作计划
## 题目描述
牛牛手中有s份工作需要完成,牛牛准备将工作分给三位员工。考虑到三位员工还有其他工作需要做,牛牛规定他们每人必须要参与的工作数量分别是a,b,c。
牛牛需要制定详细的工作方案,需要满足每份工作至少有一个人做,同一份工作可以由两个或者三个人共同参与。牛牛一下意识到可能的工作方案很多,牛牛需要你帮他计算一下一共有多少种不同的工作方案(对于两种方案,如果某份工作分配的人或者人数不一样就考虑为不一样的工作方案)。

对于输入样例,s = 3, a = 3, b = 1, c = 1
a要参与所有三份工作,b和c各自有三种选择,所以不同的工作方案是3 * 3 * 1= 9
如果s = 3, a = 1, b = 1, c = 1
相当于对三个员工做全排列,所以不同的工作方案是3 * 2 * 1 = 6
## 示例代码
``` java
package netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * 本题是网易2018校招题目https://www.nowcoder.com/practice/50ae2573431c45db918797836a40406e?tpId=90&tqId=30846&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author WuXue
 * @date 2019/2/17 0017
 */
public class WorkingPlan {

    private static final int MAX = 51;
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] work = new int[3];
        // 建立一个二维数组用来存放组合
        int[][] c = new int[MAX][MAX];

        for (int i = 0; i < 3; i++) {
            work[i] = scanner.nextInt();
        }

        // 1.先将三人的工作量从小到大排序
        Arrays.sort(work);

        // 2.利用动态规划来存储组合的结果
        c[0][0] = 1;
        for (int i = 1; i < MAX; i++) {
            c[i][0] = 1;
            for (int j = 1; j < MAX; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }

        long result = 0, temp = 0;
        // 3.给工作量最大的先分配
        int left = s - work[2];
        for (int i = 0; i <= left; i++) {
            if (i <= work[1] && left - i <= work[0]) {
                temp = c[work[2]][work[1]-i] % MOD;
                // i是work[1]必须完成的
                temp = (temp * c[left][i]) % MOD;
                // left - i是work[0]必须完成的
                temp = (temp * c[s-(left-i)][work[0]-(left-i)]) % MOD;
                result = (result + temp) % MOD;
            }
        }

        result = (result * c[s][work[2]]) % MOD;
        System.out.println(result);
    }
}

```
