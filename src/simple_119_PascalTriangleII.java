import java.util.ArrayList;
import java.util.List;

/**
 * created by zl on 2019/3/28 9:11
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class simple_119_PascalTriangleII
{
    public List<Integer> getRow(int numRows)
    {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0;i<=numRows;i++)
        {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j = 0;j<i+1;j++)
            {
                if(j==0||j==i)
                {
                    row.add(1);
                }
                else
                {
                    row.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
            }
            lists.add(row);
        }
        return lists.get(numRows);
    }
}

