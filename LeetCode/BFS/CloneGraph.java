Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization: Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node. As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
哈希表法
复杂度
时间 O(N) 空间 O(N)

思路
广度优先搜索，同时用一个哈希表，将新旧节点映射起来。这样我们第一次遍历到的节点，我们会新建一个节点并映射到哈希表中。当以后再遍历到这个节点时，我们可以直接用哈希表取出它对应的新节点。我们只要保证，对于第一次遇到的图节点，我们都会建立一个克隆节点，并在哈希表映射起来就行了。

注意
这里我们并不需要维护一个visited的集合，为什么呢？因为每次我们遇到一个之前没见过图节点，我们都会给它建立一个克隆节点，然后在哈希表中映射起来，并把这个图节点也放入队列中。所以只要哈希表中有这个图节点，就说明我们之前已经将该图节点放入队列了，就不需要再处理了。不过还是要把该图节点的克隆节点放入父克隆节点的邻居中。

代码
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode curr = q.poll();
            // 将curr旧节点的邻居节点都加入curr的新节点
            for(UndirectedGraphNode oldNeighbor : curr.neighbors){
                // 判断是否已经生成过该邻居节点的新节点
                if(!map.containsKey(oldNeighbor)){
                    // 如果是第一次生成该新节点，将其加入队列中
                    map.put(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                    q.offer(oldNeighbor);
                }
                // 将新邻居加入新curr节点的neighbors中
                map.get(curr).neighbors.add(map.get(oldNeighbor));
            }
        }
        return root;
    }
}