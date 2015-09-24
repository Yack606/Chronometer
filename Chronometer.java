import java.util.Date;

public class Chronometer {
  	
  	int startHour;
  	int startMin;
  	int startSec;
  	
  	int interHour;
  	int interMin;
  	int interSec;
  	
  	int lastHour;
  	int lastMin;
  	int lastSec;
  	
  	int difHour;
        int difMin;
        int difSec;
        
        int pauseStartHour;
        int pauseStartMin;
        int pauseStartSec;
        
        int pauseStopHour;
        int pauseStopMin;
        int pauseStopSec;
        
        int pauseDifHour;
        int pauseDifMin;
        int pauseDifSec;
        
        int pauseHour;
        int pauseMin;
        int pauseSec;
        
        boolean pause = false;
        boolean pausePresent = false;
        boolean MethodGO = true;
        
        
  	Date today = new Date();
  
  
    public boolean GO(){
    	return MethodGO;
    }
    public void start(){
    	startHour = today.getHours();
    	startMin = today.getMinutes();
    	startSec = today.getSeconds();
    	
    	lastHour = startHour;
    	lastMin = startMin;
    	lastSec = startSec;
    	
    	System.out.println("Laikas pradetas skaiciuoti: "+startHour+":"+startMin+":"+startSec);
    	}
  
    public void getIntermediate(){
    	if pause == false && pausePresent == false{
    		interHour = today.getHours();
    		interMin = today.getMinutes();
    		interSec = today.getSeconds();
    		
    		difHour = interHour - lastHour;
    		lastHour = interHour;
    		
    		difMin = interMin - lastMin;
    		lastMin = interMin;
    		
    		difSec = interSec - lastSec;
    		lastSec = interSec;
    		
    		System.out.println("Intervalo trukme : "+difHour+":"+difMin+":"+difSec);
    	}
    	else if pause == false && pausePresent == true{
    		interHour = today.getHours();
    		interMin = today.getMinutes();
    		interSec = today.getSeconds();
    		
    		difHour = interHour - lastHour - pauseHour;
    		lastHour = interHour;
    		
    		difMin = interMin - lastMin - pauseMin;
    		lastMin = interMin;
    		
    		difSec = interSec - lastSec - pauseSec;
    		lastSec = interSec;
    		
    		System.out.println("Intervalo trukme : "+difHour+":"+difMin+":"+difSec);
    		
    		pausePresent = false;
    		
    	else{
    		System.out.println("Isjunkite PAUSE");
    	}
    }
      
    }
    
    public void stop(){
    	if pause == false {
    		lastHour = today.getHours();
    		difHour = lastHour - startHour - pauseHour;
    		
    		lastMin = today.getMinutes();   	
    		difMin = lastMin - startMin - pauseMin;
    		
    		lastSec = today.getSeconds();   	
    		difSec = lastSec - startSec - pauseSec;
    		
    		System.out.println("Galutinio intervalo trukme : "+difHour+":"+difMin+":"+difSec);
    		System.out.println("Laikas buvo sustabdytas : "+pauseHour+":"+pauseMin+":"+pauseSec);
    		
    		MethodGO = false;
    	}
    	else{
    		System.out.println("Isjunkite PAUSE");
    	}
    	
    	
    	
    }
    
    public int pause(){
    	
    	if pause {
    		pauseStopHour = today.getHours();
    		pauseStopMin = today.getMinutes();
    		pauseStopSec = today.getSeconds();
    		
    		pauseDifHour = pauseStopHour - pauseStartHour;
    		pauseDifMin = pauseStopMin - pauseStartMin;
    		pauseDifSec = pauseStopSec - pauseStartSec;
    		
    		pauseHour = pauseHour + pauseDifHour;
    		pauseMin = pauseMin + pauseDifMin;
    		pauseSec = pauseSec + pauseDifSec;
        
    		pause = false;	
    	}
    	
    	else {
    		pauseStartHour = today.getHours();
    		pauseStartMin = pauseStopMin;
    		pauseStartSec = pauseStopSec;
    		
    		
    		pause = true;	
    	}
    	

    	
    }

}


public class Main {
	

	public static void main(String args[]) {
		Chronometer laikas = new Chronometer();
		String word;
		String word2;
		boolean start = true;
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Irasykite:");
		System.out.println("            S - Pradeti skaiciavima.");
		System.out.println("            I - Skaiciuoti intervala nestabdant laiko.");
		System.out.println("            P - Ijungti/Isjungti pauze");
		System.out.println("            T - Sustabdyti laiko skaiciavima");
		
		word = in.nextLine();
		
		while start{
			if word.equals("S"){
				start = false;
				laikas.start();
				while  laikas.GO(){
					System.out.println("Irasykite:");
					System.out.println("            I - Skaiciuoti intervala nestabdant laiko.");
					System.out.println("            P - Ijungti/Isjungti pauze");
					System.out.println("            T - Sustabdyti laiko skaiciavima");
					word2 = in.nextLine();
					switch (word2) {
						case "I": laikas.getIntermediate();
							break;
						case "P": laikas.pause();
							break;
						case "T": laikas.stop();
							break:
						default: System.out.println("Netinkamas pasirinkimas.")
							break;
					}
				
			}
				
			}
			else{
				System.out.println("Norint pradeti, reikia spausti S");
			}
		}

        
    }
}
