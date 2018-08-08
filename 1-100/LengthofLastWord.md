# Length of Last Word
## java
``` java
class Solution {
    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
}
```
``` java
class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.trim.lastIndexOf(" ");
        int length = s.trim.length();
        return length-index-1;
    }
}
```
