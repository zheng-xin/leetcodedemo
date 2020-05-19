package leetcode.demos;
 /* �����������������ڵ�Ĺ�������
* @author: zhengxinm
* @Description:
* @date: 2020��5��12�� ����3:11:06 
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
