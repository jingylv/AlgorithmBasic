/**
 * Author: lvjingyuan
 * Email: lvjyuan@163.com
 * Date: 2018/11/29
 * Describe: 选择排序  时间复杂度: O(n²)  空间复杂度: O(1)
 */
public class SelectionSort {
    // 我们的算法不允许产生任何实例
    private SelectionSort() {
    }

    /**
     * 对指定的数组进行排序,默认是从小到大排序(升序)
     *
     * @param arr 待排序的数组
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 写法 1 强烈建议使用这种写法
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找区间[i,n)中的最小元素的下标值
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // 将 i 位置上的值与区间[i,n)中最小值交换位置
            swap(arr, i, minIndex);
        }

        // 写法 2 非常不建议使用这种写法,因为执行 swap 方法很耗时(毕竟每执行一次 swap 方法就赋值 3 次,这是多大的性能损耗啊)
//        for (int i = 0; i < n; i++) {
//            // 寻找区间[i,n)中的最小值并与 arr[i] 进行位置交换
//            // 每循环一圈大多数情况下会交换多次
//            for (int j = i + 1; j < n; j++) {
//                if (arr[j].compareTo(arr[i]) < 0) {
//                    // 交换 arr[i] 与 arr[j]
//                    swap(arr, i, j);
//                }
//            }
//        }
    }

    /**
     * 交换指定数组中指定的 2 个元素的位置
     *
     * @param arr 指定的数组
     * @param i   指定元素 1
     * @param j   指定元素2
     */
    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 5, 1, 7, 3, 8, 0};
        SelectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
