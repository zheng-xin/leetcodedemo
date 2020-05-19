package leetcode.demos;
 /* 找连个二叉树两个节点的公共祖先
* @author: zhengxinm
* @Description:
* @date: 2020年5月12日 下午3:11:06 
* @version: nccnative
 */
public class Demo07 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(root == null || root == p || root == q) return root;
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        if(left == null) return right;
	        if(right == null) return left;
	        return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
