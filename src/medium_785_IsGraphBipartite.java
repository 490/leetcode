import java.util.LinkedList;
import java.util.Queue;

/**
 * created by zl on 2019/5/14 21:26
 */
public class medium_785_IsGraphBipartite
{
    int[] color ;
    Queue<Integer> queue = new LinkedList<>();
    public boolean isBipartite(int[][] graph)
    {
        color = new int[graph.length];
        for (int i=0;i<graph.length;i++)
        {
            if (color[i]==0&&!bfs(i,graph))
            {
                return false;
            }
        }
        return true;
    }
    boolean bfs(int s,int[][] graph)
    {
        color[s] = 1;
        queue.add(s);//节点i
        while (!queue.isEmpty())
        {
            int from = queue.poll();
            for (int x:graph[from])
            {
                //如果相邻的点没有上色就给这个点上色
                if (color[x]==0)
                {
                    queue.add(x);
                    color[x] = -color[from];
                }
                //如果相邻的点颜色相同就返回false
                if (color[x]==color[from])
                {
                    return false;
                }
            }
        }
        //如果所有的点染过色，且相邻点点颜色都不一样,返回true
        return true;
    }
}
