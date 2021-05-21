package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code_349 {
//    给定两个数组，编写一个函数来计算它们的交集。

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        list.retainAll(set2);
        set1.addAll(list);
        return set1.stream().mapToInt(i->i).toArray();
    }
}
