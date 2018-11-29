/**
 * Author: lvjingyuan
 * Email: lvjyuan@163.com
 * Date: 2018/11/29
 * Describe: 排序测试辅助类
 */
public class SortTestHelper {
    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    // 生成含有 n 个元素的随机数组, 数组元素的取值范围在区间 [rangL, rangR] 中
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (rangeL <= rangeR);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    // 检查排序是否正确
    public static boolean isSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }
}
