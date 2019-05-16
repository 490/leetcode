import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by zl on 2019/5/11 10:38
 */
public class medium_133_clonegraph
{
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
    public Node cloneGraph(Node node)
    {
        Map<Integer,Node> map = new HashMap();
        Node n = new Node(node.val, null);
        map.put(node.val,n);
        n.neighbors = copy(node, map);
        return n;
    }

    private List<Node> copy(Node node,Map<Integer,Node> map)
    {
        List<Node> list = new ArrayList<>();
        for(Node n : node.neighbors)
        {
            if(map.containsKey(n.val))
            {//判断该节点是否已经创建了
                list.add(map.get(n.val));
            }else
            {
                Node nn = new Node(n.val, null);//节点未创建，创建并拷贝nei***ors
                list.add(nn);
                map.put(n.val, nn);
                nn.neighbors = copy(n, map);
            }
        }
        return list;
    }

}
