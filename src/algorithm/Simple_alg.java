package algorithm;

public class Simple_alg {
    public static void main(String[] args) {
        SortAlg sort = new SortAlg();
        SearchAlg search=new SearchAlg();
        int[] arr = {1, 5, 3, 6, 8, 4};

        sort.bubble_sort(arr);
        printArr(arr);
        System.out.println(search.BinarySearch(arr, 6));
    }
    public static void printArr(int []arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class SearchAlg {
    /**
     *二分查找
     * 时间复杂度O(log n)
     */
    public int BinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

}

class SortAlg {
    /**
     *冒泡排序
     * 时间复杂度O(n^2)
     */
    public void bubble_sort(int[] arr) {
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

    }
}