import java.util.LinkedList;
import java.util.Queue;

/**
 * created by zl on 2019/8/6 16:10
 */
public class medium_279_PerfectSquares
{
    class Node
    {
        int val;
        int step;
        public Node(int val, int step)
        {
            this.val = val;
            this.step = step;
        }
    }
/*public int numSquares(int n)
{
    int[] dp=new int[n+1];
    int sqrt,min,count;
    for (int i=0;i<=n;i++)
    {
        // 小于4的数都只能由1构成
        if (i<4)
            dp[i] = i;
        else
        {
            min = Integer.MAX_VALUE;
            // 从开根号的树开始向下遍历，最小的count就是dp[i]的值
            for (sqrt = (int)Math.sqrt(i) ; sqrt >= 1 ; sqrt--)
            {
                count = 1 + dp[i-sqrt*sqrt];
                if (count < min)
                    min = count;
            }
            dp[i] = min;
        }
    }
    return dp[n];
}*/


        // 将问题转化成图论
        // 该算法在往队列里面添加节点的时候会 add 很多重复的节点，导致超时，
        // 优化办法是，加入 visited 数组，检查要 add 的数据是否已经出现过了，防止数据重复出现，从而影响图的遍历
        // 同时优化：num - i * i 表达式，只让他计算一次
        // 同时在循环体里面判断退出或返回的条件，而不是在循环体外
        public int numSquares(int n)
        {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(n, 0));
            // 其实一个真正的图的 BSF 是一定会加上 visited 数组来过滤元素的
            boolean[] visited = new boolean[n+1];
            while (!queue.isEmpty())
            {
                int num = queue.peek().val;
                int step = queue.peek().step;
                queue.remove();

                for (int i = 1; ; i++)
                {
                    int a = num - i * i;
                    if (a < 0)
                    {
                        break;
                    }
                    // 若 a 已经计算到 0 了，就不必再往下执行了
                    if (a == 0)
                    {
                        return step + 1;
                    }
                    if (!visited[a])
                    {
                        queue.add(new Node(a, step + 1));
                        visited[a] = true;
                    }
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        medium_279_PerfectSquares perfectSquares = new medium_279_PerfectSquares();
        perfectSquares.numSquares(13);
    }

}
