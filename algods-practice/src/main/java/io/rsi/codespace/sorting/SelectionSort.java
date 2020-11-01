package io.rsi.codespace.sorting;

import static io.rsi.codespace.util.DsAlogoUtil.printArray;
import static io.rsi.codespace.util.DsAlogoUtil.swap;

public class SelectionSort {

    /**TODO
     *  1. Sorting of string
     *  2. result after n number of checks
     *  3. sorting for any type of data structure
     *  **/

    public static void main(String[] args) {
        int[] arr = {64, 24, 12, 22, 11};
        selectionSort(arr);
        printArray(arr);
    }

    private static void selectionSort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if(arr[i] != arr[minIdx]){
                swap(arr, minIdx, i);
            }

        }
    }

}
