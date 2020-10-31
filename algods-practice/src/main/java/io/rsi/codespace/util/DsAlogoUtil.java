package io.rsi.codespace.util;

import java.util.Arrays;

public class DsAlogoUtil {

    public static void swap(int[] arr, int min_idx, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[min_idx];
        arr[min_idx] = temp;
    }

    public static void printArray(int[] arr){
        Arrays.stream(arr).forEach(x ->  System.out.print(x + " "));
    }

    public static void print(String str){
        System.out.print(str);
    }
}
