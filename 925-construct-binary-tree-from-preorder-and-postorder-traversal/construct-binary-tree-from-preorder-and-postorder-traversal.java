class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int ps, int pe,
                           int[] post, int qs, int qe) {
        if (ps > pe) {
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);

        if (ps == pe) {
            return root;
        }

        int i = qs;

        while (post[i] != pre[ps + 1]) {
            i++;
        }

        int leftSize = i - qs + 1;

        root.left = build(pre, ps + 1, ps + leftSize,
                          post, qs, i);

        root.right = build(pre, ps + leftSize + 1, pe,
                           post, i + 1, qe - 1);

        return root;
    }
}