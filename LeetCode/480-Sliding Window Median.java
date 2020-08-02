import java.util.Collections;
import java.util.PriorityQueue;

/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
Answers within 10^-5 of the actual value will be accepted as correct.


*/


class Solution {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public Solution() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    public void removeNum(int num){
        if(num<=maxHeap.peek()){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return maxHeap.peek()/2.0+minHeap.peek()/2.0;
        }
        return maxHeap.peek();
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length-k+1;
        if(n<=0)return new double[0];
        double[] result = new double[n];
        for(int i=0;i<=nums.length;i++){
            if (i >= k) {
        	    result[i - k] = findMedian();
        	    removeNum(nums[i - k]);
            }
            if (i < nums.length) {
        	    addNum(nums[i]);
            }
        }
        return result;
    }
}