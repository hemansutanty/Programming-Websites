import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*abstractGiven two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        if(!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        int wordLength = beginWord.length();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0;i<queueSize;i++){
                char[] word = queue.poll().toCharArray();
                for(int pos = 0;pos<wordLength;pos++){
                    char originalCharacter = word[pos];
                    for(char c='a';c<='z';c++){
                        if(word[pos]==c)continue;
                        word[pos]=c;
                        if(String.valueOf(word).equals(endWord)){
                            return level+1;
                        }
                        if(!set.contains(String.valueOf(word))){
                            continue;
                        }
                        set.remove(String.valueOf(word));
                        queue.add(String.valueOf(word));
                    }
                    word[pos]=originalCharacter;
                }
            }
            level++;
        }
        return 0;
    }
}