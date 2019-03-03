# MonopolyGame
大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
## 输入描述:
输入包括一个整数n,(1 ≤ n ≤ 6)

## 输出描述:
输出一个整数,表示投骰子的方法

## 输入例子1:
6
## 示例代码
``` java
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/2 0002
 */
public class MonopolyGame {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        helper(n, 0);
        System.out.println(count);
    }

    private static void helper(int n, int sum) {
        if (sum == n) {
            count ++;
            return;
        }
        if (sum <= n) {
            for (int i = 1; i <= 6; i++) {
                sum += i;
                helper(n, sum);
                sum -= i;
            }
        }
    }
}
```
