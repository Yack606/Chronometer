import java.util.Calendar;
import java.util.Scanner;

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
	  
	  
	  
	  public boolean GO(){
	  	return MethodGO;
	  }
	  public void start(){
		  Calendar cal = Calendar.getInstance();
		  startHour = cal.get(Calendar.HOUR_OF_DAY);
	    	startMin = cal.get(Calendar.MINUTE);
	    	startSec = cal.get(Calendar.SECOND);
	    	
	    	lastHour = startHour;
	    	lastMin = startMin;
	    	lastSec = startSec;
	    	
	    	System.out.println("Laikas pradetas skaiciuoti: "+startHour+":"+startMin+":"+startSec);
	  	
	  }
	  
	    public void getIntermediate(){
	    	if (pause == false && pausePresent == false) {
	    		Calendar cal = Calendar.getInstance();
	    		interHour = cal.get(Calendar.HOUR_OF_DAY);
	    		interMin = cal.get(Calendar.MINUTE);
	    		interSec = cal.get(Calendar.SECOND);
	    		
	    		difHour = interHour - lastHour;
	    		lastHour = interHour;
	    		
	    		difMin = interMin - lastMin;
	    		lastMin = interMin;
	    		
	    		difSec = interSec - lastSec;
	    		lastSec = interSec;
	    		
	    		if(difSec<0){
	    			difMin = difMin - 1;
	    			difSec = difSec + 60;
	    		}
	    		if(difMin<0){
	    			difHour = difHour - 1;
	    			difMin = difMin + 60;
	    		}
	    		
	    		
	    		System.out.println("Intervalo trukme : "+difHour+":"+difMin+":"+difSec);
	    	}
	    	else if (pause == false && pausePresent == true) {
	    		Calendar cal = Calendar.getInstance();
	    		interHour = cal.get(Calendar.HOUR_OF_DAY);
	    		interMin = cal.get(Calendar.MINUTE);
	    		interSec = cal.get(Calendar.SECOND);
	    		
	    		difHour = interHour - lastHour - pauseHour;
	    		lastHour = interHour;
	    		
	    		difMin = interMin - lastMin - pauseMin;
	    		lastMin = interMin;
	    		
	    		difSec = interSec - lastSec - pauseSec;
	    		lastSec = interSec;
	    		
	    		if(difSec<0){
	    			difMin = difMin - 1;
	    			difSec = difSec + 60;
	    		}
	    		if(difMin<0){
	    			difHour = difHour - 1;
	    			difMin = difMin + 60;
	    		}
	    		
	    		System.out.println("Intervalo trukme : "+difHour+":"+difMin+":"+difSec);
	    		
	    		pausePresent = false;
	        }
	    		
	    	else{
	    		System.out.println("Isjunkite PAUSE");
	    	}
	    }
	    
	    public void stop(){
	    	if (pause == false) {
	    		Calendar cal = Calendar.getInstance();
	    		lastHour = cal.get(Calendar.HOUR_OF_DAY);
	    		difHour = lastHour - startHour - pauseHour;
	    		
	    		lastMin = cal.get(Calendar.MINUTE);  	
	    		difMin = lastMin - startMin - pauseMin;
	    		
	    		lastSec = cal.get(Calendar.SECOND);   	
	    		difSec = lastSec - startSec - pauseSec;
	    		
	    		if(difSec<0){
	    			difMin = difMin - 1;
	    			difSec = difSec + 60;
	    		}
	    		if(difMin<0){
	    			difHour = difHour - 1;
	    			difMin = difMin + 60;
	    		}
	    		
	    		System.out.println("Galutinio intervalo trukme : "+difHour+":"+difMin+":"+difSec);
	    		System.out.println("Laikas buvo sustabdytas : "+pauseHour+":"+pauseMin+":"+pauseSec);
	    		MethodGO = false;
	    	}
	    	else{
	    		System.out.println("Isjunkite PAUSE");
	    	}
	    	
	    	
	    	
	    }
	    
	    public void pause(){
	    	
	    	if (pause) {
	    		Calendar cal = Calendar.getInstance();
	    		pauseStopHour = cal.get(Calendar.HOUR_OF_DAY);
	    		pauseStopMin = cal.get(Calendar.MINUTE);
	    		pauseStopSec = cal.get(Calendar.SECOND);
	    		
	    		pauseDifHour = pauseStopHour - pauseStartHour;
	    		pauseDifMin = pauseStopMin - pauseStartMin;
	    		pauseDifSec = pauseStopSec - pauseStartSec;
	    		
	    		if(pauseDifSec<0){
	    			pauseDifMin = pauseDifMin - 1;
	    			pauseDifSec = pauseDifSec + 60;
	    		}
	    		if(pauseDifMin<0){
	    			pauseDifHour = pauseDifHour - 1;
	    			pauseDifMin = pauseDifMin + 60;
	    		}
	    		
	    		pauseHour = pauseHour + pauseDifHour;
	    		pauseMin = pauseMin + pauseDifMin;
	    		pauseSec = pauseSec + pauseDifSec;
	    		
	    		if(pauseSec>60){
	    			pauseSec = pauseSec - 60;
	    			pauseMin = pauseMin + 1;
	    		}
	    		
	    		if(pauseMin>60){
	    			pauseMin = pauseMin - 60;
	    			pauseHour = pauseHour + 1;
	    		}
	    		
	        
	    		pause = false;	
	    		pausePresent = true;
	    		System.out.println("PAUSE isjungta");
	    		
	    	}
	    	
	    	else {
	    		Calendar cal = Calendar.getInstance();
	    		pauseStartHour = cal.get(Calendar.HOUR_OF_DAY);
	    		pauseStartMin = cal.get(Calendar.MINUTE);
	    		pauseStartSec = cal.get(Calendar.SECOND);
	    		
	    		
	    		pause = true;
	    		System.out.println("PAUSE ijungta");
	    	}
	    }

}



public class Main {

	public static void main(String[] args) {
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
		
		while(start){
			word = in.nextLine();
			if (word.equals("S")) {
				start = false;
				laikas.start();
				while(laikas.GO()){
					System.out.println("Irasykite:I,P arba T");
					word2 = in.nextLine();
					switch(word2) {
						case "I": laikas.getIntermediate();
							break;
						case "P": laikas.pause();
							break;
						case "T": laikas.stop();
							break;
						default: System.out.println("Netinkamas pasirinkimas.");
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
