import java.util.ArrayList;
import java.util.List;

/*
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.

 

Example 1:



Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:



Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

*/

class Solution {
    public int minReorder(int n, int[][] connections) {
       
        List<List<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++){
            al.add(i, new ArrayList<>());
        }
        for(int[] conn: connections){
            al.get(conn[0]).add(conn[1]);
            al.get(conn[1]).add(-conn[0]);
        }
        return dfs(al, new boolean[n], 0);
    }
    public int dfs(List<List<Integer>> al, boolean[] visited, int from){
        int change = 0;
        visited[from] = true;
        for(int to : al.get(from)){
            if(!visited[Math.abs(to)]){
                change += dfs(al, visited, Math.abs(to))+ (to>0?1:0);
            }
        }
        return change;
    }
}