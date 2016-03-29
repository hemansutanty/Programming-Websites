/*

Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]

    Ordering the results in the answer :

    Entry i will come before Entry j if :

        len(Entryi[0]) < len(Entryj[0]) OR
        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
        *
        *
        *
        (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))

In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")


*/


//Solution

public class Solution {
    
    public boolean isPalindrome(String str){
        int left = 0, right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
            left++;right--;
        }
        return true;
    }
    public void addPalindrome(String a, int start, ArrayList<String> partition,ArrayList<ArrayList<String>> result ){
        if(start == a.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }
        for(int i=start+1;i<=a.length();i++){
            String str = a.substring(start,i);
            if(isPalindrome(str)){
                partition.add(str);
                addPalindrome(a,i,partition,result);
                partition.remove(partition.size()-1);
            }
        }
    }
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    if(a.length()==0||a==null){
	        return null;
	    }
	    ArrayList<String> partition = new ArrayList<String>();
	    addPalindrome(a,0,partition,result);
	    
	    return result;
	}
}
