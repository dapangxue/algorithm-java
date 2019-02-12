# 交错01串
## 题目描述
如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
## 示例代码
``` java
public class Interlace01string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取输入的01串
        String s = scanner.nextLine();

        int max = 1, oldMax = 1;

        char[] c = s.toCharArray();
        for (int i = 1, length = c.length; i < length; i++) {
            if (c[i] != c[i-1]) {
                max++;
            } else {
                max = Math.max(max, oldMax);
                if (max > oldMax) {
                    oldMax = max;
                }
                max = 1;
            }
        }
        System.out.println(max > oldMax ? max : oldMax);
    }
}
```
``` java
```
