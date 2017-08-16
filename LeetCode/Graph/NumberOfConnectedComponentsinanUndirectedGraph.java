Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

    0          3
    |          |
    1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

    0           4
    |           |
    1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
分析
典型且很基础的union find题。用一个数组记录各个数字的父节点，然后遍历图，对edge中两个端点做union。最后扫一遍数组，找到根节点个数即可。

time:
time: O(m*h), space: O(n), m表示edge的数量。

代码

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] id = new int[n];
        
        // 初始化
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        // union
        for (int[] edge : edges) {              
            int i = root(id, edge[0]);
            int j = root(id, edge[1]);
            id[i] = j;
        }
        
        // 统计根节点个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (id[i] == i)
                count++;
        }
        return count;
    }
    
    // 找根节点
    public int root(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}


// using dfs
// number of connected componet
public int numberOfCC(int n, int[][] edges) {
  if (n <= 1) return n;
  int cnt = 0;
  boolean[] visited = new visited[n];
  Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
  //建图
  for (int[] edge : edges) {
    int cur = edge[0];
    int other = edge[1];
    if (!adjList.containsKey(cur)) {
      adjList.put(cur, new ArrayList<Integer>());  
    }
    if (!adjList.containsKey(other)) {
      adjList.put(other, new ArrayList<Integer>());  
    } 
    adjList.get(cur).add(other);
    adjList.get(other).add(cur);
  }
//   深搜，来计算count
  for (int i = 0; i < n; i++) {
    if (!visited[i]) {
      dfs(adjList, i, visited);
      cnt++;
    }
  }
  return cnt;
}

private void dfs(Map<Integer, List<Integer>> adjList, int v, boolean[] visited) {
  for (int nabor : adjList.get(v)) {
    if (!visited[nabor]) {
      dfs(adjList, nabor, visited);  
    }
  }
  visited[v] = true;
}

     