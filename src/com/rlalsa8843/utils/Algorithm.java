package com.rlalsa8843.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author  김민재
 * @version 1.0
 * */
public class Algorithm {
    private final static int[] gap =
            { 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 8858, 19930, 44842, 100894, 227011, 510774, 1149241,
                    2585792, 5818032, 13090572, 29453787, 66271020, 149109795, 335497038, 754868335, 1698453753};

    /**
    * 깊이 우선 탐색(Depth-First Search)<br/>
    * <br/>
    * 루트 노드(시작 노드)에서 다음 분기로 넘어가기 전에, 해당 분기를 모두 탐색<br/>
    * 탐색 후 다시 원점으로 돌아가 다른 분기 탐색<br/>
    * BFS 보다 느린 속도, 쉬운 구현<br/>
    *
    * @author  김민재
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

    /**
     * 너비 우선 탐색(Bread-First Search)<br/>
     * <br/>
     * 루트 노드(시작 노드)에서 인접한 노드를 먼저 탐색<br/>
     * 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용<br/>
     *
     * @author  김민재
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

    /**
    * 유클리드 호제법(Euclidean Algorithm) - 반복문<br/>
    * <br/>
    * 임의의 2개의 자연수 p와 q에서(단, p > q) p와 q를 나눈 나머지를 r 이라고 했을 때,
    * GCD(p, q) = GCD(q, r)과 같고, r이 0이면 b가 최대공약수임을 활용한 알고리즘
    *
    * @author  김민재
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

    /**
     * 유클리드 호제법(Euclidean Algorithm) - 재귀<br/>
     * <br/>
     * 임의의 2개의 자연수 p와 q에서(단, p > q) p와 q를 나눈 나머지를 r 이라고 했을 때,
     * GCD(p, q) = GCD(q, r)과 같고, r이 0이면 b가 최대공약수임을 활용한 알고리즘
     *
     * @author  김민재
     * @param   p 임의의 정수
     * @param   q 임의의 정수
     * @return  최대공약수
     * */
    public static int euclideanRecursion(int p, int q) {
        if ( q == 0 ) return p;
        return euclideanRecursion(q, p % q);
    }

    /**
    * 선택 정렬(Selection Sort)<br/>
    * <br/>
    * 매 n번째 사이클마다 m > k > n + 1(m은 최대값) 중 최소값을 가지는 k와 n을 swap<br/>
    * <br/>
    * 시간복잡도: O(n^2)<br/>
    * 총 비교횟수: n (n - 1) / 2<br/>
    *
    * @author  김민재
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

    /**
    * 버블 정렬(Bubble Sort)<br/>
    * <br/>
    * 리스트를 순차적으로 탐색하며 인접한 두 개의 값을 비교<br/>
    * <br/>
    * 시간복잡도: O(n^2)<br/>
    * 총 비교횟수: n (n - 1) / 2<br/>
    *
    * @author  김민재
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * */
    public static void bubbleSort(int[] arr, int n) {
        for ( int i = n - 1; i > 0; i-- )
            for ( int j = 0; j < i; j++ )
                if ( arr[j] > arr[j + 1] )
                    CommonUtils.swap(arr, j, j + 1);

    }

    /**
    * 삽입 정렬(Insertion Sort)<br/>
    * <br/>
    * 현재 비교하고자 하는 target 과 그 이전 원소를 비교하며 swap 하는 정렬 방법<br/>
    * 비교하면서 찾기 때문에 비교 정렬<br/>
    * 정렬 대상이 되는 데이터 외 추가적인 공간을 필요로 하지 않기 때문에 제자리 정렬(in-place sort)<br/>
    * 안정 정렬<br/>
    * <br/>
    * 시간복잡도<br/>
    * 최선(정렬된 경우)      : O(N)<br/>
    * 최악(역순에 가까울수록): O(N^2)<br/>
    * 시간복잡도가 O(N^2) 인 정렬 알고리즘 중에서 빠른 편<br/>
    *
    * @author  김민재
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * */
    public static void insertionSort(int[] arr, int n) {
        for ( int i = 1; i < n; i++ ) {
            int target = arr[i];
            int j = i;

            while ( j > 0 && target < arr[j - 1] ) arr[j] = arr[--j];

            arr[j] = target;
        }
    }

