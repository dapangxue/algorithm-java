# Prime Palindrome
## 思路
本题理解起来不难，难度在于怎么处理超时，`方法一`就是在处理N大于9989900～100030001较难处理，很容易超时，而且运算时间居然超过了5S.所以在前面我又加了一个判断，这样算偷了个懒做出来了。

`方法二`算是比较正常且巧妙的一种方法，就是在提交代码的时候尽量少用System.out.println()来打印信息，循环量比较大的情况下很容易超时。
## 示例代码
### 方法一
``` java
class Solution {
    public int primePalindrome(int N) {
        if (N <= 2) return 2;
        if (N >= 9989900 && N <= 100030001) {
            return 100030001;
        }
        int a = N % 2 == 0? N + 1:N;
        while (true) {
            if (Solution.isPrime(a)) {
                String reverse = new StringBuffer(String.valueOf(a)).reverse().toString();
                if (reverse.equals(String.valueOf(a))) {
                    break;
                }
            }
            a += 2;
        }
        return a;
    }

    public static boolean isPrime(int a) {
        boolean flag = true;

        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a%i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
```
### 方法二
``` java
class Solution {
    public int primePalindrome(int N) {
        // 所有的偶数位的回文数都可以被11整除，所以偶数位的回文数肯定不需要考虑，出了本身以11为素数的几个数
        if (N >= 8 && N <= 11) {
            return 11;
        }

        // 这里i<100000是因为将来的回文数最多为9位
        for (int i = 0; i < 100000; i++) {
            String a = String.valueOf(i);
            String b = new StringBuilder(a).reverse().toString().substring(1);
            int val = Integer.valueOf(a + b);
            if (val >= N && isPrime(val)) {
                return val;
            }
        }
        return -1;
    }

    public static boolean isPrime(int a) {
        boolean flag = true;

        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a%i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
```
