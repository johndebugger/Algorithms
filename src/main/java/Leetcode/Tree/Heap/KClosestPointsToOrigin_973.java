package Leetcode.Tree.Heap;

import java.util.Arrays;

public class KClosestPointsToOrigin_973 {

    // Priority Queue - Nlog(k), 54ms
//    public int[][] kClosest(int[][] points, int K) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]));
//        int[][] res = new int[K][2];
//        for (int[] p: points) {
//            pq.offer(p);
//        }
//        for (int i = 0; i < K; i++) {
//            res[i] = pq.poll();
//        }
//        return res;
//    }

    // Quick select - implementation like quick sort
    public int[][] kClosest(int[][] points, int K) {
        quickselect(points, K, 0, points.length-1);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickselect(int[][] points, int K, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(points, lo, hi);
            if (mid < K) {
                quickselect(points, K, mid+1, hi);
            } else if (mid > K) {
                quickselect(points, K, lo, mid-1);
            }
        }
    }

    public int partition(int[][] points, int lo, int hi) {
        int[] pivot = points[lo];
        while (lo < hi) {
            while (lo < hi && dis(points[hi]) > dis(pivot)) hi--;
            points[lo] = points[hi];
            while (lo < hi && dis(points[lo]) <= dis(pivot)) lo++;
            points[hi] = points[lo];
        }
        points[lo] = pivot;
        return lo;
    }

    public int dis(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }


    // Quick select, another implementation
//    public int[][] kClosest(int[][] points, int K) {
//        int lo = 0, hi = points.length-1, mid = -1;
//        while (mid != K-1) {
//            mid = partition(points, lo, hi);
//            if (mid < K) {
//                lo = mid + 1;
//            } else {
//                hi = mid - 1;
//            }
//        }
//        return Arrays.copyOfRange(points, 0, K);
//    }
//
//    public int partition(int[][] points, int lo, int hi) {
//        int[] pivot = points[lo];
//        while (lo < hi) {
//            while (lo < hi && dist(points[hi]) >= dist(pivot))
//                hi --;
//            points[lo] = points[hi];
//            while (lo < hi && dist(points[lo]) < dist(pivot))
//                lo ++;
//            points[hi] = points[lo];
//        }
//        points[lo] = pivot;
//        return lo;
//    }
//
//    public int dist(int[] p) {
//        return p[0] * p[0] + p[1] * p[1];
//    }
}
