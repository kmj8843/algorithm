package com.rlalsa8843.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author  김민재
 * @version 1.0
 * */
public class Algorithm {
    /**
    * 깊이 우선 탐색(Depth-First Search)<br>
    * <br>
    * 루트 노드(시작 노드)에서 다음 분기로 넘어가기 전에, 해당 분기를 모두 탐색<br>
    * 탐색 후 다시 원점으로 돌아가 다른 분기 탐색<br>
    * BFS 보다 느린 속도, 쉬운 구현<br>
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
     * 너비 우선 탐색(Bread-First Search)<br>
     * <br>
     * 루트 노드(시작 노드)에서 인접한 노드를 먼저 탐색<br>
     * 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 사용<br>
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
    * 유클리드 호제법(Euclidean Algorithm) - 반복문<br>
    * <br>
    * 임의의 2개의 자연수 p와 q에서(단, p &gt; q) p와 q를 나눈 나머지를 r 이라고 했을 때,
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
     * 유클리드 호제법(Euclidean Algorithm) - 재귀<br>
     * <br>
     * 임의의 2개의 자연수 p와 q에서(단, p &gt; q) p와 q를 나눈 나머지를 r 이라고 했을 때,
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

}
