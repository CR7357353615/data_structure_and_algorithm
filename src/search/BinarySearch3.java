package search;

/*** 二分查找变体1，查找第一个大于等于给定值的索引
 * @author lihao
 * @date 2019-06-03 21:49
 */
public class BinarySearch3 {

    private int bSearch(int[] array, int value) {
        if (null == array || array.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            // 避免溢出
            int mid = low + ((high - low) >> 1);
            if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch3 binarySearch = new BinarySearch3();
        int[] array = new int[]{1, 3, 3, 4, 4, 9};
        System.out.println(binarySearch.bSearch(array, 5));
    }
}
