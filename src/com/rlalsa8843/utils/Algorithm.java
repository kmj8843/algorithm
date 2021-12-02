package com.rlalsa8843.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm {

    /*
    * 깊이 우선 탐색(Depth-First Search)
    *
    * 루트 노드(시작 노드)에서 다음 분기로 넘어가기 전에, 해당 분기를 모두 탐색
    * 탐색 후 다시 원점으로 돌아가 다른 분기 탐색
    * BFS 보다 느린 속도, 쉬운 구현
    *
    * @author  김민재
    * @version 1.0
    * @param   map     탐색할 노드
    * @param   start   탐색을 시작할 위치
    * @param   isVisit 각 노드를 방문했는지 여부
    * @param   n       노드 개수
    * */
    public static void dfs(int[][] map, int start, boolean[] isVisit, int n) {
        isVisit[start] = true;

        for (int i = 0; i < n; i++)
            if (map[start][i] == 1 && !isVisit[i])
                dfs(map, i, isVisit, n);
    }

    /*
     * 너비 우선 탐색(Bread-First Search)
     *
     * 루트 노드(시작 노드)에서 인접한 노드를 먼저 탐색
     * 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용
     *
     * @author  김민재
     * @version 1.0
     * @param   map     탐색할 노드
     * @param   start   탐색을 시작할 위치
     * @param   isVisit 각 노드를 방문했는지 여부
     * @param   n       노드 개수
     * */
    public static void bfs(int[][] map, int start, boolean[] isVisit, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisit[start] = true;

        while( !q.isEmpty() ) {
            int current = q.poll();

            for (int i = 0; i < n; i++) {
                if (map[current][i] == 1 && !isVisit[i]) {
                    q.offer(i);
                    isVisit[i] = true;
                }
            }
        }
    }

    /*
    * 유클리드 호제법(Euclidean Algorithm) - 반복문
    * 임의의 2개의 자연수 p와 q에서(단, p > q) p와 q를 나눈 나머지를 r 이라고 했을 때,
    * GCD(p, q) = GCD(q, r)과 같고, r이 0이면 b가 최대공약수임을 활용한 알고리즘
    *
    * @author  김민재
    * @version 1.0
    * @param   p 임의의 정수
    * @param   q 임의의 정수
    * @return  최대공약수
    * */
    public static int euclideanLoop(int p, int q) {
        if ( q < p ) {
            int tmp = p;
            p = q;
            q = tmp;
        }

        while( q != 0 ) {
            int r = p % q;
            p = q;
            q = r;
        }

        return p;
    }

    /*
     * 유클리드 호제법(Euclidean Algorithm) - 재귀
     * 임의의 2개의 자연수 p와 q에서(단, p > q) p와 q를 나눈 나머지를 r 이라고 했을 때,
     * GCD(p, q) = GCD(q, r)과 같고, r이 0이면 b가 최대공약수임을 활용한 알고리즘
     *
     * @author  김민재
     * @version 1.0
     * @param   p 임의의 정수
     * @param   q 임의의 정수
     * @return  최대공약수
     * */
    public static int euclideanRecursion(int p, int q) {
        if ( q == 0 ) return p;
        return euclideanRecursion(q, p % q);
    }

    /*
    * 선택정렬(Selection Sort)
    * 매 n번째 사이클마다 m > k > n + 1(m은 최대값) 중 최소값을 가지는 k와 n을 swap
    * 복잡도: O(n^2)
    * 총 비교횟수: n (n - 1) / 2
    *
    * @author  김민재
    * @version 1.0
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * @result  정렬된 배열
    * */
    public static int[] selectionSort(int[] arr, int n) {
        for ( int i = 0; i < n - 1; i++ ) {
            int minIndex = i;

            for ( int j = i + 1; j < n; j++ )
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    /*
    * 버블정렬(Bubble Sort)
    * 리스트를 순차적으로 탐색하며 인접한 두 개의 값을 비교
    * 복잡도: O(n^2)
    * 총 비교횟수: n (n - 1) / 2
    *
    * @author  김민재
    * @version 1.0
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * @result  정렬된 배열
    * */
    public static int[] bubbleSort(int[] arr, int n) {
        for ( int i = n - 1; i > 0; i-- ) {
            for ( int j = 0; j < i; j++ ) {
                if ( arr[j] > arr[j + 1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr [j + 1] =temp;
                }
            }
        }

        return arr;
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if ( left < right ) {
            int pivot = partition(arr, left, right);
            System.out.println("pivot: " + pivot);
            arr = quickSort(arr, left, pivot - 1);
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
            arr = quickSort(arr, pivot + 1, right);
            Arrays.stream(arr).forEach(System.out::print);
            System.out.println();
        }

        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while ( low < high ) {
            while ( low < high && pivot > arr[low] ) low++;
            while ( low < high && pivot < arr[high] ) high--;

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        arr[left] = arr[low];
        arr[low] = pivot;

        return left;
    }
}
