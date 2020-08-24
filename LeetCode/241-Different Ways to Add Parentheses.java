import java.util.ArrayList;
import java.util.List;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/


class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(ch=='+' || ch=='*' || ch=='-'){
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);
                List<Integer> part1Result = diffWaysToCompute(part1);
                List<Integer> part2Result = diffWaysToCompute(part2);
                for(Integer p1: part1Result){
                    for(Integer p2: part2Result){
                        int c = 0;
                        switch(ch){
                            case '+': c=p1+p2;break;
                            case '-': c=p1-p2;break;
                            case '*': c=p1*p2;break;
                        }
                        result.add(c);
                    }
                }
            }
            
        }
        if(result.size()==0){
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}