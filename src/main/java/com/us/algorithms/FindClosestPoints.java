package com.us.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindClosestPoints {

	public static void main(String[] args) {
		findClosestPoints(3,new ArrayList<Point>(){{add(new Point(1,1));add(new Point(6,2));add(new Point(2,3));add(new Point(4,10));add(new Point(5,5));}});
	}
	//Write the method findClosestPoints(n, points) to print the top N closest points to the origin (0,0)

	//Cordinates (1,1), (2,3),(6,2),(4,10),(5,5)
	//Start Location (0,0)
	//sqrt((x1-x2)^2+(y1-y2)^2)

	
	    
	    

	public static void findClosestPoints(int n, List<Point> points){
	    
	    //int minValue=Integer.MIN_VALUE;
	    Map<Double,List<Point>> pointsMap = new TreeMap<Double,List<Point>>();
	    for(Point p: points){
	    	double delta=Math.sqrt((p.x-0)^2+(p.y-0)^2);
	    	if(pointsMap.containsKey(delta)){
	            List<Point> pointss=pointsMap.get(delta);
	            pointss.add(p);
	            pointsMap.put(delta,points);
	            continue;
	    	}
	    	pointsMap.put(delta, new ArrayList<Point>(){{add(p);}});
	    	
	    }
	    
	    while(n>0){
	        double key=pointsMap.keySet().iterator().next(); //first key in map;
	        List<Point>pointss =pointsMap.get(key);
	        for(Point point: pointss){
	            System.out.print(point);
	            n--;
	        }
	        pointsMap.remove(key);
	    }
	}
	
	
}
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
