package com.rlalsa8843.utils.algorithm;

import com.rlalsa8843.utils.CommonUtils;

import java.util.Arrays;

public class Sort {
    private final static int[] gap =
            { 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 8858, 19930, 44842, 100894, 227011, 510774, 1149241,
                    2585792, 5818032, 13090572, 29453787, 66271020, 149109795, 335497038, 754868335, 1698453753};

    /**
     * <p>선택 정렬(Selection Sort)
     *
     * <p>매 n번째 사이클마다 m &gt; k &gt; n + 1(m은 최대값) 중 최소값을 가지는 k와 n을 swap
     *
     * <p>시간복잡도: O(n^2)
     * <p>총 비교횟수: n (n - 1) / 2
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
     * <p>버블 정렬(Bubble Sort)
     *
     * <p>리스트를 순차적으로 탐색하며 인접한 두 개의 값을 비교
     *
     * <p>시간복잡도: O(n^2)
     * <p>총 비교횟수: n (n - 1) / 2
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
     * <p>삽입 정렬(Insertion Sort)
     * <p>
     * <p>현재 비교하고자 하는 target 과 그 이전 원소를 비교하며 swap 하는 정렬 방법
     * <p>비교하면서 찾기 때문에 비교 정렬
     * <p>정렬 대상이 되는 데이터 외 추가적인 공간을 필요로 하지 않기 때문에 제자리 정렬(in-place sort)
     * <p>안정 정렬
     *
     * <p>시간복잡도
     * <p>최선(정렬된 경우)      : O(N)
     * <p>최악(역순에 가까울수록): O(N^2)
     * <p>시간복잡도가 O(N^2) 인 정렬 알고리즘 중에서 빠른 편
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
     * <p>퀵 정렬(Quick Sort)
     *
     * <p>분할 정복(Divide and Conquer) 알고리즘
     * <p>제자리 정렬(in-place sort) 이자 불안정정렬(Unstable Sort) 알고리즘
     *
     * <p>두 개의 부분리스트로 나누어 하나는 피벗보다 작은 값들의 부분리스트,
     * 다른 하나는 피벗보다 큰 값들의 부분리스트로 정렬한 다음,
     * 각 부분리스트에 대해 다시 위 처럼 재귀적으로 수행하여 정렬하는 방법
     *
     * <p>임의의 값(이하 pivot)을 기준으로 왼쪽의 해당 값보다 큰 값, 오른쪽의 작은 값을 교환
     * 따라서, 왼쪽은 pivot 기준 작은 값, 오른쪽은 pivot 기준 큰 값으로 만듬(이 과정을 호어(Hoare) 방식 이라고 홤)
     * 왼쪽 값, 오른쪽 값을 기준으로 다시 pivot 을 선정하여 반복(이 과정을 파티셔닝(Partitioning) 이라고 함)
     *
     * <p>병합정렬(Merge Sort)과 다른 점은 병합정렬의 경우 하나의 리스트를 '절반' 으로 나누어 분할 정복을 하고,
     * 퀵 정렬(Quick Sort)의 경우 피벗(pivot)의 값에 따라 피벗보다 작은 값을 갖는 부분리스트와
     * 피벗보다 큰 값을 갖는 부분리스트의 크기가 다를 수 있기 때문에 하나의 리스트에 대해 비균등하게 나눔
     * <p>일반적으로 퀵 정렬이 더 빠름
     *
     * <p>시간복잡도: O(NlogN)
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
     * <p>퀵 정렬의 실질적인 정렬하는 부분
     * <p>파라미터의 left 와 right 사이의 부분 배열만 정렬
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
     * <p>셀 정렬(Shell Sort)
     *
     * <p>역순에 가까울수록 최악의 시간복잡도를 가지는 삽입 정렬을 보완하기 위해
     * 일정한 간격(gap) 주기로 검사하여 대략적인 정렬을 하는 정렬
     * <p>비교 정렬, 제자리 정렬(in-place sort)
     * <p>일정 간격을 주기로 비교하기 때문에 안정 정렬은 아님
     *
     * <p>갭 선정 기준
     * <p>간격이 너무 적으면 속도가 느려지고, 너무 많으면 오버헤드가 발생
     * <p>해당 정렬은 A102549(Ciura Sequence) 사용(현재까지 중 가장 좋은 퍼포먼스를 가짐)
     *
     * <p>시간복잡도
     * <p>최선: O(NlogN)
     * <p>최악: O(N^2)
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
     * <p>셸 정렬의 기준이 되는 gap 을 구하는 함수
     *
     * @author 김민재
     * @param   n 정렬할 배열의 크기
     * @return  gap 인덱스
     * */
    private static int getGap(int n) {
        int index =  0;
        int length = (int) (n / 2.25);

        while ( gap[index] <= length ) { index++; }

        return index;
    }

