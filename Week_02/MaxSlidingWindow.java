class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //大顶堆，存储窗口数据
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2 - o1);
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            //如果堆大小超过k，删除由于滑动窗口丢弃的那个元素
            if(heap.size() == k){
                heap.remove(nums[i - k]);
            }
            heap.offer(nums[i]);
            //满足k个元素才返回最大值
            if(i >= k -1){
                res[j++] = heap.peek();
            }
        }
        return res;
    }
}