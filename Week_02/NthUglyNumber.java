//丑数
class Solution {
    //用小顶堆存生成的丑数（需去重），弹出的第n个数即为第n个丑数
    public int nthUglyNumber(int n) {
        long[] primes  = new long[]{2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);

        long res = 1L;
        for(int i = 1; i <= n; i++){
            res = heap.poll();
            for(long p : primes){
                long num = res * p;
                if(!set.contains(num)){
                    heap.offer(num);
                    set.add(num);
                }
            }
        }

        return (int)res;
    }
}