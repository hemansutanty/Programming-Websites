/*

Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    }     
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.


*/



//Solution

public class Solution {
	public ArrayList<String> prettyJSON(String a) {
	    
	ArrayList<String> result= new ArrayList<String>();
    String temp="";
    int countIndent=0,i,j;
    for(i=0;i<a.length();i++){
        
        if(a.substring(i,i+1).equals("[")||a.substring(i,i+1).equals("{")){
            
            for(j=0;j<countIndent;j++){
                temp="\t"+temp;
            }
            if(i!=0 && temp.length()>0)
            result.add(temp);
            temp="";
            
            for(j=0;j<countIndent;j++){
                temp="\t"+temp;
            }
            temp=temp+a.substring(i,i+1);
            result.add(temp);
            temp="";
            countIndent++;
        }
        else if(a.substring(i,i+1).equals(",")){
            for(j=0;j<countIndent;j++){
                temp="\t"+temp;
            }
            temp=temp+",";
            result.add(temp);
            temp="";
        }
        else if(a.substring(i,i+1).equals("]")||a.substring(i,i+1).equals("}")){
            
            for(j=0;j<countIndent;j++){
                temp="\t"+temp;
            }
            if(temp.length()>0)
            result.add(temp);
            temp="";
            countIndent--;
            
            for(j=0;j<countIndent;j++){
                temp="\t"+temp;
            }
            temp=temp+a.substring(i,i+1);
            while(i+1<a.length()&&a.substring(i+1,i+2).equals(",")){
               temp=temp+a.substring(i+1,i+2);
               i++;
            }
            result.add(temp);
            temp="";
        }
        else{
            temp=temp+a.substring(i,i+1);
        }
    }
    for(i=0;i<result.size();i++){
        if(result.get(i).matches("\\s+")){
            result.remove(result.get(i));
        }
    }
    return result;
	}
}