/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

/*
Notes:
* If n<2
* if lines are parallel to vertically
* If lines are parralel horizontally
* Since slopw is dy/dx take care of division for larger numbers
*/

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int maxPoints(int[][] points) {
       int n = points.length;
        if (n < 2) return n;
        Set<String> set = new HashSet<>();
        int max = 1;
        
        for (int i = 0; i < n; i++) {
            if(set.contains(points[i][0]+ "-" + points[i][1])) continue;
            int[] a = points[i];
            int same = 0;
            Map<BigDecimal, Integer> map = new HashMap<>();
            int localMax = 1;

            for (int j = i + 1; j < n; j++) {
                if (isSame(a, points[j])) {
                    same++;
                    continue;
                }

                BigDecimal slope = getSlope(a, points[j]);
                System.out.println(a[0]+""+a[1]+"\t"+points[j][0]+""+points[j][1]+"\t"+slope);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
                localMax = Math.max(localMax, map.get(slope));
            }

            set.add(a[0] + "-" + a[1]);
            max = Math.max(max, localMax + same);
        }

        return max;
    }

    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private BigDecimal getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return BigDecimal.valueOf(Double.MAX_VALUE);
        if (a[1] == b[1]) return BigDecimal.valueOf(0);
        return BigDecimal.valueOf(b[1] - a[1]).divide(BigDecimal.valueOf(b[0] - a[0]), new MathContext(20)) ;
    }
}