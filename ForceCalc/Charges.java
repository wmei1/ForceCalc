package MainClass.SubClass;

import MainClass.SubClass.SuperClass.*;

public class Charges extends Coordinate
{
private double charge;
private double distance;
private double sin;
private double cos;
private double electricField;
private double eX;
private double eY;


public Charges()
{super();}

public Charges(int x1,int y1, double c)
{
super(x1,y1);
charge =c;
}


public double getSin() {return sin;}
public void setSin(double s) {sin=s;}

public double getCos() {return cos;}
public void setCos(double c) {cos=c;}

public double getCharge() {return charge;}
public void setCharge(double c) {charge=c;}

public double getDistance() {return distance;}
public void setDistance(double d){distance =d;}

public double getElectricField() {return electricField;}
public void setElectricField(double e){electricField=e;}

public double getEX() {return eX;}
public void setEX(double x){eX=x;}

public double getEY() {return eY;}
public void setEY(double y){eY=y;}

public void xyFields()
{
eX = cos*electricField;
eY = sin*electricField;
}

public String toString()
{

String out=Double.toString(electricField);
return out;
 }
}

