import java.util.ArrayList;
import java.util.List;

/**
 * created by zl on 2019/4/28 13:03
 */
public class medium_95_UniqueBinarySearchTreesII
{
    private List<TreeNode> generateNodeList(int si, int ei)
    {
        List<TreeNode> res = new ArrayList<>();
        if (si > ei)
        {
            res.add(null);
            return res;
        }
        if (si == ei)
        {
            res.add(new TreeNode(si));
            return res;
        }
        for (int i = si; i <= ei; i++)
        {
            List<TreeNode> leftSubTrees = generateNodeList(si, i - 1);
            List<TreeNode> rightSubTrees = generateNodeList(i + 1, ei);
            for (TreeNode left : leftSubTrees)
            {
                for (TreeNode right : rightSubTrees)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        medium_95_UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new medium_95_UniqueBinarySearchTreesII();
        List<TreeNode> res = new ArrayList<>();
        res = uniqueBinarySearchTreesII.generateNodeList(1,4);

    }
}
