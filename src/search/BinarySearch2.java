package search;

/*** 二分查找变体1，找出最后一个等于给定值的索引
 * @author lihao
 * @date 2019-06-03 21:49
 */
public class BinarySearch2 {

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
                // 关键，如果mid等于最后一个索引或者右边的数和它不相等，则返回索引，否则，low = mid + 1
                if (mid == array.length - 1 || array[mid + 1] != array[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch2 binarySearch = new BinarySearch2();
        int[] array = new int[]{1, 4, 4, 4, 4, 9};
        System.out.println(binarySearch.bSearch(array, 4));
    }
}
