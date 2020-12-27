//前 K 个高频元素
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //map存数及其出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        //小顶堆，根节点是出现次数最小的数
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> map.get(o1) - map.get(o2));
        for(int key : map.keySet()){
            if(heap.size() < k){
                //先添加k个数到heap
                heap.offer(key);
            }else if(map.get(key) > map.get(heap.peek())){
                //如果有数的频次大于堆顶数的频次，删除堆顶的元素
                heap.poll();
                heap.offer(key);
            }
        }

        int[] res = new int[k];
        int j = 0;
        for(int num : heap){
            res[j++] = num;
        }

        return res;
    }
}