package io.rsi.codespace.algo.array;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int turn = 5;
        rotateArrayByTurn(arr, turn);
        System.out.println(Arrays.toString(Arrays.stream(arr).toArray()));
    }

    public static void rotateArrayByTurn(int[] arr, int turn) {
        for (int j = 0; j < turn; j++) {
            rotateByOne(arr);
        }
    }

    public static void rotateByOne(int[] arr) {
        int temp = arr[0];
        // IntStream.rangeClosed(1, arr.length - 1).forEach(i -> arr[i - 1] = arr[i]); - for each

        //while
       /* int i = 1;
        while (i <= arr.length -1) {
            arr[i-1] = arr[i];
            i++;
        }*/

        //for loop
        /*for (int i = 1; i <= arr.length -1 ; i++) {
            arr[i-1] = arr[i];
        }*/

        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = temp;
    }
}
