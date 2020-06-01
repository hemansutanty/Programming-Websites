import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/
class Key{
    char ch;
    int frequency;
    Key(char ch, int frequency){
        this.ch=ch;
        this.frequency=frequency;
    }
}
class KeyComparator implements Comparator<Key>{
    public int compare(Key k1, Key k2){
        if(k1.frequency<k2.frequency)return 1;
        else if(k1.frequency>k2.frequency) return -1;
        else return 0;
    }
}
class Solution {
    public String reorganizeString(String S) {
        int n = S.length();
        int[] chCount = new int[26];
        for(int i=0;i<n;i++){
            chCount[S.charAt(i)-'a']++;
        }
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for(char i='a';i<='z'; i++){
            if(chCount[i-'a']>0){
                pq.add(new Key(i, chCount[i-'a']) );
            }
        }
        String str = "";
        Key prev= new Key('#', -1);
        while(pq.size()!=0){
            Key key = pq.peek();pq.poll();
            str=str+key.ch;key.frequency--;
            if(prev.frequency>0){
                pq.add(prev);
            }
            prev=key;
        }
        if(str.length()!=S.length()){
            return "";
        }
        else{
            return str;
        }
    }
}