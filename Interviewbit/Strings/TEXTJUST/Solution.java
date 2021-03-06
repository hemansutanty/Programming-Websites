/*

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]


*/


/*** Algorithm ---

The problem can be divided into two parts. The first part is to determine how many words can form in a line. Then the second part is to determine the length of white spaces between words. 

For the first part, since there must be at least one white space between each word, we can count the total length including one white space until the length is greater than the L. There is one corner case to consider: the last line where the total length might be smaller than L. 

For the second part, again, there are two cases to consider:
 -- If it is the last line, or if the line contains only one word. For this case, the line should be left-justified. 
-- Otherwise, we could calculate how many white spaces we should have, and divided by number of slots between words. 


*/


//Solution


public class Solution {
	public ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {
	    ArrayList<String> result = new ArrayList<>();
        if (words == null || words.size()== 0 || maxWidth < 0) {
            return result;
        }
         
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
         
        fullJustifyHelper(0, words, result, maxWidth);
         
        return result;
	}
	private void fullJustifyHelper(int start, ArrayList<String> words, 
                  ArrayList<String> result, int L) {
        if (start >= words.size()) {
            return;
        }
         
        int total = 0;
        int len = 0;
        int next = -1;
        int i = start;
         
        while (i < words.size() && total < L) {
            total += words.get(i).length();
             
            if (total > L) {
                next = i;
                break;
            }
             
            len += words.get(i).length();
            total++;
            i++;
        }
         
        if (next == -1) {
            next = i;
        }
         
        addLists(words, start, next, result, len, L);
         
        fullJustifyHelper(next, words, result, L);
    }
    private void addLists(ArrayList<String> words, int start, int next, 
                          ArrayList<String> result, int len, int L) {
        int slots = next - start - 1;
        StringBuffer sb = new StringBuffer();
        // Last line or only one word in a line
        if (slots == 0 || next == words.size()) {
            for (int i = start; i < next; i++) {
                sb.append(words.get(i));
                if (i == next - 1) {
                    break;
                }
                sb.append(" ");
            }
             
            int trailingSpace = L - len - slots;
            for (int i = 0; i < trailingSpace; i++) {
                sb.append(" ");
            }
             
            result.add(sb.toString());
        } else {
            int aveSpace = (L - len) / slots;
            int moreSpace = (L - len) % slots;
            for (int i = start; i < next; i++) {
                sb.append(words.get(i));
                if (i == next - 1) {
                    break;
                }
                for (int j = 0; j < aveSpace; j++) {
                    sb.append(" ");
                }
                 
                if (moreSpace > 0) {
                    sb.append(" ");
                    moreSpace--;
                }
            }   
            result.add(sb.toString());
        }
    }
}