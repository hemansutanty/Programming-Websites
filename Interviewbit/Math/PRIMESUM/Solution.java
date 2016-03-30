/*

Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

*/


//Solution

public class Solution {
    
    public void markMultiples(boolean arr[],int a ,int n){
        int i=2,num;
        while((num=i*a)<=n){
            arr[num-1]=true;
            i++;
        }
    }
    public ArrayList<Integer> sieve(int n){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(n>=2){
            boolean[] arr = new boolean[n];
            for(int i=0;i<n;i++){
                arr[i] = false;
            }
            for(int i=1;i<n;i++){
                if(arr[i]==false){
                   list.add(i+1);
                   markMultiples(arr,i+1,n);
                }
            }
        }
        return list;
    }
    public ArrayList<Integer> primesum(int a) {
        //Hashtable<Integer,Integer> finalTable = new Hashtable<Integer,Integer>();
        ArrayList<Integer> list = sieve(a);
        //System.out.println(list);
        ArrayList finalList = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            if(list.contains(a-list.get(i))){
                //System.out.println(list.get(i));
                finalList.add(list.get(i));
                finalList.add(a-list.get(i));
                break;
            }
        }
        //System.out.println(list);
        return finalList;
    }
}
