/**
 * 组合
 */
class Solution {

    public List<List<Integer>> combine(int n, int k) {
        return permute(1, n, k ,new LinkedList<>(), new ArrayList<>());
    }

    private List<List<Integer>> permute(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res){
        if(path.size() == k ){
            res.add(new ArrayList<>(path));
            return res;
        }

        for(int i = begin; i <= n - (k - path.size()) + 1; i++){
            path.addLast(i);
            permute(i+1, n, k, path, res);
            path.removeLast();
        }

        return res;
    }
}