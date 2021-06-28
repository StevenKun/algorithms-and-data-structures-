package sort;


/**
 * 选择排序
 */
public class SelectSort {


    public static <E extends Comparable<E>> void selectSort(E[] arr) {
        // arr[i...n]為循環不變量
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;

            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }

            }
            swapData(arr, i, maxIndex);
        }
    }

    public static <E> void swapData(E[] arr, int i, int j) {
        E t = arr[j];

        arr[j] = arr[i];

        arr[i] = t;
    }





}
