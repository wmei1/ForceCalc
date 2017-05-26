package MainClass;
import MainClass.SubClass.*;
import MainClass.SubClass.Interfaces.*;

import java.util.*;
public class Calculations implements INT
{
ArrayList<Points> statPoints;
//ArrayList<ArrayList<Charges>> chlist;
public ArrayList<Points> getPointArray(){return statPoints;}
public void setPointArray(ArrayList<Points> p){statPoints=p;}


public void distanceCalc()
{
	
	ArrayList<Points> temparray= new ArrayList<Points>();
	for(int j=0;j<statPoints.size();j++)
		{
		Points point = statPoints.get(j);
		point.distanceCalc();
		temparray.add(point);
		}
	statPoints=temparray;

}

public void eField()
{
	ArrayList<Points> temparray = new ArrayList<Points>();
	for(int j=0;j<statPoints.size();j++)
		{
		Points pointtemp=statPoints.get(j);
		pointtemp.eField();

		temparray.add(pointtemp);
		}
	statPoints=temparray;
}

public void chargeAngle()
{
ArrayList<Points> temparray = new ArrayList<Points>();
	for(int j=0;j<statPoints.size();j++)
		{
		Points pointtemp=statPoints.get(j);
		pointtemp.chargeAngle();
		temparray.add(pointtemp);
		}
	statPoints=temparray;
}
public void pointResults()
{
ArrayList<Points> temparray = new ArrayList<Points>();
	for(int j=0;j<statPoints.size();j++)
		{
		Points pointtemp=statPoints.get(j);
		pointtemp.pointResults();
		temparray.add(pointtemp);
		}
	statPoints=temparray;
}

}

