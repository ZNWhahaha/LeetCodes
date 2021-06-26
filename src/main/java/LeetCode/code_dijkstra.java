package LeetCode;

public class code_dijkstra {
//    算法的基本思想是：
//    每次找到离源点（上面例子的源点就是 1 号顶点）最近的一个顶点，然后以该顶点为中心进行扩展，最终得到源点到其余所有点的最短路径。基本步骤如下：
//    1.将所有的顶点分为两部分：已知最短路程的顶点集合 P 和未知最短路径的顶点集合 Q。最开始，已知最短路径的顶点集合 P 中只有源点一个顶点。我们这里用一个 book[ i ]数组来记录哪些点在集合 P 中。例如对于某个顶点 i，如果 book[ i ]为 1 则表示这个顶点在集合 P 中，如果 book[ i ]为 0 则表示这个顶点在集合 Q 中。
//    2.设置源点 s 到自己的最短路径为 0 即 dis=0。若存在源点有能直接到达的顶点 i，则把 dis[ i ]设为 e[s][ i ]。同时把所有其它（源点不能直接到达的）顶点的最短路径为设为 ∞。
//    3.在集合 Q 的所有顶点中选择一个离源点 s 最近的顶点 u（即 dis[u]最小）加入到集合 P。并考察所有以点 u 为起点的边，对每一条边进行松弛操作。例如存在一条从 u 到 v 的边，那么可以通过将边 u->v 添加到尾部来拓展一条从 s 到 v 的路径，这条路径的长度是 dis[u]+e[u][v]。如果这个值比目前已知的 dis[v]的值要小，我们可以用新值来替代当前 dis[v]中的值。
//    4.重复第 3 步，如果集合 Q 为空，算法结束。最终 dis 数组中的值就是源点到所有顶点的最短路径。

    private int[] dijkstra(int[][] map){
        int[] dis = new int[map.length];
        int[] book = new int[map.length];
        int min;
        int tmpIndex = 0;
        // 初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
        for (int i = 0; i < dis.length; i++) {
            dis[i] = map[1][i];
        }
        // book数组初始化
        book[0] = 1;

        //Dijkstra算法核心
        for (int i = 0; i < map.length-1; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < map.length; j++) {
                if (book[j] == 0 && dis[j] < min){
                    min = dis[j];
                    tmpIndex = j;
                }
            }
            book[tmpIndex] = 1;
            for (int h = 0; h < map.length; h++) {
                if (map[tmpIndex][h] < Integer.MAX_VALUE && dis[h] > dis[tmpIndex]+map[tmpIndex][h])
                    dis[h] = dis[tmpIndex]+map[tmpIndex][h];
            }
        }
        return dis;
    }
}
