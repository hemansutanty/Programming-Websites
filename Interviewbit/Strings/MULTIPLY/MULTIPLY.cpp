/*

Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
We will retroactively disqualify such submissions and the submissions will incur penalties.

*/


//Solution

vector<int> stringToVectorForm(string& s) {
  vector<int> v;
  for (int i = s.size() - 1; i >= 0; --i)
    v.push_back(s[i] - '0');
  return v;
}
vector<int> multiplyInVectorForm(vector<int>& a,vector<int>& b) {
    
    vector<int> prod(a.size() + b.size() - 1, 0);
  // First multiply the numbers.
  for (int i = 0; i < a.size(); ++i)
    for (int j = 0; j < b.size(); ++j)
      prod[i + j] += a[i] * b[j];
  // Then normalize the product.
  for (int i = 0;
       i < prod.size() || (i == prod.size() - 1 && prod[i] >= 10);
       ++i)
    if (i == prod.size() - 1 && prod[i] >= 10) {
      prod.push_back(prod[i] / 10);
      prod[i] %= 10;
    } else {
      prod[i + 1] += prod[i] / 10;
      prod[i] %= 10;
    }
  return prod;
}
string Solution::multiply(string A, string B) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    string result="";
    vector<int> v1 = stringToVectorForm(A);
    vector<int> v2 = stringToVectorForm(B);
    vector<int> prod = multiplyInVectorForm(v1,v2);
    for (int i = prod.size()-1;i>=0;--i)
    {
        if(prod[i]!=0){
            break;
        }
        prod.pop_back();
    }
    for (int i = prod.size() - 1; i >= 0; --i){
       result=result+to_string(prod[i]);
    }
    if(result==""){
        return "0";
    }
    return result;
}