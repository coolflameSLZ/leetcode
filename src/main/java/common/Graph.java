package common;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 无向图
 */
@Data
public class Graph {
    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adj[start].add(end);
        adj[end].add(start);
    }


    /**
     * 广度优先搜索
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {

        if (s == t) {
            return;
        }
        // 是用来记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        // 用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        // 用来记录搜索路径, 初始化为-1
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        // 初始化起点
        visited[s] = true;
        queue.add(s);

        // 开始搜索
        while (!queue.isEmpty()) {

            Integer curNode = queue.poll();
            LinkedList<Integer> curLinklist = adj[curNode];

            // 访问此节点的连通链表, 打印
            for (Integer linkedNode : curLinklist) {

                if (visited[linkedNode]) {
                    continue;
                }

                prev[linkedNode] = curNode;

                if (curNode == t) {
                    print(prev, s, t);
                    return;
                }

                visited[curNode] = true;
                queue.add(curNode);
            }
        }
    }

    private void print(int[] prev, int s, int t) {

        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}