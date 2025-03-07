package d1_algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 这里用策略模式展示排序算法
 */
interface Sort {
    String sort(int[] arr);
}

/**
 * 冒泡排序
 */
class BubbleSort implements Sort {
    @Override
    public String sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return "冒泡";
    }
}

/**
 * 选择排序
 */
class SelectionSort implements Sort {
    @Override
    public String sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return "选择";
    }
}

/**
 * 快速排序
 */
class QuickSort implements Sort {
    @Override
    public String sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
        return "快速";
    }

    public int partition(int[] arr, int low, int high) {
        int piv = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= piv) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= piv) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = piv;
        return low;
    }

    public void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int piv = partition(arr, low, high);
            quicksort(arr, low, piv - 1);
            quicksort(arr, piv + 1, high);

        }
    }
}


/**
 * 插入排序
 */
class InsertSort implements Sort {
    @Override
    public String sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i - 1;
            while (j >= 0 && t < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = t;
        }
        return "插入";
    }
}

/**
 * 希尔排序
 */
class ShellSort implements Sort {
    @Override
    public String sort(int[] arr) {
        int n = arr.length;

        int h = n / 2;

        // 进行希尔排序
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < n; i++) {
                // 将arr[i]插入到arr[i-h], arr[i-2*h], arr[i-3*h]...之中
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    // 交换操作，但这里不使用交换，而是使用赋值
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            // 减小间隔
            h /= 2;
        }
        return "希尔";
    }
}


/**
 * 归并排序
 */
class MergeSort implements Sort {
    @Override
    public String sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);

        return "归并";
    }

    public void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) >> 1;
        mergeSort(arr, temp, leftStart, mid);
        mergeSort(arr, temp, mid + 1, rightEnd);
        merge(arr, temp, leftStart, rightEnd);
    }

    public void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) >> 1;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

    }
}

/**
 * 堆排序
 */
class HeapSort implements Sort {
    static class MaxHeap {
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

        private void swap(int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

    }

    @Override
    public String sort(int[] arr) {
        MaxHeap heap = new MaxHeap(arr);
        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }
        return "堆";
    }
}

/**
 * 基数排序
 */
class RadixSort implements Sort {
    @Override
    public String sort(int[] arr) {
        return "基数";
    }
}


/**
 * 桶排序
 */
class BucketSort implements Sort {
    @Override
    public String sort(int[] arr) {

        return "桶";
    }
}

/**
 * 计数排序
 */
class CountingSort implements Sort {
    @Override
    public String sort(int[] arr) {
        return "计数";
    }
}

/**
 * Arrays.sort()
 */
class ArraysSort implements Sort {
    @Override
    public String sort(int[] arr) {
        Arrays.sort(arr);
        return "Arrays.sort";
    }
}

class Display {
    public void countTime(Sort s) {
        test(s);
        int[] arr = new int[7500];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5000);
        }
        long start = System.currentTimeMillis();
        String name = s.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(name + "排序耗时" + (end - start) + "ms");
    }

    public void test(Sort s) {
        int[] arr = {4, 7, 2, 9, 1, 23, 14, 6};
        String name = s.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                System.out.println(name + "排序失败,数组不有序");
                return;
            }
        }

        System.out.println(name + "排序成功");
    }
}

public class SortMain {
    public static void main(String[] args) {
        Display d = new Display();
        d.countTime(new ArraysSort());//Arrays
        d.countTime(new BubbleSort());//冒泡
        d.countTime(new InsertSort());//插入
        d.countTime(new SelectionSort());//选择
        d.countTime(new QuickSort());//快速
        d.countTime(new HeapSort());//堆
        d.countTime(new ShellSort());//希尔
        d.countTime(new MergeSort());//归并
        d.countTime(new BucketSort());//桶
        d.countTime(new CountingSort());//计数
        d.countTime(new RadixSort());//基数

    }
}