package com.dell;

import java.util.Scanner;

public class CalculateOptimize {
public static void main(String[] arg) {
	long startTime = System.nanoTime();
//	System.out.println(FileReader.name());
//	System.out.println(FileReader.capacity());
//	System.out.println(FileReader.ChargingTime());
    Scanner input = new Scanner(System.in);
    System.out.println( "Please enter number of rows in file (a value between 1 to 85)  ");
    String inputStr = input.next();
    System.out.println( "Calculation started for  " + inputStr+" rows" );
    try {
    	 OjalgoPart.Optimize( (Integer.parseInt(inputStr)));
    	 System.out.println("Top Optimal conditiones calculated in Kwh");
    }catch(Exception e){
    	System.out.println("Error in running, Please chek input value!");
    	
    }
 


	long endTime = System.nanoTime();

	long duration = (endTime - startTime);
	System.out.println("Duration: "+duration/1000000+" ms");
}
}
