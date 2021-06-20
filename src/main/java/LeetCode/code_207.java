package LeetCode;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//        在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//        例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class code_207 {

    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        
        for (int[] cp : prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre))
                if (--indegrees[cur] == 0)
                    queue.add(cur);
        }
        return numCourses == 0;
    }

    //DFS
    public boolean canFinish_1(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);

        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacency,flags,i) == false)
                return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i){
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1)
            return true;
        flags[i] = 1;
        for (int j : adjacency.get(i))
            if (dfs(adjacency,flags,j) == false)
                return false;
        flags[i] = -1;
        return true;
    }
}
