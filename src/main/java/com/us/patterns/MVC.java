package com.us.patterns;

public class MVC {

	public static void main(String[] args) {
		
		//fetch Student from database
		Student student = retreiveDataFromDataBase();
		
		//create a view to write data to user
		StudentView view = new StudentView();
		
		StudentController cntr = new StudentController(student, view);
		cntr.updateView();
		
		//update model
		student.setName("Yevgen");
		
		//update view with new data
		cntr.updateView();
	}

	private static Student retreiveDataFromDataBase() {
		// TODO Auto-generated method stub
		Student model = new Student();
		model.setName("John");
		model.setSurname("Arkhypov");
		return model;
	}
}

class StudentView{
	
	public void printStudentDetails(String name, String surname){
		
		System.out.println("Student name is " +name);
		System.out.println("Student name is " +surname);
	}
	
}

class Student{
	
	private String name;
	private String surname;
	
	public Student(){
		
		
	}
	
	public Student(String name, String surname){
		this.surname = surname;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}


class StudentController{
	
	private StudentView view;
	private Student model;
	
	
	StudentController(Student model, StudentView view){
		this.view=view;
		this.model=model;
	}
	
	public String getStudentName(){
		return this.model.getName();
	}
	
	public String getStudentSurName(){
		return this.model.getSurname();
	}
	
	public void setStudentName(String name){
		
		this.model.setName(name);
	}
	
	public void setStudentSurname(String surName){
		
		this.model.setName(surName);
	}
	
	public void updateView(){
		
		view.printStudentDetails(model.getName(), model.getSurname());
	}
}
