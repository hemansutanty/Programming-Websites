import java.util.ArrayList;
import java.util.List;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
*/

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode current = root;
            for(char ch : word.toCharArray()){
                int i = ch-'a';
                if(current.children[i]==null){
                    current.children[i]=new TrieNode();
                }
                current = current.children[i];
            }
            current.word = word;
        }
        return root;
    }
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result){
        char ch = board[i][j];
        if(ch=='#' || node.children[ch-'a']==null) return;
        node = node.children[ch-'a'];
        if(node.word!=null){
            result.add(node.word);
            node.word = null; // No duplicates
        }
        board[i][j]='#';
        if(i>0) dfs(board, i-1, j, node, result);
        if(j>0) dfs(board, i, j-1, node, result);
        if(i<board.length-1) dfs(board, i+1, j, node, result);
        if(j<board[0].length-1) dfs(board, i, j+1, node, result);
        board[i][j]=ch;
    }
}