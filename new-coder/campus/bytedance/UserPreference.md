# 用户喜好
## 题目说明
https://www.nowcoder.com/questionTerminal/66b68750cf63406ca1db25d4ad6febbf
## 示例代码
``` java
package bytedance;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * 本题是字节跳动2018校招在线编程题：https://www.nowcoder.com/questionTerminal/d25162386a3140cbbe6dc071e1eb6ed6
 * @author WuXue
 * @date 2019/3/11 0011
 */
public class UserPreference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 用户的个数
        int n = scanner.nextInt();
        /*
        思路：1.将不同喜好度对应的下标存储于Map中，key:喜好值 value:list，存储下标
             2.查询map中是否有对应的喜好值，如果没有，返回0，如果有则在对应list中找到符合范围的下标的个数
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 用户的喜好值
            int preferValue = scanner.nextInt();
            if (map.containsKey(preferValue)) {
                List<Integer> list = map.get(preferValue);
                list.add(i);
                map.replace(preferValue, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(preferValue, list);
            }
        }

        int queryNumber = scanner.nextInt();
        for (int i = 0; i < queryNumber; i++) {
            int low = scanner.nextInt() - 1;
            int high = scanner.nextInt() - 1;
            int key = scanner.nextInt();

            if (!map.containsKey(key)) {
                System.out.println(0);
            } else {
                getNum(low, high, map.get(key));
            }
        }
        scanner.close();
    }

    private static void getNum(int low, int high, List<Integer> list) {
        int i = 0;
        int j = list.size()-1;
        if (list.get(j) < low || list.get(i) > high) {
            System.out.println(0);
            return;
        }
        int count = 0;
        while (list.get(i) < low || list.get(j) > high) {
            if (list.get(i) < low) {
                i++;
            }
            if (list.get(j) > high) {
                j--;
            }
        }
        System.out.println(j - i + 1);
    }
}

```
