package com.holidu.interview.assignment;

import java.util.ArrayList;
import java.util.List;

public class Circle {

	static double d2r = Math.PI / 180;   // degrees to radians
	static double r2d = 180 / Math.PI;   // radians to degrees
//	static double  earthsradius = 3963; // 3963 is the radius of the earth in miles
	static double  earthsradius = 637781442;
	
	static List<Double> list = new ArrayList<Double>();
	public static void main(String[] args) {
		
		List<Double> list = drawCircle(-73.84421522, 40.77020969 , 160934);
		
		System.out.println(" long"+list.get(0));

	}
	
	static List<Double> drawCircle(double lng, double lat , int radius )
	{
	   int points = 32;
	   //int radius = 100;             // radius in miles
	   //1 miles  = 1609,34 meters
	    radius = 160934;  
	   // find the raidus in lat/lon
	   double rlat = (radius / earthsradius) * r2d;
	   double rlng = rlat / Math.cos(lat * d2r);
     
	   for (int i=0; i < points+1; i++) // one extra here makes sure we connect the
	   {
	      double theta = Math.PI * (i / (points/2));
	      double  ex = lng + (rlng * Math.cos(theta)); // center a + radius x * cos(theta)
	      double ey = lat + (rlat * Math.sin(theta)); // center b + radius y * sin(theta)
	      list.add(ex);
	      list.add(ey);
         }
	  return list;
	}
}
