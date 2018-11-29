import java.lang.reflect.Method;

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
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert (rangeL <= rangeR);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    // 生成含有 n 个元素近乎有序的数组, 数组元素的取值范围在区间 [0, n-1] 中
    // 首先生成 [0, n-1] 的完全有序数组, 然后随机交换 swaps 对数据
    // swaps == 0 时, 完全有序; swaps 越大越无序,越小越有序
    public static Integer[] generateNearlyOrderedArray(int n, int swaps) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swaps; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        return arr;

    }

    // 检查排序是否正确
    public static boolean isSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    // 打印数组
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    /**
     * 测试排序算法的正确性与运行时间
     *
     * @param sortClassName 排序算法的名称
     * @param arr           待排序的数组(必须是可比较类型)
     */
    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // 反射机制,通过排序类名获取到排序类的 Class 对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序类的 Class 对象获取到排序方法,
            // sort 是排序类中排序方法名,第二个参数表示传入 sort 方法的参数必须是可比较的
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个,是个可比较的数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序方法
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSort(arr);

            System.out.println(sortClass.getSimpleName() + ": 排序 " + arr.length + " 个数据耗时 " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
