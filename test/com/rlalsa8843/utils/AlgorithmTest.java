package com.rlalsa8843.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.rlalsa8843.utils.CommonUtils.createRandomArray;
import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    @BeforeEach
    void setUp() { }

    @AfterEach
    void tearDown() { }

    @Test
    void dfs() {
        int[][] map = {
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        int start = 0;
        int n = map.length;
        boolean[] isVisit = new boolean[n];

        long st = System.currentTimeMillis();
        Algorithm.dfs(map, start, isVisit, n);
        long et = System.currentTimeMillis();

        System.out.println("dfs 알고리즘 속도 측정: " + (et - st) + " ms");

        assertTrue(true);
    }

    @Test
    void bfs() {
        int[][] map = {
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        int start = 0;
        int n = map.length;
        boolean[] isVisit = new boolean[n];

        long st = System.currentTimeMillis();
        Algorithm.bfs(map, start, isVisit, n);
        long et = System.currentTimeMillis();

        System.out.println("bfs 알고리즘 속도 측정: " + (et - st) + " ms");

        assertTrue(true);
    }

    @Test
    void euclideanLoop() {
        int q = 6;
        int p = 1024;

        long st = System.currentTimeMillis();
        int gcd = Algorithm.euclideanLoop(p, q);
        long et = System.currentTimeMillis();

        System.out.println("유클리드 호제법(반복문) 속도 측정: " + (et - st) + " ms");
        
        assertEquals(gcd, 2);
    }

    @Test
    void euclideanRecursion() {
        int q = 1024;
        int p = 6;

        long st = System.currentTimeMillis();
        int gcd = Algorithm.euclideanRecursion(p, q);
        long et = System.currentTimeMillis();

        System.out.println("유클리드 호제법(재귀) 속도 측정: " + (et - st) + " ms");
        
        
        assertEquals(gcd, 2);
    }

    @Test
    void selectionSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);

        long st = System.currentTimeMillis();
        Algorithm.selectionSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("선택정렬 속도 측정: " + (et - st) + " ms");

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Algorithm.selectionSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }
    
    @Test
    void bubbleSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);

        long st = System.currentTimeMillis();
        Algorithm.bubbleSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("버블정렬 속도 측정: " + (et - st) + " ms");

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Algorithm.bubbleSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void insertionSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);

        long st = System.currentTimeMillis();
        Algorithm.insertionSort(randomArray, n);
        long et = System.currentTimeMillis();

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Algorithm.insertionSort(arr, arr.length);

        System.out.println("삽입정렬 속도 측정: " + (et - st) + " ms");

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }
    
    @Test
    void quickSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);

        long st = System.currentTimeMillis();
        Algorithm.quickSort(randomArray, 0, n - 1);
        long et = System.currentTimeMillis();

        System.out.println("퀵정렬 속도 측정: " + (et - st) + " ms");

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Algorithm.quickSort(arr, 0, arr.length - 1);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

    @Test
    void shellSort() {
        int n = 100000;
        int[] randomArray = createRandomArray(n);

        long st = System.currentTimeMillis();
        Algorithm.shellSort(randomArray, n);
        long et = System.currentTimeMillis();

        System.out.println("쉘정렬 속도 측정: " + (et - st) + " ms");

        int[] arr = { 3, 1, 2, 6, 4, 3 };
        Algorithm.shellSort(arr, arr.length);

        assertArrayEquals(new int[]{ 1, 2, 3, 3, 4, 6 }, arr);
    }

}