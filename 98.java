class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        // current node must be > min and < max
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        // left subtree -> max becomes node.val
        // right subtree -> min becomes node.val
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}

// Alternative - Inorder Traversal Approach (also accepted)

class SolutionInorder {
    private long prev = Long.MIN_VALUE;
    private boolean first = true;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!isValidBST(root.left)) return false;
        
        if (!first && root.val <= prev) return false;
        first = false;
        prev = root.val;
        
        return isValidBST(root.right);
    }
}
