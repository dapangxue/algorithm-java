# 字符串的交错组成

假设有三个字符串s1 = "ABCD" s2 = "1234" s3 = "1234ABCD",如果在s3中的字符在s1、s2中顺序一致，就说s3由s1和s2字符串交错。

## 示例代码

```JAVA
package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Create by IDEA
 *
 * @author wuxue
 * @date 19-8-27
 */
public class IsInterleave {
    /**
     * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        // s3为空串，可以被s1为空串和s2为空串交错组成
        dp[0][0] = true;
        for (int i = 1; i < m + 1; i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                break;
            }
            dp[i][0] = true;
        }

        for (int j = 1; j < n + 1; j++) {
            if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if ((dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "1234";
        String s3 = "1234ABCD";
        isInterleave(s1, s2, s3);
        // System.out.println(isInterleave(s1, s2, s3));
    }
}

```
