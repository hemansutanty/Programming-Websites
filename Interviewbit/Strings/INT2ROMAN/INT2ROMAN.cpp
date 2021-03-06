/*
Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations. 
 
 */


 //Solution

string Solution::intToRoman(int num) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    string res;
    int n_M = int(num/1000);
    res += string(n_M,'M');
    num = num%1000;
    int n_C = int(num/100);
    if (n_C!=0){
        if (n_C<=3){res += string(n_C,'C');}
        if (n_C==4){res += "CD";}
        if (n_C>=5 && n_C<=8){ res+="D";res += string(n_C-5,'C');}
        if (n_C==9){res += "CM";}
    }
    num = num%100;
    int n_X = int(num/10);
    if (n_X!=0){
        if (n_X<=3){res += string(n_X,'X');}
        if (n_X==4){res += "XL";}
        if (n_X>=5 && n_X<=8){res+="L"; res += string(n_X-5,'X'); }
        if (n_X==9){res += "XC";}
    }
    num = num%10;
    int n_I = int(num/1);
    if (n_I!=0){
        if (n_I<=3){res += string(n_I,'I');}
        if (n_I==4){res += "IV";}
        if (n_I>=5 && n_I<=8){res+="V"; res += string(n_I-5,'I'); }
        if (n_I==9){res += "IX";}
    }
    return res;
}
