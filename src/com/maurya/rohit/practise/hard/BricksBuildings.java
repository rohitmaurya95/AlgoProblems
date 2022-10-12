package com.maurya.rohit.practise.hard;

import java.util.PriorityQueue;
import java.util.Stack;

public class BricksBuildings {
    // total = n*(log(n))^2
    public boolean howFarCanYouReach(int[] heights, int rops, int bricks) {
        int s = 0, e = heights.length - 1, ans = 0, m = 0;
        // binary search
        // log(n)
        while (s <= e) {
            m = s + (e-s)/2;
            boolean canReach = canReachBuldingK(heights, rops, bricks, m);
            if (canReach) s = m + 1;
            else e = m - 1;
            if (canReach) ans = Math.max(ans, m);
        }
        return ans==heights.length-1;
    }

    // n log(n)
    private boolean canReachBuldingK(int[] heights, int rops, int bricks, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> -1 * Integer.compare(i1, i2));
        for (int i = 1; i <= k; i++) {
            if (heights[i-1] < heights[i]) maxHeap.add(heights[i] - heights[i-1]);
        }

        // use greedy approach, use roap for max diff building, use bricks for rest
        while (!maxHeap.isEmpty()) {
            if (rops > 0) {
                maxHeap.poll();
                rops--;
                continue;
            }
            if (bricks > 0 && maxHeap.peek() <= bricks) {
                Integer removed = maxHeap.poll();
                bricks -= removed;
                continue;
            }
            return false;
        }
        return true;
    }


}
