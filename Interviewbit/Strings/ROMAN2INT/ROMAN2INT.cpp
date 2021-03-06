/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

*/


//Solution

int Solution::romanToInt(string s) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    int res=0;
    char pre = ' ';
    for(int i=0;i<s.size();i++){
        if (s[i]=='M' && pre!='C') {res+=1000;}
        if (s[i]=='C' && pre!='X') {res+=100;}
        if (s[i]=='X' && pre!='I') {res+=10;}
             
        if (s[i]=='M' && pre=='C') {res+=800;}
        if (s[i]=='C' && pre=='X') {res+=80;}
        if (s[i]=='X' && pre=='I') {res+=8;}
             
        if (s[i]=='I' ) {res+=1;}
             
        if (s[i]=='V' && pre!='I'){res+=5;}
        if (s[i]=='L' && pre!='X'){res+=50;}
        if (s[i]=='D' && pre!='C'){res+=500;}
             
        if (s[i]=='V' && pre=='I'){res+=3;}
        if (s[i]=='L' && pre=='X'){res+=30;}
        if (s[i]=='D' && pre=='C'){res+=300;}
             
        pre = s[i];
    }     
    return res;
}
