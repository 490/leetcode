import java.util.ArrayList;
import java.util.List;

/**
 * created by zl on 2019/5/16 12:46
 */
public class hard_51_NQueens
{
    public List<List<String>> solveNQueens(int n)
    {
        boolean[] column = new boolean[n];
        boolean[] left = new boolean[2*n];
        boolean[] right = new boolean[2*n];
        int[] queen = new int[n];
        List<List<String>> result = new ArrayList<>();
        backtrace(result, 0, n, column, left, right, queen);
        return result;
    }

    public void backtrace(List<List<String>> result,
                          int deep, int n,
                          boolean[] column, boolean[] left, boolean[] right,
                          int[] queen)
    {
        if(deep == n)
        {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < n;j++)
                {
                    if(j == queen[i])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int i = 0;i < n; i++)
        {
            //left向左下方的斜线，row+col值始终相同，right向右下方，row-col值始终相同
            if(column[i] || left[deep + i] || right[n-1+deep-i])
                continue;
            queen[deep] =i;
            column[i] = left[deep + i] = right[n-1+deep-i] = true;
            backtrace(result, deep+1, n, column, left, right, queen);
            column[i] = left[deep + i] = right[n-1+deep-i] = false;
        }
    }

    public static void main(String[] args) {
        hard_51_NQueens nQueens = new hard_51_NQueens();
        nQueens.solveNQueens(4);
    }
}
