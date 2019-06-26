package question0015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 利用哈希表记录每个数字出现的次数。
 * <p>
 * 时间复杂度是O(n ^ 2)，其中n为nums数组的长度。空间复杂度是O(n)。
 * <p>
 * 执行用时：268ms，击败10.12%。消耗内存：49.2MB，击败85.36%。
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        //考虑3个0的情况
        if (hashMap.containsKey(0) && hashMap.get(0) >= 3) {
            addToListList(0, 0, 0, listList);
        }
        List<Integer> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) * 2 + list.get(j) == 0 && hashMap.get(list.get(i)) >= 2) {
                    addToListList(list.get(i), list.get(i), list.get(j), listList);
                }
                if (list.get(i) + list.get(j) * 2 == 0 && hashMap.get(list.get(j)) >= 2) {
                    addToListList(list.get(i), list.get(j), list.get(j), listList);
                }
                int num = -list.get(i) - list.get(j);
                if (num > list.get(j) && hashMap.containsKey(num)) {
                    addToListList(list.get(i), list.get(j), num, listList);
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        listList.add(list);
    }
}
