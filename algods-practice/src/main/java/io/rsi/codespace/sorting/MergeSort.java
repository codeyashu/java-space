package io.rsi.codespace.sorting;

import static io.rsi.codespace.util.DsAlogoUtil.printArray;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {64, 24, 12, 22, 11, 3, 67, 23};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            quickSort(arr, low, mid);
            quickSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int m = 0; m < n1; ++m) {
            left[m] = arr[low + m];
        }

        for (int n = 0; n < n2; ++n) {
            right[n] = arr[mid + 1 + n];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}

