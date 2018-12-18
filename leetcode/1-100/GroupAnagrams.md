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
