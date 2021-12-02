package com.rlalsa8843.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        int[] arr = { 3, 1, 2, 6, 4, 3 };

        long st = System.currentTimeMillis();
        int[] result = Algorithm.selectionSort(arr, 6);
        long et = System.currentTimeMillis();

        System.out.println("선택정렬 속도 측정: " + (et - st) + " ms");
        
        assertArrayEquals(result, new int[]{ 1, 2, 3, 3, 4, 6 });
    }
    
    @Test
    void bubbleSort() {
        int[] arr = { 3, 1, 2, 6, 4, 3 };

        long st = System.currentTimeMillis();
        int[] result = Algorithm.bubbleSort(arr, 6);
        long et = System.currentTimeMillis();

        System.out.println("버블정렬 속도 측정: " + (et - st) + " ms");

        assertArrayEquals(result, new int[]{ 1, 2, 3, 3, 4, 6 });
    }
    
    @Test
    void quickSort() {
        int[] arr = { 3, 1, 2, 6, 4, 3 };

        long st = System.currentTimeMillis();
        int[] result = Algorithm.quickSort(arr, 0, 6);
        long et = System.currentTimeMillis();

        System.out.println("퀵정렬 속도 측정: " + (et - st) + " ms");

        assertArrayEquals(result, new int[]{ 1, 2, 3, 3, 4, 6 });
    }
}