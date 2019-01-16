# 彩色的砖块
题目：https://www.nowcoder.com/practice/8c29f4d1bea84d6ba2847e079b7420f7?tpId=90&tqId=30780&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
## 示例代码
``` java
import java.util.HashMap;
import java.util.Scanner;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-1-16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取彩色砖块
        String brick = scanner.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, length = brick.length(); i < length; i++) {
            char c = brick.charAt(i);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                int count = hashMap.get(c);
                hashMap.replace(c, ++count);
            }
        }

        if (hashMap.size() >= 3) {
            System.out.println(0);
        } else {
            System.out.println(hashMap.size());
        }
    }

}
```
