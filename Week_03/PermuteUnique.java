/**
 * 全排列II
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(0, nums ,new LinkedList<>(), new boolean[nums.length], new ArrayList<>());
    }

    private List<List<Integer>> permute(int level, int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> res){
        if(level == nums.length ){
            res.add(new ArrayList<>(path));
            return res;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                if(i >0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

                path.addLast(nums[i]);
                used[i] = true;
                permute(level + 1, nums, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }

        return res;
    }
}