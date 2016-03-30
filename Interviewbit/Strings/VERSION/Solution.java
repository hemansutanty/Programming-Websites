/*

Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

*/


//solution

import java.math.BigInteger;
public class Solution {
	public int compareVersion(String a, String b) {
	    
	    String firstArr[] = a.split("[.]");
	    String secondArr[] = b.split("[.]");
	    int min = firstArr.length<secondArr.length?firstArr.length:secondArr.length;
	    BigInteger b1,b2,b3=BigInteger.ZERO;
	    for(int i=0;i<min;i++){
	        b1=new BigInteger(firstArr[i]);
	        b2=new BigInteger(secondArr[i]);
	        if(b1.compareTo(b2)>0){
	            return 1;
	        }
	        else if(b1.compareTo(b2)<0){
	            return -1;
	        }
	    }
	    if(firstArr.length==secondArr.length){
	        return 0;
	    }
	    else if(firstArr.length>secondArr.length){
	        int j = min;
	        while(j<firstArr.length){
	            b1 = new BigInteger(firstArr[min]);
	            if(b1.compareTo(b3)!=0){
	                return 1;
	            }
	            j++;
	        }
	        return 0;
	    }
	    else if(firstArr.length<secondArr.length){
	        int j = min;
	        while(j<secondArr.length){
	            b1 = new BigInteger(secondArr[min]);
	            if(b1.compareTo(b3)!=0){
	                return -1;
	            }
	            j++;
	        }
	        return 0;
	    }
	    return firstArr.length>secondArr.length?1:-1;
	}
}
