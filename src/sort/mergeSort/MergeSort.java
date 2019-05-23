package sort.mergeSort;

/**
 * @author lihao
 * @date 2019-05-23 20:54
 *
 * 归并排序实现
 *
 * 归并排序思路是将一个数组分为两个子数组，将每个子数组进行排序，最终合并到一起.递归思想
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 */
public class MergeSort {

    /**
     * 归并排序
     * @param array 乱序数组
     * @return
     */
    public int[] mergeSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array;
        }
        // 创建一个和原数组相等大小的临时数组，用来暂存数据
        int[] temp = new int[array.length];
        // 调用排序方法
        sort(array, temp, 0, array.length - 1);
        return temp;
    }

    /**
     * 排序算法
     * @param array 原数组
     * @param temp 临时数组
     * @param left 数组左边界
     * @param right 数组右边界
     */
    private void sort(int[] array, int[] temp, int left, int right) {
        // 当左边界大于等于右边界时，返回
        if (left >= right) {
            return;
        }
        // 求出两数组的中间位置
        int mid = (left + right) / 2;
        // 对左边排序
        sort(array, temp, left, mid);
        // 对右边排序
        sort(array, temp, mid + 1, right);
        // 将两边数组进行归并
        merge(array, temp, left, mid, right);
    }

    /**
     * 归并算法
     * @param array 原数组
     * @param temp 临时数组
     * @param left 数组1左边界
     * @param mid 数组1右边界
     * @param right 数组2右边界（数组2左边界为mid + 1）
     */
    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        int index1 = left;
        int index2 = mid + 1;
        int indexN = 0;
        // 将两个数组进行合并
        while (index1 <= mid && index2 <= right) {
            if (array[index1] <= array[index2]) {
                temp[indexN++] = array[index1];
                index1++;
            } else {
                temp[indexN++] = array[index2];
                index2++;
            }
        }
        if (index1 <= mid) {
            for (int i = index1; i <= mid; i++) {
                temp[indexN++] = array[i];
            }
        } else {
            for (int i = index2; i <= right; i++) {
                temp[indexN++] = array[i];
            }
        }
        // 重置临时数组下标，将排序后的结果赋值到原数组中
        indexN = 0;
        while(left <= right){
            array[left++] = temp[indexN++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.mergeSort(new int[]{3, 200, 4, 8, 1, 32});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
