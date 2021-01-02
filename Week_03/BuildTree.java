/**
 * 从前序与中序遍历序列构造二叉树
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder,int p_start,int p_end,int[] inorder, int i_start, int i_end){
        if(p_start >= p_end){
            return null;
        }
        //构建root节点，前序遍历的第1个元素就是root节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //找到root节点在中序遍历中的位置
        int i_root_index = 0;
        for(int i = i_start; i < i_end; i++) {
            if(inorder[i] == root_val){
                i_root_index = i;
                break;
            }
        }
        //计算左节点的数量
        int left_num = i_root_index - i_start;
        //递归构建left节点和right节点
        root.left = build(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_root_index);
        root.right = build(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end);

        return root;

    }
}