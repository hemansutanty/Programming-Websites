/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 //capacity);

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

import java.util.Hashtable;
class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode previous;
        DLinkedNode next;
    }
    public void addNode(DLinkedNode node){
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }
    public void removeNode(DLinkedNode node){
        DLinkedNode previous = node.previous;
        DLinkedNode next = node.next;
        previous.next = next;
        next.previous = previous;
    }
    public void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    public DLinkedNode popTail(){
        DLinkedNode result = tail.previous;
        this.removeNode(result);
        return result;
    }
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.previous  = null; tail.next = null;
        head.next=tail ; tail.previous = head;
    }
    
    public int get(int key) {
        DLinkedNode result = cache.get(key);
        if(result==null) return -1;
        this.moveToHead(result);
        return result.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode oldEntry = cache.get(key);
        if(oldEntry==null){
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;
            this.cache.put(key, node);
            this.addNode(node);
            count++;
            if(count>capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
                
        }else{
            oldEntry.value= value;
            this.moveToHead(oldEntry);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */