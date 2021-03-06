/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.

*/

//Solution

string Solution::convert(string s, int nRows) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    vector<string> zz(nRows,"");
    if (nRows==1){return s;}
         
    int i=0; //for string 
    int r=0; //for zz vector
    bool zig = false; // if s[i] is in "/" or "|" direction
    while (i<s.size()){
        if (r<nRows && !zig){
            zz[r]+=s[i];
            r++;i++;
        }else{
            if (!zig){
                zig=true;
                r--;
            }else{
                r--;
                zz[r] = zz[r]+s[i];
                if (r==0){zig=false;r++;}
                i++;
            }
        }
    }
    string res; //get result;
    for (int i=0;i<zz.size();i++){
        for (int j=0;j<zz[i].size();j++){
            res = res+ zz[i][j];
        }
    }
    return res;
}
