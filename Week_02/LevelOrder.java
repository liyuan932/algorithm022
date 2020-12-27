class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        loop(root, list, 0);
        return list;
    }

    private void loop(Node root, List<List<Integer>> list, Integer level){
        if(root == null){
            return;
        }
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);

        for(Node child : root.children){
            loop(child, list, level + 1);
        }
    }
}