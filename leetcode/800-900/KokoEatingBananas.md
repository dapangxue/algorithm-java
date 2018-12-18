# Koko Eating Bananas
## 示例代码
``` java
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        Arrays.sort(piles);
        int high = piles[piles.length-1];

        while (low != high) {
            int mid = (low + high)/2;
            int sum = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i]%mid == 0) {
                    sum += piles[i]/mid;
                } else {
                    sum += piles[i]/mid + 1;
                }
            }

            if (sum > H) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
```
