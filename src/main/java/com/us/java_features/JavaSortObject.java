package com.us.java_features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JavaSortObject {

	public static void main(String[] args) {
		
		ArrayList<Student> arraylist = new ArrayList<Student>();
		arraylist.add(new Student(223, "Chaitanya", 26));
		arraylist.add(new Student(245, "Rahul", 24));
		arraylist.add(new Student(209, "Ajeet", 32));
		
		
		//comparing by age
		Collections.sort(arraylist);
		
		
		Collections.sort(arraylist, (p1,p2) -> Integer.valueOf(p1.getStudentage()).compareTo(p2.getStudentage()));
		//comparing by name
		Collections.sort(arraylist, 
				(p1,p2) -> p1.getStudentname().compareTo(p2.getStudentname()));

		   for(Student str: arraylist){
				System.out.println(str);
		   }
		

	}

}

class Student implements Comparable{
private String studentname;
private int rollno;
private int studentage;

public Student(int rollno, String studentname, int studentage) {
     this.rollno = rollno;
     this.studentname = studentname;
     this.studentage = studentage;
}

	public String getStudentname() {
	     return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getStudentage() {
		return studentage;
	}
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}

	@Override
    public int compareTo(Object stud) {
        int compareage=((Student)stud).getStudentage();
        /* For Ascending order*/
        return this.studentage-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }

    @Override
    public String toString() {
        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
    }
}	
