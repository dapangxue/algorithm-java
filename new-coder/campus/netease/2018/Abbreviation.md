# Abbreviation
## 题目描述
在英文中,我们会把一些长的名字或者短语进行缩写。例如"looks good to me"缩写为"lgtm",短语中的每个单词的首字母组成缩写。现在给出一个字符串s,字符串s中包括一个或者多个单词,单词之间以空格分割,请输出这个字符串的缩写。
## 示例代码
``` java
package netease;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * 本题目是网易2018校招题目，网址：https://www.nowcoder.com/practice/45083499b8c5404fb1db44c6ea4f170a?tpId=90&tqId=30845&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author WuXue
 * @date 2019/2/17 0017
 */
public class Abbreviation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取输入
        String s = scanner.nextLine();

        // 将字符串按空格分开
        String[] a = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, length = a.length; i < length; i++) {
            stringBuilder.append(a[i].charAt(0));
        }
        System.out.println(stringBuilder.toString());
    }
}

```
