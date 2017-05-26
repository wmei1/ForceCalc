	package MainClass;
	import MainClass.SubClass.*;
	import java.io.*;
	import java.util.*;
public class Client
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("what is the name of the txt file?");
		String readscan =scan.nextLine();
		//ArrayList<ArrayList<Charges>> list =new ArrayList<ArrayList<Charges>>();
		ArrayList<Charges> clist = new ArrayList<Charges>();
		ArrayList<Points> plist = new ArrayList<Points>();
		try{

			FileInputStream fis = new FileInputStream(readscan);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String reading;
			while((reading=br.readLine())!=null)
				{	
					StringTokenizer strtok1= new StringTokenizer(reading,",");
					if(reading.charAt(0)=='Q')
					{
					String token=strtok1.nextToken();
					StringTokenizer strtok2= new StringTokenizer(token,":");
					strtok2.nextToken();
					String tok1= strtok2.nextToken();
					int xcoord= Integer.parseInt(tok1);
					String tok2=strtok1.nextToken();
					int ycoord=Integer.parseInt(tok2);
					String tok3=strtok1.nextToken();
					double q= Double.parseDouble(tok3);
					Charges c=new Charges(xcoord,ycoord,q);
					clist.add(c);
					}
					else
						{
						String token=strtok1.nextToken();
						StringTokenizer strtok2= new StringTokenizer(token,":");
						strtok2.nextToken();
						String tok1= strtok2.nextToken();
						String tok2=strtok1.nextToken();
						int xcoord=Integer.parseInt(tok2);
						String tok3=strtok1.nextToken();
						int ycoord=Integer.parseInt(tok3);
						Points p=new Points(tok1,xcoord,ycoord);
						plist.add(p);
						}
				}	
			}
				catch(FileNotFoundException fnf)
					{
						System.out.println("The file was not found");
					}
				catch(IOException ioe)
					{
							System.out.println(ioe.toString()); 
					}
		
		ArrayList<Points> list= new ArrayList<Points>();		
		for(int i=0;i<plist.size();i++)
			{
			ArrayList<Charges> chlist= new ArrayList<Charges>(); 
			for(int j=0;j<clist.size();j++)
			{
			chlist.add(clist.get(j));
			}
			Points point = new Points();
			point = plist.get(i);
			point.setCArray(chlist);
			list.add(point);
			}
		

			Calculations calc=new Calculations();
			calc.setPointArray(list);
			calc.distanceCalc();
			calc.eField();
			calc.chargeAngle();
			calc.pointResults();


		for(int j=0;j<plist.size();j++)
			{
			
			Points p = calc.getPointArray().get(j);
			p.printString();
			//System.out.println(p.getX()+","+p.getY());
			}
			//System.out.println(calc.getPointArray().get(0).getCArray().get(0).getDistance());
		
		try
		{
			FileOutputStream fos= new FileOutputStream("file.ser",false);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			
			for(int k=0;k<plist.size();k++)
			{
			Points p= calc.getPointArray().get(k);
			Object str = p.toString();
			oos.writeObject(str);
			}
			fos.close();
		}
		catch(IOException ioe)
			{
			System.out.println(ioe.toString());
			}
			
		System.out.println("Type yes to read the .ser file");
		String scanask= scan.nextLine();
		
		if(scanask.equals("yes"))
		{
			try
			{
			FileInputStream fis = new FileInputStream("file.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true)
			{
				try
				{
					String line =(String)ois.readObject();
					System.out.println(line);
				
				}
				catch(ClassNotFoundException cnfe){System.out.println("class not found");}
				catch(EOFException eof)
			{
				System.out.println("End of File");
				break;
			}
			}
			fis.close();
			}
			catch(IOException ioe)
			{
			System.out.println("Not found");
					ioe.printStackTrace();
			}
		}
			
	}
}