package MainClass.SubClass;

import MainClass.SubClass.SuperClass.*;
import MainClass.SubClass.Interfaces.*;
import MainClass.SubClass.Exceptions.*;
import java.util.*;
public class Points extends Coordinate implements INT
{
double k= 8.99*Math.pow(10,9);
ArrayList<Charges> cArray;
double resultant;
//double angle;
String name;
double xResult=0.0;
double yResult=0.0;
public Points()
{super();
name="P";
}

public Points(String p,int x1,int y1)
{
super(x1,y1);
name=p;
} 
public double getXResult(){return xResult;}
public void setXResult(double x){xResult=x;}
public double getYResult() {return yResult;}
public void setYResult(double y){yResult=y;}

public double getResult() {return resultant;}
public void setResult(double r) {resultant =r;}

public ArrayList<Charges> getCArray()
{return cArray;}
public void setCArray(ArrayList<Charges> a)
{cArray=a;}



public void distanceCalc()
{	
	
	int superx= getX();
	int supery= getY();
	for(int i=0;i<cArray.size();i++)
		{
		Charges temp = cArray.get(i);
		int chargex=temp.getX();
		int chargey=temp.getY();
			
		int absx= Math.abs(superx-chargex);
		int absy= Math.abs(supery-chargey);
		double dist;
		double dist1= Math.pow(absx,2)+Math.pow(absy,2);
		boolean flag =false;
		try
			{
			if(dist1==0)
				throw new ZeroDistance();
			}
			catch(ZeroDistance zd)
				{System.out.println(zd.getMessage());
				System.out.println(zd.toString());
				flag= true;
				}
		finally
			{
			if(flag)
			{dist=0;}
			else {dist=Math.sqrt(dist1);}
			}
		temp.setDistance(dist);
		cArray.set(i,temp);
		
		} 
}
public void eField()
{
	double field;
	for(int i=0;i<cArray.size();i++)
		{
		boolean flag = false;
		Charges ch1= cArray.get(i);
		double dist=ch1.getDistance();
		double chrg=ch1.getCharge();
		try
			{
			if (dist==0)
				throw new ZeroDistance();
			}
			catch(ZeroDistance zd)
				{System.out.println(zd.getMessage());
				System.out.println(zd.toString());
				flag= true;
				}
		finally{
			if (flag)
				field=0;
			else 
				{field = k*(chrg/Math.pow(dist,2));
				}}
		ch1.setElectricField(field);
		cArray.set(i,ch1);
		}
}
public void chargeAngle()
{	
	double sint;
	double cost;
	int superx= getX();
	int supery= getY();
	for(int i=0;i<cArray.size();i++)
		{
		Charges ctemp= cArray.get(i);
		int xc=ctemp.getX();
		int yc=ctemp.getY();
		int absx= Math.abs(superx-xc);
		int absy= Math.abs(supery-yc);
		double dist= ctemp.getDistance();
		boolean flag=false;
		try
			{
				if(dist==0)
				throw new ZeroDistance();
			}
			catch(ZeroDistance zd)
				{
				System.out.println(zd.getMessage());
				System.out.println(zd.toString());
				flag= true;
				}
		finally{
			if(flag)
				{
				sint=0.0;
				cost=0.0;
				}
			else
				{
				sint=Math.abs(absy/dist);
				if((supery>yc)&&(cArray.get(i).getCharge()>0.0))
					{sint=Math.abs(sint);}
				else if((supery>yc)&&(cArray.get(i).getCharge()<0.0))
					{sint=Math.abs(sint);}
				
				if(supery<yc)
					{sint=sint*-1;}
					
				cost=Math.abs(absx/dist);
				if((superx>xc)&&(cArray.get(i).getCharge()>0.0))
					{cost=Math.abs(cost);}
				if((superx>xc)&&(cArray.get(i).getCharge()<0.0))
					{cost=Math.abs(cost);}
					
				if(superx<xc)
					{cost=cost*-1;}
				
				}
				ctemp.setSin(sint);
				ctemp.setCos(cost);
				ctemp.xyFields();
				cArray.set(i,ctemp);
		}}
}
public void pointResults()
{
	double totalx=0.0;
	double totaly=0.0;
	for(int i=0;i<cArray.size();i++)
		{
		Charges ctemp= cArray.get(i);
		double x=ctemp.getEX();
		xResult= xResult+x;
		double y=ctemp.getEY();
		yResult=yResult+y;
		double resultxy= Math.pow(yResult,2)+Math.pow(xResult,2);
		if (resultxy==0)
			{resultant=0;}
			else
				{resultant=Math.sqrt(resultxy);}
		}
}

public void printString()
{
for(int i=0;i<cArray.size();i++)
{
double dist =cArray.get(i).getDistance();
double magn=cArray.get(i).getElectricField();
double chrg= cArray.get(i).getCharge();
double cosine= cArray.get(i).getCos();
double sine= cArray.get(i).getSin();
double xcomp= cArray.get(i).getEX();
double ycomp= cArray.get(i).getEY();
//System.out.println(dist);
System.out.println("The magnitude of electric field at point: "+name+" due to charge point:"+(i+1)+" is: "+magn);
System.out.println("The charge is: "+chrg);
System.out.println("Cosine of the angle= "+cosine);
System.out.println("The value of the x component is: "+xcomp);
System.out.println("Sine of the angle= "+sine);
System.out.println("The value of the y component is: "+ycomp);

System.out.println("-----------------------------------------------");
//System.out.println(cArray.get(i).getX()+","+cArray.get(i).getY());
}
System.out.println("The magnitude of the resultant field is: "+resultant+" for point:"+name);
System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
}

public String toString()
{
	String out1= "The x-coord is x="+ getX()+" The coord is y="+getY()+" The point is:"+name+"\n";
	String out2= " the individual fields from each charge are: \n";
	String out3="";
		for(int i=0;i<cArray.size();i++)
		{
			Charges chr=cArray.get(i);
			double d=chr.getElectricField();
			String ef=Double.toString(d);
			out3 =out3+ef+" ";
		}
	String out4="\n"+"The ResultantField is:"+resultant;
	String fin = out1+out2+out3+out4;
	return fin;
}
}


