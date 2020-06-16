import java.util.LinkedList;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution {
    class Graph{
        int vertices;
        List<Integer>[] adjList;
        public Graph(int v){
            this.vertices=v;
            adjList = new LinkedList[vertices];
            for(int i=0;i<vertices;i++){
                adjList[i]= new LinkedList<>();
            }
        }
    }
    public static void addEdge(Graph g, int u, int v) 
    { 
            g.adjList[u].add(v);  
    } 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0)return false;
        
        //Build graph
        Graph g = new Graph(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            addEdge(g,prerequisites[i][0], prerequisites[i][1]);
        }
        
        //Check if we can complete the courses
        int color[] = new int[g.vertices];
        for(int i=0;i<g.vertices;i++){
            color[i]=0;
        }
        for(int i =0;i<g.vertices;i++){
            if(color[i]==0){
                if(hasCycle(g,i,color)) return false;
            }
        }
        return true;
    }
    public boolean hasCycle(Graph g, int index, int[]color){
        color[index]=1;
        for(Integer child:g.adjList[index]){
            if(color[child]==1)return true;
            if(color[child]==0 && hasCycle(g, child, color))return true;
        }
        color[index]=2;
        return false;
    }
}