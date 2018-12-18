# Reordered Power of 2
## 思路

有两种解法：
1. 将所有的2的次幂保存在一个set集合中，再将输入整数的每一位保存在数组中，判断set集合中是否有这个数组中的内容，这种思路比较巧妙的地方在于不需要对整数的每一位进行全排列，再去判断是否是2的次幂。
2. 对整数的每一位进行全排列以后再依次判断组合后的数是否是2的次幂。

## 示例代码
``` java
class Solution{
    public boolean reorderedPowerOf2(int N) {
        Set<String> set = new HashSet();
        for (int i = 1; i < 1000000000; i*=2) {
           set.add(powerContainer(i));
        }

        return set.contains(powerCotainer(N));
    }

    public String powerContainer(int num) {
        int[] fix = new int[10];
        while (num > 0) {
            int digit = num%10;
            fix[digit]++;
            num = num/10;
        }

        return Arrays.toString(fix);
    }
}
```
