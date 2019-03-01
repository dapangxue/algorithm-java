# NiuniuAlarmClock 牛牛的闹钟
牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
## 输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
数据保证至少有一个闹钟可以让牛牛及时到达教室。
## 示例代码
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/3/1 0001
 */
public class NiuniuAlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 定义几个闹钟
        int n = scanner.nextInt();
        // 将闹钟的时间转化为分钟数，用于存储闹钟的时间
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int seconds = scanner.nextInt() * 60 + scanner.nextInt();
            list.add(seconds);
        }

        // 存储到学校需要的时间
        int t = scanner.nextInt();
        // 上课时间描述
        int classSeconds = scanner.nextInt() * 60 + scanner.nextInt();
        Collections.sort(list);
        int index = 0;
        for (int i = 0, length = list.size(); i < length; i++) {
            if (list.get(i) + t > classSeconds) {
                index = i - 1;
                break;
            }
        }
        int result = list.get(index);
        System.out.print((result / 60) +  " " + (result % 60));
    }
}

```
