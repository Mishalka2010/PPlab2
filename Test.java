package pack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayDeque;
import java.util.Date;

public class Test
{
	public static void main (String args[])
	{
		Test_Execution();
		Test_Generation();
	}

	public static void Test_Execution()
	{
		System.out.println("[Execution test]");
		
		BlockingQueue<Location> qIn = new LinkedBlockingQueue<Location>();
		ArrayDeque<Location> qOut = new ArrayDeque<Location>();
		
		Task task = new Task(qIn);
		Date date = new Date();
		Location loc;
		
		Task_executor taskExecutor = new Task_executor(task,qIn,qOut,0);
		Thread threadExecutor = new Thread(taskExecutor);
		
		qIn.add(new Location("",0,date,"Moscow",""));
		qIn.add(new Location("",1,date,"Belgorod",""));
		qIn.add(new Location("",2,date,"Rostov",""));
		qIn.add(new Location("",3,date,"Kazan",""));
		qIn.add(new Location("",4,date,"Washington",""));
		
		threadExecutor.start();
		
		while (!qIn.isEmpty())
		{
			try {
			Thread.sleep(100);}
		catch (InterruptedException e){
			e.printStackTrace();}
            
		}
		taskExecutor.Close();
		try {
			threadExecutor.join();}
		catch (InterruptedException e){
			e.printStackTrace();}
		
		loc = qOut.poll();
		if (loc!=null){
			if (loc.date!=date||loc.city!="Moscow"||loc.weather=="")
			System.out.println("Moscow wrong"); else System.out.println("Moscow ok;");}
		else
			System.out.println("Moscow wrong");
		loc = qOut.poll();
		if (loc!=null){
			if (loc.date!=date||loc.city!="Belgorod"||loc.weather=="")
			System.out.println("Belgorod wrong"); else System.out.println("Belgorod ok;");}
		else
			System.out.println("Belgorod wrong");
		loc = qOut.poll();
		if (loc!=null){
			if (loc.date!=date||loc.city!="Rostov"||loc.weather=="")
			System.out.println("Rostov wrong"); else System.out.println("Rostov ok;");}
		else
			System.out.println("Rostov wrong");
		loc = qOut.poll();
		if (loc!=null){
			if (loc.date!=date||loc.city!="Kazan"||loc.weather=="")
			System.out.println("Kazan wrong"); else System.out.println("Kazan ok;");}
		else
			System.out.println("Kazan wrong");
		loc = qOut.poll();
		if (loc!=null){
			if (loc.date!=date||loc.city!="Washington"||loc.weather=="")
			System.out.println("Washington wrong"); else System.out.println("Washington ok;");}
		else
			System.out.println("Washington wrong");
		if (!qOut.isEmpty()||!qIn.isEmpty())
			System.out.println("Size ok;");
		System.out.println();
	}
	
	public static void Test_Generation()
	{
		System.out.println("[Generator test]");
		
		BlockingQueue<Location> qIn = new LinkedBlockingQueue<Location>();
		Task task = new Task(qIn);
		Location loc;
		
		int elementNumber = 1000;
		Task_generator taskGenerator = new Task_generator(task,qIn, 1000, 0);
		Thread threadGenerator = new Thread(taskGenerator);
		threadGenerator.start();
		try {
			threadGenerator.join();}
		catch (InterruptedException e){
			e.printStackTrace();}
		
		assert(elementNumber==qIn.size());
		
		int Moscow = 0, Saint_Petersburg = 0, Berlin = 0, Vilnus = 0, Saratov = 0, Belgorod = 0, Ekaterinburg = 0, Tambov = 0, New_York = 0, Rostov = 0, Washington = 0, Novosibirsk = 0, Nizhny_Novgorod = 0, Kazan = 0;
		System.out.println("Elements number: " + qIn.size());
		
		while (!qIn.isEmpty())
		{
			loc = qIn.poll();
			if (loc.city == "Moscow")
				Moscow++;
			if (loc.city == "Saint Petersburg")
				Saint_Petersburg++;
			if (loc.city == "Berlin")
				Berlin++;
			if (loc.city == "Vilnus")
				Vilnus++;
			if (loc.city == "Saratov")
				Saratov++;
			if (loc.city == "Belgorod")
				Belgorod++;
			if (loc.city == "Ekaterinburg")
				Ekaterinburg++;
			if (loc.city == "Tambov")
				Tambov++;
			if (loc.city == "New York")
				New_York++;
			if (loc.city == "Rostov")
				Rostov++;
			if (loc.city == "Washington")
				Washington++;
			if (loc.city == "Novosibirsk")
				Novosibirsk++;
			if (loc.city == "Nizhny Novgorod")
				Nizhny_Novgorod++;
			if (loc.city == "Kazan")
				Kazan++;
		}
		if (Moscow > 0)
			System.out.println("Moscow ok; ");
		else 
			System.out.println("\n\nMoscow failed;\n");
		if (Saint_Petersburg > 0)
			System.out.println("Saint_Petersburg ok; ");
		else
			System.out.println("\n\nSaint_Petersburg failed;\n");
		if (Berlin > 0)
			System.out.println("Berlin ok; ");
		else 
			System.out.println("\n\nBerlin failed;\n");
		if (Vilnus > 0)
			System.out.println("Vilnus ok; ");
		else 
			System.out.println("\n\nVilnus failed;\n");
		if (Saratov > 0)
			System.out.println("Saratov ok; ");
		else
			System.out.println("\n\nSaratov failed;\n");
		if (Belgorod > 0)
			System.out.println("Belgorod ok; ");
		else 
			System.out.println("\n\nBelgorod failed;\n");
		if (Ekaterinburg > 0)
			System.out.println("Ekaterinburg ok; ");
		else
			System.out.println("\n\nEkaterinburg failed;\n");
		if (Tambov > 0)
			System.out.println("Tambov ok; ");
		else
			System.out.println("\n\nTambov failed;\n");
		if (New_York > 0)
			System.out.println("New York ok; ");
		else
			System.out.println("\n\nNew York failed;\n");
		if (Rostov > 0)
			System.out.println("Rostov ok; ");
		else
			System.out.println("\n\nRostov failed;\n");
		if (Washington > 0)
			System.out.println("Washington ok; ");
		else
			System.out.println("\n\nWashington failed;\n");
		if (Novosibirsk > 0)
			System.out.println("Novosibirsk ok; ");
		else
			System.out.println("\n\nNovosibirsk failed;\n");
		if (Nizhny_Novgorod > 0)
			System.out.println("Nizniy Novgorod ok; ");
		else
			System.out.println("\n\nNizniy Novgorod failed;\n");
		if (Kazan > 0)
			System.out.println("Kazan ok; ");
		else
			System.out.println("\n\nKazan failed;\n");
		System.out.println();
	}
}