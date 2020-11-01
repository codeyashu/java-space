package io.rsi.codespace.sorting;

import static io.rsi.codespace.util.DsAlogoUtil.printArray;
import static io.rsi.codespace.util.DsAlogoUtil.swap;

public class BubbleSort {
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            System.out.println(++count);
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwapped = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!isSwapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 24, 12, 22, 11, 6};
        bubbleSort(arr);
        printArray(arr);
    }
}
