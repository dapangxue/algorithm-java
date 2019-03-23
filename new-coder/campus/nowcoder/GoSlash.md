# 走斜线
有天他来到一张方格地图上，整张地图可以看做一个二维坐标轴。牛牛此刻处于原点（0,0），他想要到点（x,y）去。牛牛有强迫症，他规定自己必须恰好k步走到点(x,y)，中途可以经过任何点包括（x,y），但是第k步一定要到达（x,y）。一步有八种走法，直线东（+1,0）南（0,-1）西（-1,0）北（0,+1），斜线东南（+1,-1）东北（+1,+1）西南（-1,-1）西北（-1,+1）。牛牛会在能k步到达目的地的基础下尽量走斜线，你能计算出牛牛到底走了多少条斜线吗？

输入描述：
```
第一行一个整数T，代表数据组数。
每组数据给出三个整数x，y，k。
```
输出描述：
```
对于每组数据，单独一行输出一个整数。
如果牛牛可以在第k步的时候到达(x,y)，输出牛牛走的斜线数量。
如果牛牛不能到达，输出-1。
```
备注：
对于100%的数据，1<=T<=1000，1<=x，y，k<=1000000000000000000。

输入：
```
2
2 3 4
7 7 9
```
输出：
```
3
9
```

## 示例代码
``` java
package nowcoder;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/23 0023
 */
public class GoSlash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 几行数据
        int n = scanner.nextInt();
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();

            // 1.交换x > y的情况。比如(5, 2)结点和(2, 5)结点在这道题目效果是一样的
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }

            // 2.如果k步达不到结点(x, y)的最大值，则说明无法到达这个点
            if (k < Math.max(x, y)) {
                System.out.println(-1);
            } else {
                /*
                3. 在k可以到达(x, y)最大值的情况下，有三种情况
                （1）y - x 是偶数，k - x是偶数，其实当k == y时是可以到达该点的，
                为了满足k步到达，到达目标点后，可以一直来回移动
                （2）y - x 是偶数，k - x是奇数，需要两步的直线
                （3）y - x 是奇数，需要走一步的直线
                 */
                if (((y - x) & 1) == 0) {
                    int c = k - x;
                    if ((c & 1) == 0) {
                        System.out.println(k);
                    } else {
                        System.out.println(k - 2);
                    }
                } else {
                    System.out.println(k - 1);
                }
            }
        }
        scanner.close();
    }
}

```
