import java.util.HashMap;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
*/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder result = new StringBuilder();
        if(numerator<0 && denominator>0 || numerator>0 && denominator <0) result.append("-");
        long num = Math.abs((long)numerator), den=Math.abs((long)denominator);
        result.append(num/den);
        num%=den;
        if(num==0)return result.toString();
        result.append(".");
        HashMap<Long, Integer> mapIndex = new HashMap<>();
        mapIndex.put(num, result.length());
        while(num!=0){
            num*=10;
            result.append(num/den);
            num%=den;
            if(mapIndex.containsKey(num)){
                int index = mapIndex.get(num);
                result.insert(index,"(");
                result.append(")");
                break;
            }else{
                mapIndex.put(num, result.length());
            }
        }
        return result.toString();
    }
}