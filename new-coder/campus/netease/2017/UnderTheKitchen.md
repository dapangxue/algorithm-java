# 下厨房
## 示例代码
``` java
package newcoder.netease;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Create by IDEA
 * 说明：本题是2019年网易校招题目
 * 题目来源：https://www.nowcoder.com/practice/ca5c9ba9ebac4fd5ae9ba46114b0f476?tpId=85&tqId=29832&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking
 * @author wuxue
 * @date 19-1-7
 */
public class UnderTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while (scanner.hasNext()) {
            String value = scanner.nextLine();
            String[] material = value.split(" ");
            for (String x : material) {
                hashSet.add(x);
            }
        }
        System.out.println(hashSet.size());
    }
}
```
