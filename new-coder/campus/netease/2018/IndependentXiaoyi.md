# 独立的小易
## 题目描述
小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
## 示例代码
``` java
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-2-12
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[4];

        for (int i = 0; i < 4; i++) {
            a[i] = scanner.nextInt();
        }

        int day = 0;

        // 当小易有水果的时候
        if (a[1] != 0 && a[1] * a[0] < a[2]) {
            day = a[1];
        } else {
            System.out.println(a[2]/a[0]);
            return;
        }

        // 计算剩余的钱,此时水果已经吃完，小易需要同时付房租和水果钱
        a[2] -= a[0] * a[1];
        // 小易一天的支出
        int pay = a[0] + a[3];
        System.out.println(day + (a[2] / pay));
    }
}
```
