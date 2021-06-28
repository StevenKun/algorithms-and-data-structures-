package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static<E extends Comparable<E>> void insertSort(E[] arr) {

        // arr[0...i]為循環不變量，arr(i...n)可變
        for (int i=0 ;i<arr.length;i++){
            for (int j=i; j-1>0;j--){
                if (arr[j].compareTo(arr[j-1])<0){
                    swapData(arr,j,j-1);
                }
            }
        }
    }



    public static<E extends Comparable<E>> void insertSort2(E[] arr) {
        // arr[i...n]為循環不變量
        for (int i=arr.length-1 ;i>=0;i--){
            for (int j=i; j+1<arr.length;j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    swapData(arr,j,j+1);
                }
            }
        }
    }

    public static <E> void swapData(E[] arr, int j, int i) {
        E t =arr[j];

        arr[j] =arr[i];

        arr[i] =t;
    }

}
