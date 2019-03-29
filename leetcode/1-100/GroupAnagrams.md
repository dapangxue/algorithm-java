# Group Anagrams
## 示例代码
``` java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> list = new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();

        for (String x : strs) {
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(x);
        }
        return new ArrayList(map.values());
    }
}
```
方法二
每个数只有一个质因子组合（独一无二）
``` JAVA
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] a = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, List<String>> map = new HashMap<>();
        for (String x : strs) {
            char[] c = x.toCharArray();
            int t = 1;
            for (int i = 0; i < c.length; i++) {
                t *= a[c[i] - 'a'];
            }
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<String>());
            }
            map.get(t).add(x);
        }
        return new ArrayList<>(map.values());
    }
}
```
