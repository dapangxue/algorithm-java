# Lexicographical Numbers
字典顺序就是按照字典的排序方法,先看首位字符，如果首位一样就接着看下一位。比如：
```
a
ab
abd
abe
c
cd
```
## 思路
本题先给定一个个位数字，判定小于n后，将这个个位数字乘以10，逐步加一判断是否满足条件。
## 示例代码
``` java
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dummy(i, n, list);
        }
        return list;
    }

    private void dummy(int now, int n, List<Integer> list) {
        if (now > n) {
            return;
        }
        list.add(now);
        for (int i = 0; i < 10; i++) {
            if (now*10 + i <= n) {
                dummy(now*10+i, n, list);
            } else {
                break;
            }
        }
    }
}
```
