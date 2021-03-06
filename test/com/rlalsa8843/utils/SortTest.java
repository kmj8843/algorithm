package com.rlalsa8843.utils;

import com.rlalsa8843.utils.algorithm.Sort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.rlalsa8843.utils.CommonUtils.createRandomArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {


    @BeforeEach
    void setUp() { }

    @AfterEach
    void tearDown() { }

    @Test
    void selectionSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.selectionSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("선택 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.selectionSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void bubbleSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.bubbleSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("버블 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.bubbleSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void insertionSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.insertionSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("삽입 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.insertionSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void quickSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.quickSort(randomArray, 0, n - 1);
        long et = System.currentTimeMillis();

        System.out.println("퀵 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.quickSort(arr, 0, arr.length - 1);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void shellSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.shellSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("쉘 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.shellSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void heapSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.heapSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("힙 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.heapSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void countingSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        int[] _resultArray = Sort.countingSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("계수 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, _resultArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        int[] result = Sort.countingSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, result);
    }

    @Test
    void mergeSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.mergeSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("계수 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.mergeSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }
    
    @Test
    void binaryInsertionSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);
        int[] clone = Arrays.stream(randomArray).sorted().toArray();

        long st = System.currentTimeMillis();
        Sort.binaryInsertionSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("이진 삽입 정렬 속도 측정: " + (et - st) + " ms");
        assertArrayEquals(clone, randomArray);

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Sort.binaryInsertionSort(arr, arr.length);
        Arrays.stream(arr).forEach(System.out::print);
        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }
}
