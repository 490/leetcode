/**
 * created by zl on 2019/3/28 21:12
 */
public class simple_226_InvertBinaryTree
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left !=null)
            invertTree(root.left);
        if(root.right !=null)
            invertTree(root.right);
        return root;
    }
}
