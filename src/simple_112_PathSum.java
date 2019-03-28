/**
 * created by zl on 2019/3/28 8:36
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class simple_112_PathSum
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
        {
            return false;
        }
        if (root.left == null && root.right == null)
        {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);

    }
}
