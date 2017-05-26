package MainClass.SubClass.SuperClass;

public abstract class Coordinate
{
int x;
int y;

public Coordinate()
{}
public Coordinate(int x1, int y1)
{
x=x1;
y=y1;
}

public int getX()
{return x;}
public void setX(int x1)
{x=x1;}
public int getY()
{return y;}
public void setY(int y1)
{y=y1;}

public String toString()
{return "The x-cord:"+x+" The y-cord:"+y;}
}