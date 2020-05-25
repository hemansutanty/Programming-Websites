/*
Given a string of balanced expression, find if it contains a redundant parenthesis or not. A set of parenthesis are redundant if same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes’ if redundant else ‘No’.

Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. Given expression is valid and there are no white spaces present.
Input: 
((a+b))
(a+(b)/c)
(a+b*(c-d))
Output: 
Yes
Yes
No

Explanation:
1. ((a+b)) can reduced to (a+b), this Redundant
2. (a+(b)/c) can reduced to (a+b/c) because b is
surrounded by () which is redundant.
3. (a+b*(c-d)) doesn't have any redundant or multiple
brackets.
*/
import java.util.Stack; 
public class GFG { 
// Function to check redundant brackets in a  
// balanced expression  
  
    static boolean checkRedundancy(String s) { 
        // create a stack of characters  
        Stack<Character> st = new Stack<>(); 
        char[] str = s.toCharArray(); 
        // Iterate through the given expression  
        for (char ch : str) { 
  
            // if current character is close parenthesis ')'  
            if (ch == ')') { 
                char top = st.peek(); 
                st.pop(); 
  
                // If immediate pop have open parenthesis '('  
                // duplicate brackets found  
                boolean flag = true; 
  
                while (top != '(') { 
  
                    // Check for operators in expression  
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') { 
                        flag = false; 
                    } 
  
                    // Fetch top element of stack  
                    top = st.peek(); 
                    st.pop(); 
                } 
  
                // If operators not found  
                if (flag == true) { 
                    return true; 
                } 
            } else { 
                st.push(ch); // push open parenthesis '(',  
            }                // operators and operands to stack  
        } 
        return false; 
    } 
  
// Function to check redundant brackets  
    static void findRedundant(String str) { 
        boolean ans = checkRedundancy(str); 
        if (ans == true) { 
            System.out.println("Yes"); 
        } else { 
            System.out.println("No"); 
        } 
    } 
  
// Driver code  
    public static void main(String[] args) { 
        String str = "((a+b))"; 
        findRedundant(str); 
  
        str = "(a+(b)/c)"; 
        findRedundant(str); 
  
        str = "(a+b*(c-d))"; 
        findRedundant(str); 
    } 
} 
