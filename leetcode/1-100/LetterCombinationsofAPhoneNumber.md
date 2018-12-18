# Letter Combinations of a Phone Number
## 示例代码
```java
class Solution{

    public static String[] str = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        LinkedList<String> list = new LinkedList<>();
        list.add("");

        char[] digitsArray = digits.toCharArray();
        for (int i = 0; i < digitsArray.length; i++) {
            char c = digitsArray[i];
            while (list.getFirst().length() == i) {
                String pop = list.removeFirst();
                for (char v : str[Integer.parseInt(String.valueOf(c))].toCharArray()) {
                    list.addLast(pop + v);
                }
            }
        }

        return list;
    }
}
```
