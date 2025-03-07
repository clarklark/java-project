package d1_algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
    N数之和
    一个数组和一个target
    返回所有和为target且长度为N的列表
 */
public class N_Sum {
    public static void main(String[] args) {
        int []nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        int n = 4;
        List<List<Integer>> lists = new N_Sum().fourSum(nums,target,n);
        System.out.println("通过");
    }
    public List<List<Integer>> fourSum(int[] nums, int target,int n) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(n,0,nums.length-1,target,nums,new LinkedList<>(),result);
        return result;
    }
    static void dfs(int n,int i,int j,long target,int[]nums,LinkedList<Integer>stack,List<List<Integer>> result){
        if(n == 2){
            while(i<j){
                long sum = nums[i] + nums[j];
                if(sum<target){
                    i++;
                }else if(sum > target){
                    j--;
                }else{
                    ArrayList<Integer>list = new ArrayList<>(stack);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    i++;
                    j--;
                    while(i<j&&nums[i] == nums[i-1]){
                        i++;
                    }
                    while(i<j&&nums[j] == nums[j+1]){
                        j--;
                    }
                }
            }
        }
        for(int k = i;k < j - (n-2);k++){
            if(k>i&&nums[k] == nums[k-1]){
                continue;
            }
            stack.push(nums[k]);
            dfs(n-1,k+1,j,target - nums[k],nums,stack,result);
            stack.pop();
        }
    }
}
