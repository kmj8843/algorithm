package com.rlalsa8843.utils;

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
    * 선택 정렬(Selection Sort)
    * 매 n번째 사이클마다 m > k > n + 1(m은 최대값) 중 최소값을 가지는 k와 n을 swap
    * 복잡도: O(n^2)
    * 총 비교횟수: n (n - 1) / 2
    *
    * @author  김민재
    * @version 1.0
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * */
    public static void selectionSort(int[] arr, int n) {
        for ( int i = 0; i < n - 1; i++ ) {
            int minIndex = i;

            for ( int j = i + 1; j < n; j++ )
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;

            CommonUtils.swap(arr, i, minIndex);
        }
    }

    /*
    * 버블 정렬(Bubble Sort)
    * 리스트를 순차적으로 탐색하며 인접한 두 개의 값을 비교
    * 복잡도: O(n^2)
    * 총 비교횟수: n (n - 1) / 2
    *
    * @author  김민재
    * @version 1.0
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * */
    public static void bubbleSort(int[] arr, int n) {
        for ( int i = n - 1; i > 0; i-- )
            for ( int j = 0; j < i; j++ )
                if ( arr[j] > arr[j + 1] )
                    CommonUtils.swap(arr, j, j + 1);

    }

    /*
    * 퀵 정렬(Quick Sort)
    * 분할 정복(Divide and Conquer) 알고리즘
    * 제자리 정렬(in-place sort) 이자 불안정정렬(Unstable Sort) 알고리즘
    *
    * 두 개의 부분리스트로 나누어 하나는 피벗보다 작은 값들의 부분리스트,
    * 다른 하나는 피벗보다 큰 값들의 부분리스트로 정렬한 다음,
    * 각 부분리스트에 대해 다시 위 처럼 재귀적으로 수행하여 정렬하는 방법
    * 
    * 임의의 값(이하 pivot)을 기준으로 왼쪽의 해당 값보다 큰 값, 오른쪽의 작은 값을 교환
    * 따라서, 왼쪽은 pivot 기준 작은 값, 오른쪽은 pivot 기준 큰 값으로 만듬(이 과정을 호어(Hoare) 방식 이라고 홤)
    * 왼쪽 값, 오른쪽 값을 기준으로 다시 pivot 을 선정하여 반복(이 과정을 파티셔닝(Partitioning) 이라고 함)
    *
    * 병합정렬(Merge Sort)과 다른 점은 병합정렬의 경우 하나의 리스트를 '절반' 으로 나누어 분할 정복을 하고,
    * 퀵 정렬(Quick Sort)의 경우 피벗(pivot)의 값에 따라 피벗보다 작은 값을 갖는 부분리스트와
    * 피벗보다 큰 값을 갖는 부분리스트의 크기가 다를 수 있기 때문에 하나의 리스트에 대해 비균등하게 나눔
    * 일반적으로 퀵 정렬이 더 빠름
    *
    * 복잡도: O(NlogN)
    *
    * 참고 https://st-lab.tistory.com/250
    *
    * @author  김민재
    * @version 1.0
    * @param   arr   정렬할 배열
    * @param   left  리스트의 첫번째 인덱스(초기 값 0)
    * @param   right 리스트의 마지막 인덱스(초기 값 arr.length - 1)
    * */
    public static void quickSort(int[] arr, int left, int right) {
        if ( left < right ) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = (left + right) / 2;
        int low = left;
        int high = right;

        while ( low < high ) {
            while ( low < right && arr[low] < arr[pivot] ) low++;
            while ( high > left && arr[high] >= arr[pivot] ) high--;

            if ( low < high )
                CommonUtils.swap(arr, low, high);
        }
        CommonUtils.swap(arr, left, high);

        return high;
    }
}
