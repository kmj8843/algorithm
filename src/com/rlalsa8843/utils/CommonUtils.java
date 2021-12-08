package com.rlalsa8843.utils;

/**
 *
 * @author  김민재
 * @version 1.0
 * */
public class CommonUtils {

    /**
     * 배열의 i 인덱스와 j 인덱스의 값을 swap
     *
     * @author 김민재
     * @param   arr swap 대상이 될 배열
     * @param   i   배열에서 위치를 바꿀 인덱스1
     * @param   j   배열에서 위치를 바꿀 인덱스2
     * */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * n 개수만큼의 인자를 가진 랜던 숫자의 배열을 만듬
     *
     * @author 김민재
     * @param  n 배열의 크기 및 배열에 담길 인자의 범위
     * @return 랜덤 인자의 배열
     * */
    public static int[] createRandomArray(int n) {
        int[] array = new int[n];

        for ( int i = 0; i < n; i++ )
            array[i] = (int) (Math.random() * n);

        return array;
    }
}
