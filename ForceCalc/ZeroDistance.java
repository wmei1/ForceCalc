package MainClass.SubClass.Exceptions;
public class ZeroDistance extends Exception
{
public ZeroDistance(){super();}
public String getMessage()
{return "The distance is zero";}

public String toString()
{return "ZeroDistanceException thrown";}
}