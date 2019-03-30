import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * created by zl on 2019/3/29 8:03
 */
public class simple_257_BinaryTreePaths
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> list = new ArrayList<>();
        if(root == null)
            return list;
        StringBuilder sb = new StringBuilder();
        core(sb,root,list);
        return list;
    }
    private void core(StringBuilder sb , TreeNode root,List<String> list)
    {
        if(root == null)
            return ;
        if(sb.length() != 0)
        {
            sb.append("->");
            sb.append(root.val);
        }else
        {
            sb.append(root.val);
        }
        if(root.left == null && root.right == null)
        {
            list.add(sb.toString());
            return ;
        }
        StringBuilder newSb = new StringBuilder(sb.toString());//深拷贝代替回溯
        core(sb,root.left, list);
        core(newSb, root.right, list);

    }
}
