package d1_algorithm.recursion;

import java.util.HashSet;
import java.util.Set;

public class Homework1 {
    public static void main(String[] args) {
        int[] arr = {5};
        System.out.println(countMoney(arr, 9, 0));
        Set<Set<Integer>> set = generateSubsets(arr);
        System.out.println(set);
    }

    //组合问题,有1,5,10,20,50面值钱币,有多少种组合成100的方法
    public static int countMoney(int[] arr, int sum, int cur) {
        if (cur == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i * arr[cur] <= sum; i++) {
            count += countMoney(arr, sum - i * arr[cur], cur - 1);
        }
        return count;

    }

    //集合拆分
    public static Set<Set<Integer>> generateSubsets(int[] set) {
        Set<Set<Integer>> allSubsets = new HashSet<>();
        generateSubsets(set, 0, new HashSet<>(), allSubsets);
        return allSubsets;
    }

    private static void generateSubsets(int[] set, int index,
                                        Set<Integer> currentSubset, Set<Set<Integer>> allSubsets) {
        if (index == set.length) {
            // 当到达集合末尾时，添加当前子集到所有子集的集合中
            allSubsets.add(new HashSet<>(currentSubset));
            return;
        }

        // 选择当前元素
        currentSubset.add(set[index]);
        generateSubsets(set, index + 1, currentSubset, allSubsets);

        // 不选择当前元素，回溯
        currentSubset.remove(set[index]);
        generateSubsets(set, index + 1, currentSubset, allSubsets);
    }

}
