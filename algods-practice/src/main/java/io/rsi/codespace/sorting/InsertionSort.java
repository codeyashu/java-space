package io.rsi.codespace.sorting;

import static io.rsi.codespace.util.DsAlogoUtil.printArray;

public class InsertionSort {
    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;

           /* int k;
            for (k = i - 1; k >= 0 && arr[k] > temp; k--) {
                arr[k + 1] = arr[k];
            }
            arr[k + 1] = temp;*/
        }
    }

    public static void main(String[] args) {
        //int[] arr = {64, 24, 12, 22, 11};
        int[] arr = {4, 5, 10, 1, 6, 2};
        insertionSort(arr);
        printArray(arr);
    }
}
