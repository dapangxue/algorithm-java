# Binary Gap
## 思路
将整数转换成二进制字符串，再依次将二进制字符串中为1的字符的索引存入list集合当中，对相邻的索引做差，最大值即为所求。
## 示例代码
``` java
class Solution {
    public int binaryGap(int N) {
        // 1.将int型整数转换为二进制
        String binaryStr = Integer.toBinaryString(N);

        // 2.将二进制字符串中字符为1的索引存在list中
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                list.add(i);
            }
        }

        int max=0;
        for (int j = 1; j < list.size(); j++) {
            int fix = list.get(j) - list.get(j-1);
            if (fix > max) {
                max = fix;
            }
        }
        return max;
    }
}
```
