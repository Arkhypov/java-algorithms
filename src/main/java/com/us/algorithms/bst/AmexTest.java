package com.us.algorithms.bst;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AmexTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // solution("ABCHello");

  }

  static String solution(String S) {
    int[] occurrences = new int[26];
    for (char ch : S.toLowerCase().toCharArray()) {
      System.out.println(ch - 'a');
      occurrences[ch - 'a']++;
    }

    char best_char = 'a';
    int best_res = 0;

    for (int i = 1; i < 26; i++) {
      if (occurrences[i] >= best_res) {
        best_char = (char) ((int) 'a' + i);
        best_res = occurrences[i];
      }
    }

    return Character.toString(best_char);
  }

  void getMax(Tree T, Hashtable<Integer, Tree> h) {
    if (T != null) {
      if (!h.containsKey(T.x)) {
        h.put(T.x, T);
      }
      getMax(T.right, h);
      getMax(T.left, h);
    }
  }


  private int getMaxNumNodes(Tree root, Set<Integer> uniq) {
    if (root == null) {
      return uniq.size();
    }
    int l = 0;
    int r = 0;
    if (uniq.add(root.x)) {
      l = getMaxNumNodes(root.left, uniq);
      r = getMaxNumNodes(root.right, uniq);
      uniq.remove(uniq.size() - 1);
    } else {
      l = getMaxNumNodes(root.left, uniq);
      r = getMaxNumNodes(root.right, uniq);
    }
    return Math.max(l, r);// (l >= r) ? l : r;
  }

  public int solution(Tree T) {
    // write your code in Java SE 8
    // Set<Integer> uniq = new HashSet<Integer>();
    // return getMaxNumNodes(T,uniq);
    Hashtable<Integer, Tree> h = new Hashtable<Integer, Tree>();
    getMax(T, h);
    return h.size();
  }

  public static List<String> getFraudIds(List<String> logs, int threshold) {
    List<String> list = new LinkedList();
    Map<String, Integer> map = new TreeMap(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        if (i2 > i1)
          return 1;
        if (i1 > i2)
          return -1;
        return 0;
      }
    });

    for (String log : logs) {
      String userId = log.split(" ")[0];
      String recepId = log.split(" ")[1];
      if (userId.equals(recepId)) {
        map.put(userId, map.getOrDefault(userId, 0) + 1);
        continue;
      }
      map.put(userId, map.getOrDefault(userId, 0) + 1);
      map.put(recepId, map.getOrDefault(recepId, 0) + 1);
    }

    for (Map.Entry<String, Integer> e : map.entrySet()) {
      if (e.getValue() >= threshold)
        list.add(e.getKey());
    }

    return list;
  }

  public boolean isRobotBounded(String ins) {
    int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    for (int j = 0; j < ins.length(); ++j)
      if (ins.charAt(j) == 'R')
        i = (i + 1) % 4;
      else if (ins.charAt(j) == 'L')
        i = (i + 3) % 4;
      else {
        x += d[i][0];
        y += d[i][1];
      }
    return x == 0 && y == 0 || i > 0;
  }

}


class Tree {

  public int x;
  public Tree left;
  public Tree right;
  int i = Integer.MIN_VALUE;

  public Tree(int j) {
    this.x = j;
  }
}

