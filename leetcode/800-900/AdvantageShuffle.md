# Advantage Shuffle
## 思路
本体的关键在于找出A数组中，刚好大于B数组的元素，首先要对两个数组进行排序，从小到大依次对比，但是B数组又不能直接排序。若A中存在元素小于B中的每个元素，留在最后处理。
## 示例代码
``` java
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int commonLength = A.length;

        Integer[] dummy = new Integer[A.length];
        for (int i = 0; i < dummy.length; i++) {
            dummy[i] = i;
        }

        Arrays.sort(dummy, new Comparator<Integer> () {
           @Override
            public int compare(Integer x, Integer y) {
                return B[x] - B[y];
            }
        });

        int fix = 0;
        boolean[] symbol = new boolean[commonLength];
        int[] newA = new int[commonLength];
        Arrays.fill(newA, -1);
        for (int j = 0; j < commonLength; j++) {
            while (fix < commonLength && A[fix] <= B[dummy[j]]) {
                fix++;
            }
            if (fix == commonLength) {
                break;
            }
            symbol[fix] = true;
            newA[dummy[j]] = A[fix];
            fix++;
        }
        fix = 0;
        for (int i = 0; i < commonLength; i++) {
            if (newA[i] < 0) {
                while (fix < commonLength && symbol[fix]) {
                    fix++;
                }
                if (fix == commonLength) {
                    throw new RuntimeException();
                }
                newA[i] = A[fix];
                fix++;
            }
        }
        return newA;
    }
}
```
