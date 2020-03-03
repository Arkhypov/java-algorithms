package com.us.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindClosestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		digitsManipulations(1234);
	}
	//Write the method findClosestPoints(n, points) to print the top N closest points to the origin (0,0)

	//Cordinates (1,1), (2,3),(6,2),(4,10),(5,5)
	//Start Location (0,0)
	//sqrt((x1-x2)^2+(y1-y2)^2)

	class Point{
	    
	    public int x; 
	    public int y; 
	    public Point(int x, int y) {
	        this.x = x; 
	        this.y = y; 
	    }
	    
	    public String toString() {
	        return "(" + x + "," + y + ")";
	        
	    }
	    
	    int hashcode(){
			return x+y;
	    }
	    boolean equals(Point p){
			return (this.x==p.x && this.y==p.y);
	    }
	}

	/*public void findClosestPoints(int n, List<Point> points){
	    
	    //int minValue=Integer.MIN_VALUE;
	    Map<Double,List<Point>> pointsMap = new TreeMap<Double,List<Point>>();
	    points.stream().forEach(p->{
	    	double delta=Math.sqrt((p.x-0)^2+(p.y-0)^2);
	    	if(pointsMap.containsKey(delta)){
	            List<Point> pointss=pointsMap.get(delta);
	            pointss.add(p);
	            pointsMap.put(delta,points);
	            continue;
	    	}
	    	pointsMap.put(delta, new ArrayList<Point>(){{add(p);}});
	    });
	    
	    while(n>0){
	        double key=pointsMap.keySet().iterator().next(); //first key in map;
	        List<Point>pointss =pointsMap.get(key);
	        for(Point point: pointss){
	            System.out.print(point);
	            n--;
	        }
	        pointsMap.remove(key);
	    }
	}*/
	
	static int digitsManipulations(int n) {
		int sum=0;
		int multiply=0;
	    List<Integer> list= new ArrayList<Integer>();
	    while (n>=10){
	        int tmp =n%10;
	        System.out.println(tmp);
	        list.add(tmp);
	        n=Math.abs(n/10);
	        System.out.println(n);
	    }
	    list.add(n);
	    for(int k : list){
	      sum+=k;
		  multiply=multiply*k;
	    }
		return multiply-sum;
	}
}
