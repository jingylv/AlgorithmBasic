import java.util.Arrays;

/**
 * Author: lvjingyuan
 * Email: lvjyuan@163.com
 * Date: 2018/11/29
 * Describe: 插入排序  时间复杂度: O(n²)  空间复杂度: O(1)
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        // 写法 1
        // 从下标为 1 的元素开始向前比较, 下标为 0 的元素默认有效
//        for (int i = 1; i < arr.length; i++) {
//            // 插入排序中 i 位置之前的元素肯定是按照从小到大的顺序拍好的, 这里从 i 位置开始,依次跟前一个元素
//            // 进行比较,找正确位置插入进去
//            for (int j = i; j > 0; j--) {
//                // 后一个元素比前一个元素小,就交换位置
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    // 后一个元素比前一个元素大,就跳出
//                    break;
//                }
//            }
//        }

        // 写法 2
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
//        }

        // 写法 3
        for (int i = 0; i < arr.length; i++) {
            // 待插入到合适位置的元素
            Comparable element = arr[i];
            // 记录合适位置的下标
            int j;
            // 如果待排序元素小于前一个元素,就将前一个元素的值赋给待排序元素所在位置;
            // 然后待排序元素又和前前一个元素进行比较,如果待排序元素小于前前元素,前前元素的值赋给前元素位置;
            // 以此类推, 直到待排序元素不小于某个元素,此时合适位置是 j
            for (j = i; j > 0 && element.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            // element 赋值到合适位置
            arr[j] = element;
        }

    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
//        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 3);
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 100);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("InsertionSort", arr);
        SortTestHelper.testSort("SelectionSort", arr2);

    }

}
