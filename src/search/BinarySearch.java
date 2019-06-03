package search;

/**
 * 二分查找，基本版
 * @author lihao
 * @date 2019-06-03 21:49
 */
public class BinarySearch {

    private int bSearch(int[] array, int value) {
        if (null == array || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            // 避免溢出
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = new int[]{1, 3, 4, 6, 7, 9};
        System.out.println(binarySearch.bSearch(array, 5));
    }
}