    /**
     * <p>힙 정렬(Heap Sort)
     *
     * <p>기본적으로 힙 자료구조를 기반으로 함
     * <p>힙 자료구조는 최소값 또는 최대값을 빠르게 찾아내기 위한 완전 이진트리 형태로 만드는 것
     * <p>부분 정렬을 할 때 효과가 좋지만, 일반적인 O(NlogN) 정렬 알고리즘에 비해 성능이 떨어짐
     *
     * <p>시간 복잡도: O(NlogN)
     *
     * @author 김민재
     * @param   arr 정렬할 배열
     * @param   n   배열의 크기
     * */
    public static void heapSort(int[] arr, int n) {
        if ( n < 2 ) return;

        for ( int i = getParentIndex(n - 1); i >= 0; i-- )
            heapify(arr, i, n - 1);

        for ( int i = n - 1; i > 0; i-- ) {
            CommonUtils.swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    /**
     * <p>힙 정렬에서 부모 노드 인덱스를 찾기 위해 사용
     * 
     * @author 김민재
     * @param  childIndex 자식 노드의 인덱스
     * @return 부모 노드 인덱스
     * */
    private static int getParentIndex(int childIndex) {
        return ( childIndex - 1 ) / 2;
    }

    /**
     * <p>힙 정렬에서 왼쪽 자식 노드의 인덱스를 찾기 위해 사용
     *
     * @author 김민재
     * @param  parentIndex 부모 노드의 인덱스
     * @return 부모 노드 인덱스
     * */
    private static int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    /**
     * <p>힙 정렬에서 오른쪽 자식 노드의 인덱스를 찾기 위해 사용
     *
     * @author 김민재
     * @param  parentIndex 부모 노드의 인덱스
     * @return 부모 노드 인덱스
     * */
    private static int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    /**
     * <p>힙 형태를 만들기 위해 사용
     * 
     * @author 김민재
     * @param  arr         힙 구조의 배열
     * @param  parentIndex 부모 노드의 인덱스
     * @param  lastIndex   마지막 노드의 인덱스
     * */
    private static void heapify(int[] arr, int parentIndex, int lastIndex) {
        int leftChildIndex;
        int rightChildIndex;
        int largestIndex;
        
        while ( (parentIndex * 2 + 1) <= lastIndex ) {
            leftChildIndex = getLeftChildIndex(parentIndex);
            rightChildIndex = getRightChildIndex((parentIndex));
            largestIndex = parentIndex;

            if ( arr[leftChildIndex] > arr[largestIndex] ) {
                largestIndex = leftChildIndex;
            }

            if ( rightChildIndex <= lastIndex && arr[rightChildIndex] > arr[largestIndex] ) {
                largestIndex = rightChildIndex;
            }

            if ( parentIndex != largestIndex ) {
                CommonUtils.swap(arr, parentIndex, largestIndex);
                parentIndex = largestIndex;
            } else return;
        }

    }

    /**
     * <p>계수 정렬(Counting Sort)
     *
     * <p>데이터 값의 개수만큼 차례대로 정렬
     * <p>메모리를 최대한 효율적으로 쓰기 위해 정렬할 배열의 원소 중 최대값을 구해야 함
     *
     * <p>시간복잡도: O(n)
     * <p>메모리 낭비가 심함(새로운 배열을 만들어야 하기 때문에)
     *
     * @author 김민재
     * @param  arr 정렬할 배열
     * @param  n   배열의 크기
     * @return 정렬된 배열
     * */
    public static int[] CountingSort(int[] arr, int n) {
        int max = Arrays.stream(arr)
                .max()
                .orElseThrow(NullPointerException::new);

        int[] countingArray = new int[max + 1];
        int[] result = new int[n];

        for ( int i = 0; i < n; i++ )
            countingArray[ arr[i] ] += 1;

        for ( int i = 1; i < max + 1; i++ )
            countingArray[i] += countingArray[i - 1];

        for ( int i = n - 1; i >= 0; i-- )
            result[ --countingArray[arr[i]] ] = arr[i];

        return result;
    }

}
