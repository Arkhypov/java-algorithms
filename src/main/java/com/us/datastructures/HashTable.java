package com.us.datastructures;

public class HashTable {
	final Node[] nodes;
	int size;
	HashTable(){
		size=0;
		nodes= new Node[10000];
	}
    public void put(String key, int value) {
    	int hash = getHash(key);
    	final Node hashEntry = new Node(key, value);
        if(nodes[hash] == null) {
        	nodes[hash] = hashEntry;
        }
        // If there is already an entry at current hash
        // position, add entry to the linked list.
        else {
        	Node prev = find(nodes[hash], key);
            if (prev.next == null)
                prev.next = hashEntry;
            //overriding existing value
            else prev.next.val = value;
        }
    }

    public Integer get(String key) {
        int hash = getHash(key);
        if (nodes[hash] == null) return -1;
        Node node = find(nodes[hash], key);
        return node.next == null ? -1 : node.next.val;
    }

    public int remove(String key) {
        int hash = getHash(key);
        if (nodes[hash] == null) return -1;
        Node prev = find(nodes[hash], key);
        if (prev.next == null) return -1;
        int val= prev.next.val;
        //removing node
        prev.next = prev.next.next;
        // Reduce size
        size--;
        return val;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    // piggy backing on java string
    // hashcode implementation.
    private int getHash(String key) {
    	// key.hashCode() could be negative.
    	int hash=key.hashCode() % nodes.length;
    	return hash>0 ? hash : hash * -1;
    
    }

    private Node find(Node bucket, String key) {
    		Node node = bucket, prev = null;
            while (node != null && bucket.key != key) {
            	prev=node;
            	node = node.next;
            }
            return prev;
    }
class Node {
      String key;
      int val;
      Node next;
      Node(String key, int val) {
          this.key = key;
          this.val = val;
      }
}
public static void main(String[] args){
	HashTable t = new HashTable();
	t.put("carina", 1);
}
}

