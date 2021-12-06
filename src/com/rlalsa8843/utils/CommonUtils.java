package com.rlalsa8843.utils;

public class CommonUtils {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] createRandomArray(int n) {
        int[] array = new int[n];

        for ( int i = 0; i < n; i++ )
            array[i] = (int) (Math.random() * n);

        return array;
    }
}
