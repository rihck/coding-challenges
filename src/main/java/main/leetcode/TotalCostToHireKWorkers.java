package main.leetcode;

import java.util.PriorityQueue;

/** You're supposed to traverse first 'candidate' number of the array(elements from the beginning) and last 'candidate' number of elements from the ending of the array. Find the minimum element in it and then remove that element from the list. This minimum element you found is the cost of one worker. Now, repeat this process k times since we wanna hire k workers exactly.

        Ex: [3, ,5,1 2, 4, 1, 8, 2] and candidate = 2
        -> Two elements from the beginning = 3, 5
        -> Two elements at the end = 8, 2
        Minimum element among 3, 5, 8, 2 is 2. That's the cost of one worker. Now that you have hired one worker, remove 2 from the array. Now, array will look like
        [3, 5, 1, 2, 4, 1, 8]
        Repeat the process K times.

        if ever you find two elements with the same value, you need to remove the element with the smallest index in the array. (In the above examples, there are two 1's in the array. When you encounter them, choose the one with the smallest index)
* /
/** https://leetcode.com/problems/total-cost-to-hire-k-workers/description/ **/
public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        // The worker with the lowest cost has the highest priority, if two players has the
        // same cost, break the tie by their indices (0 or 1).
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // Debug and understand
            }
            return a[0] - b[0];}); // Debug and understand

        // Add the first k workers with section id of 0 and
        // the last k workers with section id of 1 (without duplication) to pq.
        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[] {costs[i], 0});
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            pq.offer(new int[] {costs[i], 1});
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            int[] curWorker = pq.poll();
            int curCost = curWorker[0], curSectionId = curWorker[1];
            answer += curCost;

            // Only refill pq if there are workers outside.
            if (nextHead <= nextTail) {
                if (curSectionId == 0) {
                    pq.offer(new int[]{costs[nextHead], 0});
                    nextHead++;
                } else {
                    pq.offer(new int[]{costs[nextTail], 1});
                    nextTail--;
                }
            }
        }

        return answer;
    }

    /** Other one to study
     *     public long totalCost(int[] costs, int k, int candidates) {
     *         int i = 0;
     *         int j = costs.length - 1;
     *         PriorityQueue<Integer> pq1 = new PriorityQueue<>();
     *         PriorityQueue<Integer> pq2 = new PriorityQueue<>();
     *
     *         long ans = 0;
     *         while (k-- > 0) {
     *             while (pq1.size() < candidates && i <= j) {
     *                 pq1.offer(costs[i++]);
     *             }
     *             while (pq2.size() < candidates && i <= j) {
     *                 pq2.offer(costs[j--]);
     *             }
     *
     *             int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
     *             int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
     *
     *             if (t1 <= t2) {
     *                 ans += t1;
     *                 pq1.poll();
     *             } else {
     *                 ans += t2;
     *                 pq2.poll();
     *             }
     *         }
     *         return ans;
     *
     *         // candidate = 2
     *         // [3,,5, 1, 2, 4, 1, 8, 2]
     *         // [3, 5, 8, 2]
     *
     *     }
     *
     */
}
