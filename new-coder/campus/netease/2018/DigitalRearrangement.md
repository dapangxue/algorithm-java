# DigitalRearrangement数位重排
## 示例代码
``` java
package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * 本题是网易2018校招题目《数位重排》
 * 题目来源：https://www.nowcoder.com/practice/f970201e9f7e4040ab25a40918e27d15?tpId=90&tqId=30847&tPage=4&rp=4&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 * @author WuXue
 * @date 2019/2/18 0018
 */
public class DigitalRearrangement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入n个整数
        int n = scanner.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            String s = String.valueOf(num[i]);
            char[] c = s.toCharArray();
            List<Integer> list = new ArrayList<>();
            helper(list, c, 0);
            boolean flag = false;
            for (Integer x : list) {
                if (x % num[i] == 0 && x != num[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    /**
     * 将一个数字全排列
     *
     * @param list
     * @param chs
     * @param start
     */
    private static void  helper(List<Integer> list, char[] chs, int start) {
        if(start==chs.length-1) {
            // Arrays.toString(chs);
            //如果已经到了数组的最后一个元素，前面的元素已经排好，输出。
            String s = new String(chs);
            list.add(Integer.valueOf(s));
        }
        for(int i=start;i<=chs.length-1;i++)
        {
            if(i==start||chs[i]!=chs[start])
            {
                //在排列的时候进行判断如果后面的元素与start相同时就不进行排序。
                //这样就可以避免对重复元素进行排序
                swap(chs, i, start);
                helper(list, chs,start+1);
                swap(chs, i, start);
            }
        }
    }

    public static void swap(char chs[], int i, int j)
    {
        char temp;
        temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
}
```
