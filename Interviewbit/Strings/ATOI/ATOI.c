/*
Implement atoi to convert a string to an integer.

Example :
Input : "9 2704"
Output : 9

Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

Questions: 
Q1. Does string contain whitespace characters before the number?
A. Yes 
Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. 
Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. 
Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise.

Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.

*/

// Solution

/**
 * @input A : Read only ( DON'T MODIFY ) String termination by '\0'
 * 
 * @Output Integer
 */
int isNumeric(char a){
    if(a>='0' && a<='9'){
        return 1;
    }
    else{
        return 0;
    }
}
int matoi(const char* string) {
    
    if(strlen(string)==0){
        return 0;
    }
    int sign = 1, i = 0; long long result = 0;
    while(string[i]==' '){
        i++;
    }
    if(string[i]=='-'){
        sign=-1;
        i++;
    }
    if(string[i]=='+'){
        sign = 1;
        i++;
    }
    if(isNumeric(string[i])==0 || i==strlen(string)){
        return 0;
    }
    for(;string[i]!='\0';i++){
        if(isNumeric(string[i])==0){
            break;
        }
        result = result * 10 + string[i] - '0';
        if(result>INT_MAX){
            if(sign==1)
            return INT_MAX;
            else
            return INT_MIN;
        }
    }
    result = result*sign;
    return (int)result;
    
}