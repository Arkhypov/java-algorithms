package com.us.algorithms.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestStringChain {
/**
 * Given a list of words, each word consists of English lowercase letters.
   Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  
   For example, "abc" is a predecessor of "abac".
   A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, 
   where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
   Return the longest possible length of a word chain with words chosen from the given list of words.
 * 
 * 
 * 
 * Example 1:
Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chain is "a","ba","bda","bdca".
   
   Example 2:
Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
 */
	public static void main(String[] args) {
		System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"})); //bdca
		System.out.println(longestStrChain(new String[]{"zxb", "bca", "bda", "bdca", "zxbe"})); //
	}

    public static int longestStrChain(String[] words) {
        Map<String, Integer> dictionary = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dictionary.getOrDefault(prev, 0) + 1);
            }
            dictionary.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}
