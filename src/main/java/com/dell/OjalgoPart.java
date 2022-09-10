package com.dell;

import org.ojalgo.OjAlgoUtils;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;


public class OjalgoPart  {
	static FileReader fr=new FileReader();
	public static String n[]=fr.name();
	public static double c[]=fr.capacity();
	public static double ch[]=fr.ChargingTime();
	

	
public static void Optimize(int Row) {
	System.out.println(OjalgoPart.class);
	System.out.println(OjAlgoUtils.getTitle());
  
    ExpressionsBasedModel model = new ExpressionsBasedModel();
    Expression totalNeededKwh = model.addExpression().weight(1);
	System.out.println("Car models are:");
    for (int j=0;j<Row;j++) {
    	Variable  vname = model.addVariable(n[j]).lower(0).integer(true).weight(c[j]/ch[j]);
    	totalNeededKwh.set(vname, c[j]);
    
         System.out.print((j+1)+") "+n[j]+" ,");     
    }
    System.out.println();
    
    for (int i = 1000 ; i > 990 ; i--) {
    	totalNeededKwh.upper(i);
        Result result = model.maximise();
        System.out.println();
        if (Math.round(result.getValue()) < i) {
       System.out.println("Not possible to order "+i+" Kwh Batteries");
            break;
        } else {
           System.out.println(result);
        }
    }

}

    

}
