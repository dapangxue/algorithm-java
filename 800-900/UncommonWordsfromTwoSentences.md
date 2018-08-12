# Uncommon Words from Two Sentences
`list转数组`
## 示例代码
``` java
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] str1 = A.split(" ");
        String[] str2 = B.split(" ");
        List<String> list1 = Arrays.asList(str1);
        List<String> list2 = Arrays.asList(str2);

        List<String> list = new ArrayList<>();
        int count = 0;
        for (String x : str2) {
            if (!list1.contains(x)) {
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i].equals(x)) {
                        count++;
                    }
                }
                if (count < 2) {
                    list.add(x);
                }
                count = 0;
            }
        }
        for (String x : str1) {
            if (!list2.contains(x)) {
                for (int i = 0; i < str1.length; i++) {
                    if (str1[i].equals(x)) {       
                        count = count + 1;
                    }
                }
                if (count < 2) {
                    list.add(x);
                }
                count = 0;
            }
        }
        return (String[])list.toArray(new String[list.size()]);
    }
}
```
``` java
class Solution {
       public String[] uncommonFromSentences(String A, String B) {
           String[] wa = A.split(" ");
           String[] wb = B.split(" ");

           Map<String, Integer> foo = new HashMap();
           for (String s : wa) {
               if (foo.containsKey(s)) {
                   foo.put(s, foo.get(s) + 1);
               } else {
                   foo.put(s, 1);
               }
           }

           for (String s : wb) {
               if (foo.containsKey(s)) {
                   foo.put(s, foo.get(s) + 1);
               } else {
                   foo.put(s, 1);
               }
           }

           List<String> l = new ArrayList();
           for (Map.Entry<String, Integer> entry : foo.entrySet()) {
               if (entry.getValue().equals(1)) {
                   l.add(entry.getKey());
               }
           }

           String[] res = new String[l.size()];
           l.toArray(res);
           return res;
       }
   }
```
