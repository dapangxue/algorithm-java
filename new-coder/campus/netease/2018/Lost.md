# 迷路的牛牛
## 题目
牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
## 输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
## 示例代码
``` java
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/27 0027
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 转向的次数
        int n = scanner.nextInt();
        String load = scanner.next();

        int degree = 0;
        for (int i = 0; i < n; i++) {
            switch (load.charAt(i)) {
                case 'L' : degree = degree - 90; break;
                case 'R' : degree = degree + 90; break;
            }
        }
        degree = degree % 360;
        if (degree == 0) {
            System.out.println("N");
        } else if (degree == 90 || degree == -270) {
            System.out.println("E");
        } else if (degree == 180 || degree == -180) {
            System.out.println("S");
        } else {
            System.out.println("W");
        }
    }
}

```
