package d2_datastructures.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] arr;
    int size;

    public MaxHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        heapify();
    }

    //构建大顶堆
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    //执行下沉方法
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }
        if (max != parent) {
            swap(max, parent);
            down(max);
        }
    }

    //获取堆顶
    public int peek() {
        return arr[0];
    }

    //删除堆顶
    public int poll() {
        int top = arr[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    public int poll(int index) {
        int deleted = arr[index];
        swap(deleted, size - 1);
        size--;
        down(deleted);
        return deleted;
    }

    //替换堆顶元素
    public void replace(int replaced) {
        arr[0] = replaced;
        down(0);
    }

    //将offer上浮,直至offered小于父元素或到堆顶
    public void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > arr[parent]) {
                arr[child] = arr[parent];
            } else {
                break;
            }
            child = parent;
        }
        arr[child] = offered;
    }



    private void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println(Arrays.toString(maxHeap.arr));
    }


}
