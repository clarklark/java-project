package d1_algorithm.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class AllSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    public static void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(nums[i]);
                dfs(nums, visited, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }
}
