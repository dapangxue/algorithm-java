# Permutation Sequence
## 思路
本题先按要求全排列再去找第k个字符串是最慢的一种方法，题目让找第几个就按要求构建第几个全排列的字符串就好。

先穷举所有的可能性，对于n=4,全排列的情况有一下几种：
```
1234 1243 1324 1342 1423 1432
2134 2143 2314 2341 2413 2431
3124 3142 3214 3241 3412 3421
4123 4132 4213 4231 4312 4321
```
假设k=21,对应到上面数组的索引是20，每确定一个数字，剩下的可能性就是剩余数字个数的阶乘。比如确定第一个数字是1，那么1对应的可能性就有3!=6种，第21种情况是在第3的情况完成之后即4所对应的那一行。20/6 = 3,即[1,2,3,4]中取索引为3对应的数字。剩下的第二位是在[1,2,3]中取出，20%6=2,[1,2,3]在第一位确定的情况下对应的情况为2种,以此类推。
```
20/6=3
20%6=2
第一位数字为4
2/2=1
2%2=0
第二位数字为2
0/1=0
0%1=0
第三位数字为1
0/1=0
0%1=0
第四位数字为3
```
## 示例代码
``` java
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] fix = new int[n];
        fix[0] = 1;
        for (int i = 1; i < n; i++) {
            fix[i] = fix[i-1]*i;
        }
        --k;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int j = k/fix[i-1];
            k %= fix[i-1];
            stringBuilder.append(list.get(j));
            list.remove(j);
        }
        return stringBuilder.toString();
    }
}
```
