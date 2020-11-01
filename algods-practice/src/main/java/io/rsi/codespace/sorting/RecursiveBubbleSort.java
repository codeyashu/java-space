package io.rsi.codespace.sorting;

import static io.rsi.codespace.util.DsAlogoUtil.printArray;
import static io.rsi.codespace.util.DsAlogoUtil.swap;

public class RecursiveBubbleSort {
    private static void bubbleSort(int[] arr, int n) {
        if (n == 1)
            return;

        int count = 0;
        boolean isSwapped = false;
        for (int i = 0; i < n - 1; i++) {
            ++count;
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                isSwapped = true;
            }
        }
        System.out.println(++count);
        if (isSwapped) bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 24, 12, 22, 11, 6, 76};
        //int[] arr = {1, 2, 3, 4, 5, 6};
        bubbleSort(arr, arr.length);
        printArray(arr);
    }
}
