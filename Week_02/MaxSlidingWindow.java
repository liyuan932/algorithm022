class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> o2 - o1);
        int[] result = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (q.size() == k) {
                q.remove(nums[i - k]);
            }
            q.add(nums[i]);
            if (i >= k - 1) {
                result[j++] = q.peek();
            }
        }
        return result;
    }
}