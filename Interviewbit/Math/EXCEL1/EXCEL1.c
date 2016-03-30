/*

Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 

*/


//Solution

/**
 * @input A : String termination by '\0'
 * 
 * @Output Integer
 */
int titleToNumber(char* A) {
    
    int columnNumber=0;
    int i,power=0;
    for(i=strlen(A)-1;i>=0;i--){
        int x=(int)A[i];
        columnNumber = columnNumber+pow(26,power)*(x-64);
        power++;
    }
    return columnNumber;
}
