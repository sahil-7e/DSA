class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int result = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            result = curr.val;

            if (curr.right != null) {
                queue.offer(curr.right);
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }

        return result;
    }
}