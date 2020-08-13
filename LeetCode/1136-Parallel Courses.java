import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
There are N courses, labelled from 1 to N.

We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.

In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.

Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

 

Example 1:



Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: 
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
Example 2:



Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: 
No course can be studied because they depend on each other.
 

Note:

1 <= N <= 5000
1 <= relations.length <= 5000
relations[i][0] != relations[i][1]
There are no repeated relations in the input.
*/

class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for(int i=0;i<N;i++){
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        for(int[] relation: relations){
            int parent = relation[0]; int child = relation[1];
            graph.get(parent-1).add(child-1);
            inDegree.put(child-1, inDegree.get(child-1)+1);
        }
        Queue<Integer> queue = new LinkedList<>();
        int semester =0;
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()){
            if(entry.getValue()==0){
                queue.offer(entry.getKey());
            }
        }
        while(!queue.isEmpty()){
            semester++; int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                int c = queue.poll();
                N--;
                if (!graph.containsKey(c)) continue;
                List<Integer> courses = graph.get(c);
                graph.remove(c);
                for(int course: courses){
                    inDegree.put(course, inDegree.get(course)-1);
                    if(inDegree.get(course)==0){
                        queue.offer(course);
                    }
                }
            }
            
        }
        return N==0?semester:-1;
    }
}