    /**
    * 퀵 정렬(Quick Sort)<br/>
    * <br/>
    * 분할 정복(Divide and Conquer) 알고리즘<br/>
    * 제자리 정렬(in-place sort) 이자 불안정정렬(Unstable Sort) 알고리즘<br/>
    * <br/>
    * 두 개의 부분리스트로 나누어 하나는 피벗보다 작은 값들의 부분리스트,
    * 다른 하나는 피벗보다 큰 값들의 부분리스트로 정렬한 다음,
    * 각 부분리스트에 대해 다시 위 처럼 재귀적으로 수행하여 정렬하는 방법<br/>
    * <br/>
    * 임의의 값(이하 pivot)을 기준으로 왼쪽의 해당 값보다 큰 값, 오른쪽의 작은 값을 교환
    * 따라서, 왼쪽은 pivot 기준 작은 값, 오른쪽은 pivot 기준 큰 값으로 만듬(이 과정을 호어(Hoare) 방식 이라고 홤)
    * 왼쪽 값, 오른쪽 값을 기준으로 다시 pivot 을 선정하여 반복(이 과정을 파티셔닝(Partitioning) 이라고 함)<br/>
    * <br/>
    * 병합정렬(Merge Sort)과 다른 점은 병합정렬의 경우 하나의 리스트를 '절반' 으로 나누어 분할 정복을 하고,
    * 퀵 정렬(Quick Sort)의 경우 피벗(pivot)의 값에 따라 피벗보다 작은 값을 갖는 부분리스트와
    * 피벗보다 큰 값을 갖는 부분리스트의 크기가 다를 수 있기 때문에 하나의 리스트에 대해 비균등하게 나눔<br/>
    * 일반적으로 퀵 정렬이 더 빠름<br/>
    * <br/>
    * 시간복잡도: O(NlogN)
    *
    * @author  김민재
    * @param   arr   정렬할 배열
    * @param   left  리스트의 첫번째 인덱스(초기 값 0)
    * @param   right 리스트의 마지막 인덱스(초기 값 arr.length - 1)
    * @see     <a href="https://st-lab.tistory.com/250">https://st-lab.tistory.com/250</a>
    * */
    public static void quickSort(int[] arr, int left, int right) {
        if ( left < right ) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }

    }

    /**
    * 퀵 정렬의 실질적인 정렬하는 부분<br/>
    * 파라미터의 left 와 right 사이의 부분 배열만 정렬<br/>
    * 
    * @author  김민재
    * @param   arr   정렬할 배열
    * @param   left  리스트의 첫번째 인덱스
    * @param   right 리스트의 마지막 인덱스
    * @return  pivot 다음 partition 에서 분기 처리될 기준
    * */
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

    /**
    * 셀 정렬(Shell Sort)<br/>
    * 역순에 가까울수록 최악의 시간복잡도를 가지는 삽입 정렬을 보완하기 위해
    * 일정한 간격(gap) 주기로 검사하여 대략적인 정렬을 하는 정렬<br/>
    * 비교 정렬, 제자리 정렬(in-place sort)<br/>
    * 일정 간격을 주기로 비교하기 때문에 안정 정렬은 아님<br/>
    * <br/>
    * 갭 선정 기준<br/>
    * 간격이 너무 적으면 속도가 느려지고, 너무 많으면 오버헤드가 발생<br/>
    * 해당 정렬은 A102549(Ciura Sequence) 사용(현재까지 중 가장 좋은 퍼포먼스를 가짐)<br/>
    * <br/>
    * 시간복잡도<br/>
    * 최선: O(NlogN)<br/>
    * 최악: O(N^2)<br/>
    *
    * @author  김민재
    * @param   arr 정렬할 배열
    * @param   n   배열의 크기
    * @see     <a href="en.wikipedia.org/wiki/Shellsort#Gap_sequences">갭 기준</a>
    * */
    public static void shellSort(int[] arr, int n) {
        int gapIndex = getGap(n);

        while( gapIndex >= 0 ) {
            int _gap = gap[gapIndex--];

            for ( int i = _gap; i < n; i++)
                for ( int j = i; j >= _gap && arr[j] < arr[j - _gap]; j -= _gap )
                    CommonUtils.swap(arr, j, j - _gap);
        }
    }

    /**
    * 셸 정렬의 기준이 되는 gap 을 구하는 함수<br/>
    *
    * @author  김민재
    * @param   n 정렬할 배열의 크기
    * @return  gap 인덱스
    * */
    private static int getGap(int n) {
        int index =  0;
        int length = (int) (n / 2.25);

        while ( gap[index] <= length ) { index++; }

        return index;
    }

}
