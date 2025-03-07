package d2_datastructures.queue;

import java.util.Arrays;
import java.util.LinkedList;

public class MonotonicQueue {
    private LinkedList<Integer>deque = new LinkedList<>();

    public Integer peek(){
        return deque.peekFirst();
    }

    public void poll(){
        deque.pollFirst();
    }

    public void offer(int t){
        while (!deque.isEmpty()&&deque.peekLast()<t){
            deque.pollLast();
        }
        deque.offerLast(t);
    }

    @Override
    public String toString() {
        return deque.toString();
    }
    public static void main(String[] args) {
        MonotonicQueue queue = new MonotonicQueue();
        int k = 3;
        int[] nums = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        int[]answer = maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(answer));
    }

    /**
     *滑动窗口最大值问题
     *依次输出长度为k的滑动窗口最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        int index = 0;
        int []an =new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            if(i>=k&&queue.peek() ==  nums[i-k]){
                queue.poll();
            }
            queue.offer(nums[i]);
            if(i>=k-1){
                an[index++] = queue.peek();
            }
        }
        return an;
    }
}
