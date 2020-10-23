package com.us.algorithms;


import java.util.HashMap;
import java.util.Map;

/*
* LRU Cache
* Like a map with a size that kicks out the oldest member
* when the size fills up.
*/

//we will make instance of LinkedHashMap
//1) get
//when we getting value we put the key inside the queue
//if queue size bigger then size of cache we store element in variable remove element in queue at this size position
//if size of map is bigger then size of cache we remove element we stored

//2) put 
//




public class LRUCache {

	class DLinkedNode {
		  String key;
		  int value;
		  DLinkedNode pre;
		  DLinkedNode post;
		}
	private Map<String, DLinkedNode> 
	  cache = new HashMap<String, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;
	
	public LRUCache(int capacity) {
		  this.count = 0;
		  this.capacity = capacity;

		  head = new DLinkedNode();
		  head.pre = null;

		  tail = new DLinkedNode();
		  tail.post = null;

		  head.post = tail;
		  tail.pre = head;
		}
		/**
		 * Always add the new node right after head;
		 */
		private void addNode(DLinkedNode node) {
		    
		  node.pre = head;
		  node.post = head.post;

		  head.post.pre = node;
		  head.post = node;
		}

		/**
		 * Remove an existing node from the linked list.
		 */
		private void removeNode(DLinkedNode node){
		  DLinkedNode pre = node.pre;
		  DLinkedNode post = node.post;

		  pre.post = post;
		  post.pre = pre;
		}

		/**
		 * Move certain node in between to the head.
		 */
		private void moveToHead(DLinkedNode node){
		  this.removeNode(node);
		  this.addNode(node);
		}

		// pop the current tail. 
		private DLinkedNode popTail(){
		  DLinkedNode res = tail.pre;
		  this.removeNode(res);
		  return res;
		}

		public int get(String key) {

		  DLinkedNode node = cache.get(key);
		  if(node == null){
		    return -1; // should raise exception here.
		  }

		  // move the accessed node to the head;
		  this.moveToHead(node);
		  return node.value;
		}


		public void put(String key, int value) {
		  DLinkedNode node = cache.get(key);

		  if(node == null){

		    DLinkedNode newNode = new DLinkedNode();
		    newNode.key = key;
		    newNode.value = value;

		    this.cache.put(key, newNode);
		    this.addNode(newNode);

		    ++count;

		    if(count > capacity){
		      // pop the tail
		      DLinkedNode tail = this.popTail();
		      this.cache.remove(tail.key);
		      --count;
		    }
		  }else{
		    // update the value.
		    node.value = value;
		    this.moveToHead(node);
		  }
		}

		/**  
		 * 
		 * @param test
		 * @return testResult
		 */
		
		
		
		
		public static void assertEquals(int expected, int actual) {
			 if( expected == actual) {
			   System.out.println("PASSED: " + expected + " == " + actual);
			 } else {
			   System.out.println("FAILED: " + expected + " != " + actual);
			 }
			}

	    public static void main(String[] args) {
			 LRUCache cache = new LRUCache( 2 /* capacity */ );
			 cache.put("one", 1);
			 cache.put("two", 2);
			 int val = cache.get("one");       // returns 1
			 assertEquals(1, val);
			 
			 cache.put("three", 3);            // evicts key 2
			 int res = cache.get("two");       // returns -1 (not found)
			 assertEquals(-1, res);
			 
			 cache.put("four", 4);             // evicts key 1
			 res = cache.get("one");           // returns -1 (not found)
			 assertEquals(-1, res);
			 
			 res = cache.get("three");         // returns 3
			 assertEquals(3, res);

			 res = cache.get("four");          // returns 4
			 assertEquals(4, res);
			}

}


