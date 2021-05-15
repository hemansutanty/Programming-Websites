/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

1 <= task.length <= 104
tasks[i] is upper-case English letter.
The integer n is in the range [0, 100].
*/

/*
Start with  the maximum count of the task occuring frequently, Pick greeedily and divinde into parts. Each part would be eqaul to n times. Fill those up with the remamining tasks
Now an edge case would be some of the tasks w=might be in same frequency as the maximum one. In that case clube them togerther and the  find part length.
After that fill the rest of the slots

*/


class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        int max = 0; int maxCount = 0;
        for(char ch : tasks){
            charCount[ch-'A']++;
            if(max==charCount[ch-'A']){
               maxCount++;
            }
            else if (max<charCount[ch-'A']){
                max=charCount[ch-'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n-(maxCount-1);
        int emptySlots = partCount*partLength;
        int availableTasks = tasks.length-max*maxCount;
        int idles = Math.max(0, emptySlots-availableTasks);
        return tasks.length+idles;
    }
}