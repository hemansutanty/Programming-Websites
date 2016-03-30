/*

Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.


*/



//Solution

public class Solution {
	public String simplifyPath(String a) {
	    
	    
	    Stack<String> folderStack = new Stack<String>();
	    a.replaceAll("//","/");
	    String result="";
	    String[] dirs = a.split("/");
	    for(int i=0;i<dirs.length;i++){
	        if(!dirs[i].equals(".")&&!dirs[i].equals("..")&&!dirs[i].equals("")&&dirs[i]!=null){
	            folderStack.push(dirs[i]);
	        }
	        else if(!folderStack.isEmpty()&&dirs[i].equals("..")){
	            folderStack.pop();
	        }
	    }
	    while(!folderStack.isEmpty()){
	        if(!result.equals("")){
	            result= folderStack.pop()+"/"+result;
	        }
	        else{
	            result= folderStack.pop()+result;
	        }
	    }
	    result="/"+result;
        return result;
	}
}
