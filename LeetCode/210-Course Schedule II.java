/*There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> orderedCourses = new ArrayList<>();
        if(numCourses == 0){
            return new int[0];
        }
        
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Initialize graph and indegree
        for(int i = 0;i<numCourses;i++){
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        //Build the graph and populate indegree of child
        for(int i = 0;i<prerequisites.length;i++){
            int parent = prerequisites[i][1], child = prerequisites[i][0];
            indegree.put(child, indegree.get(child)+1);
            graph.get(parent).add(child);
        }
        //Find all Sources and save in Queue
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : indegree.entrySet()){
            if(entry.getValue()==0){
                sources.add(entry.getKey());
            }
        }
        //Find the ordering
        while(!sources.isEmpty()){
            int source = sources.poll();
            orderedCourses.add(source);
            List<Integer> children = graph.get(source);
            for(int child: children){
                indegree.put(child, indegree.get(child)-1);
                if(indegree.get(child)==0){
                    sources.add(child);
                }
            }
        }
        
        if(orderedCourses.size()!=numCourses){
            return new int[0];
        }
        int []result = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            result[i]=orderedCourses.get(i);
        }
        return result;
        
    }
}