package d1_algorithm.serach;

public class SearchMain {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 8, 11};
        int[] arr2 = {1, 2, 3, 4, 4, 4, 4, 5, 5, 6, 7};
        System.out.println("所查数字索引为" + binarySearch(arr, 4));
        System.out.println("所查数字索引为" + binarySearchBalance(arr, 5));
        System.out.println("所查最左数字索引为" + binarySearchLeftMost(arr2, 4));
        System.out.println("所查数字索引为" + binarySearchLeftMost(arr2, 8));
        System.out.println("所查最右数字索引为" + binarySearchRightMost(arr2, 4));
        System.out.println("所查数字索引为" + binarySearchRightMost(arr2, 0));
        System.out.println("所查数字索引为" + reBinarySearch(arr, 4, 0, arr.length - 1));

    }

    //非平衡二分查找,如果进入elif则比只进if多了一倍比较次数
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //二进制表示数右移一位,自己理解,等价于/2
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    //平衡二分查找
    public static int binarySearchBalance(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high - 1) {
            int mid = (low + high) >>> 1;
            if (key < arr[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return arr[low] == key ? low : -(low + 1);

    }

    //要求所查找的数最靠左的索引
    public static int binarySearchLeftMost(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    //要求所查找的数最靠右的索引
    public static int binarySearchRightMost(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int reBinarySearch(int[] arr, int key, int low, int high) {
        if (high >= low) {
            int mid = (high + low) >> 1;

            // 如果元素正好在中间
            if (arr[mid] == key)
                return mid;

            // 如果元素小于中间元素，则只能在左侧查找
            if (arr[mid] > key)
                return reBinarySearch(arr, key, low, mid - 1);

            // 否则，元素在右侧子数组中
            return reBinarySearch(arr, key, mid + 1, high);
        }

        // 元素不在数组中
        return -1-low;
    }
}

