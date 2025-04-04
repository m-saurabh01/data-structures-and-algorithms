package Arrays;


/*
 * 		1123. Lowest Common Ancestor of Deepest Leaves
*/
public class LowestCommonAncestorDeepestLeaves {
	
	
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	     TreeNode right;
	      TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	        this.right = right;
	   }
	  }
	
	
	public TreeNode lcaDeepestLeaves(TreeNode root) {
	    return dfs(root).lca;
	  }

	  private record T(TreeNode lca, int depth) {}

	  private T dfs(TreeNode root) {
	    if (root == null)
	      return new T(null, 0);
	    T left = dfs(root.left);
	    T right = dfs(root.right);
	    if (left.depth > right.depth)
	      return new T(left.lca, left.depth + 1);
	    if (left.depth < right.depth)
	      return new T(right.lca, right.depth + 1);
	    return new T(root, left.depth + 1);
	  }

}
