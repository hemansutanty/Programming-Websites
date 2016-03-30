/*

Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.


*/

//Solution

public class Solution {
    
    public String add(String a, String b){
        if(a.equals("0") && b.equals("0"))
        return "0";
        else if((a.equals("0") && b.equals("1"))||(a.equals("1") && b.equals("0")))
        return "1";
        else 
        return "10";
    }
	public String addBinary(String first, String second) {
	    
	    String carry="0",temp="",result="";
        int lenA = first.length(),lenB=second.length();
        while(lenA>0 && lenB>0){
            temp = add(carry,String.valueOf(first.charAt(lenA-1)));
            if(temp.equals("10")){
                temp ="0";carry ="1";
            }
            else
                carry="0";
            temp = add(temp,String.valueOf(second.charAt(lenB-1)));
            if(temp.equals("10")){
                temp ="0";carry ="1";
            }
            result = temp + result;
            lenA--;lenB--;
        }
	    while(lenA>0){
	        temp = add(String.valueOf(first.charAt(lenA-1)),carry);
	        if(temp.equals("10"))
	        {temp = "0";carry = "1";}
	        else
	        carry ="0";
	        result = temp+result;
	        lenA--;
	    }
	    while(lenB>0){
	        temp = add(String.valueOf(second.charAt(lenB-1)),carry);
	        if(temp.equals("10"))
	        {temp = "0";carry = "1";}
	        else
	        carry = "0";
	        result = temp+result;
	        lenB--;
	    }
	    if(carry.equals("1")){
	        result = carry+result;
	    }
	    return result;
	    
	}
}