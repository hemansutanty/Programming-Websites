import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.

Grammar can best be understood through simple examples:

Single letters represent a singleton set containing that word.
R("a") = {"a"}
R("w") = {"w"}
When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
R("{a,b,c}") = {"a","b","c"}
R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
Formally, the 3 rules for our grammar:

For every lowercase letter x, we have R(x) = {x}
For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.

 

Example 1:

Input: "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]
Example 2:

Input: "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
Explanation: Each distinct word is written only once in the final answer.
 

Constraints:

1 <= expression.length <= 60
expression[i] consists of '{', '}', ','or lowercase English letters.
The given expression represents a set of words based on the grammar given in the description.
*/

/* Notes :
solved using Stack
 > Stack,
-> Precomma Array
-> Currentarrau


-> "{" -- Push Precomma and Current To stack and Reset Precomma and Current
-> Letter -- Put in current Array
-> , -- concat Current To Precomma and Reset Current
-> } -- Pop two items from stack Call first as Pre Current, 
Call 2nd one as Pre Before Comma Combine Pre Current with concat of current and PRecomma and Put the combination in curren. 
Also point PreComma to PreBefore Comma
*/

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<List<String>> stack = new Stack<>();
        List<String> current = new ArrayList<>(), preComma = new ArrayList<>(), preCurrent = new ArrayList<>(), preBeforeComma = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch>='a' && ch<='z'){
                if(current.size()>0){
                    for(int k=0;k<current.size();k++){
                        current.set(k, current.get(k)+ch+"");
                    }
                }else{
                    current.add(ch+"");
                }       
            }else if(ch=='{'){
                stack.push(preComma); stack.push(current);
                preComma = new ArrayList<>(); current=new ArrayList<>();
            }else if(ch==','){
                preComma.addAll(current);
                current = new ArrayList<>();
            }else if (ch=='}'){
                preCurrent = stack.pop();
                preBeforeComma = stack.pop();
                List<String> temp = new ArrayList<>();
                temp.addAll(current); temp.addAll(preComma);
                List<String> combination = combine(preCurrent, temp);
                current = combination;
                preComma = preBeforeComma;
            }
        }
        preComma.addAll(current);
        List<String> result  = new ArrayList<>();
        for(int i=0;i<preComma.size();i++){
            if(!result.contains(preComma.get(i))){
                result.add(preComma.get(i));
            }
        }
        Collections.sort(result);
        return result;
    }
    
    public List<String> combine (List<String> list1, List<String> list2){
        List<String> result  = new ArrayList<>();
        if (list1 == null || list1.size()==0) return list2;
        else if (list2 == null || list2.size()==0) return list1;
        for(int i=0;i< list1.size();i++){
            for(int j = 0;j< list2.size();j++){
                result.add(list1.get(i)+list2.get(j));
            }
        }
        return result;
    }
}