package com.us.algorithms;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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




public class LRUCacheImpl {
static class LRUCache {
 
 private Map<String, Integer> map = null;
 private int cacheSize = 0;
 private Set <String> lastUsedVal = null;
 
 
 public void put(String key, int val) {
   //synchronized(map) {
    //map.put(key, val);
   
   if(map.size()>=cacheSize){
     String entryToRemove=null;
     for(String entry: map.keySet()){
       if(!lastUsedVal.contains(entry)){
    	   List<String> sL= new ArrayList<String>();
    	   
         entryToRemove=entry; 
         break;
       }
     }
     map.remove(entryToRemove);
   }
   map.put(key, val);
    
   //}
 }
 public int get(String key) {
   lastUsedVal.add(key);
   if(lastUsedVal.size()>=cacheSize){
     lastUsedVal.remove(lastUsedVal.iterator().next());
       
   }      
   return (map.containsKey(key))? map.get(key):-1;
 }
 
 public LRUCache(int capacity) {
   map= new LinkedHashMap<String, Integer>();
   lastUsedVal = new LinkedHashSet<String>();
   this.cacheSize=capacity;
 }
}

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

