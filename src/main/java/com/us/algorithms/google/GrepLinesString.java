package com.us.algorithms.google;

public class GrepLinesString {
/**
 * grep

Input file:   /google/myinputfile.txt (one word per line)
organize -0
it -1
and -2
make -3
it -4
accessible -5
and -6
useful -7

Call 1: $ grep it /google/myinputfile.txt // assumption that context is 0
Output 1:
it
it

Call 2: $ grep --contextLines=1 "it" /google/myinputfile.txt
Output 2:
organize
it
and
make
it
accessible

Call 3: $ grep --contextLines=2 "make" /google/myinputfile.txt
Output 3:
it
and
make
it
accessible

printMatches(lines = [organize, it, and], contextLines=1, pattern="it")
  
--------

public String printMatches(lines = [organize, it, and], contextLines=1, pattern="it", int start, int end){
  
  String result = "";
  for (int i=start; i<end; i++){
      if(lines[i].match(".*"+pattern+"it*.")){
          int posBack=i-contextLines <0 ? 0: (i-contextLines); //2 , 1
          int posFront=i+contextLines>lines.length ? lines.length-1: (i+contextLines);
     
          while(posBack>=0 && posBack<=i){
            result+=lines[posBack];
            posBack++;
          }
        //result+=lines[i];
          while(i<posFront){
            result+=lines[i];
            i++;
          }
      }
  
  }
  return result;
}
  
  
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
