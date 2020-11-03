package com.us.algorithms.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Job {
	public Job(String id, String parentId) {
		this.id = id;
		this.parentId = parentId;
	}
	private String id; //Non-null; guaranteed to be unique
	private String parentId; //Nullable.  When present, it will refer to the id of another job.
	
	public String getId() {
		return id;
	}
   public String getParentId() {
	return parentId;
}
}
/**
 * 	A job can run if:
	  1. It has no parent (parentId == null)
	      OR
	  2. If its parent job can run

	// Returns true if every job in the list can run, else false
	id | parentId
	C  | null
	A  | B
	B  | D
	Z  | A
	D  | C
 */
public class JobsCount {

	public static void main(String[] args) {
		System.out.println(canRunAllJobs(Arrays.asList(
			new Job("C",null),
			new Job("A","B"),
			new Job("B","D"),
			new Job("Z","A"),
			new Job("D","C")
		)));

	}
	public static boolean canRunAllJobs(List<Job> jobs) {
		 //hashSet 1. put least in stream and populate hashset of ids thats jobs that parent id == null and increment count
		 //2. loop list and check if parentid!=null and hashset.contains(parentId) and increment count
		 //3. check count with size of list.
		 int size=jobs.size();
		 Set<String> jobsIdCanrun= jobs.stream().filter(a->a.getParentId()==null).map(Job::getId).collect(Collectors.toSet());
		 //int count= jobsIdCanrun.size();
		 //jobs.sorted((j1, j2) -> j1.compareTo())
		 
		 List<Job>reducedJ=jobs.stream().filter(a->a.getParentId()!=null).collect(Collectors.toList());
		 int count=jobsIdCanrun.size();
		 //Iterator<Job> jobsI=reducedJ.iterator();
		 while(!reducedJ.isEmpty() || count<jobs.size()){
			 List<Job> tmpL=new ArrayList<Job>(reducedJ);
			 for(Job j: tmpL){
				 if(jobsIdCanrun.contains(j.getParentId())){
			         jobsIdCanrun.add(j.getId());
			         reducedJ.remove(j);
				 }
			 }
			 count++;
		 } 
		 return jobs.size()==jobsIdCanrun.size();
		}

	
	



}
