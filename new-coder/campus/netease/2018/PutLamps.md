# 安置路灯
## 题目
小Q正在给一条长度为n的道路设计路灯安置方案。

为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。

小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。

小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
## 示例代码
``` java
package netease;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/2/27 0027
 */
public class PutLamps {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        // 记录有多少个测试用例
        int n = scanner.nextInt();
        while (scanner.hasNext()) {
            // 道路的长度
            int length = scanner.nextInt();
            String load = scanner.next();
            int count = 0;
            // 贪心算法
            for (int i = 0; i < length; i++) {
                if (load.charAt(i) == '.') {
                    count++;
                    i += 2;
                }
            }
            System.out.println(count);
        }
    }
}

```
