class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Iterative - O(h) time, O(1) space
        while (root != null) {
            // dono nodes root se chote hai -> left me jao
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // dono nodes root se bade hai -> right me jao
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // ek left ek right ya root ke barabar -> yehi LCA hai
            else {
                return root;
            }
        }
        return null;
    }
}

// Recursive version - agar chahiye to

class SolutionRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
