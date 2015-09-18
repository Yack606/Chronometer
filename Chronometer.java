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
        
  	Date today = new Date();
  
  
    
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
    
    public int stop(){
    	lastHour = today.getHours();
    	difHour = lastHour - startHour;
    	
    	lastMin = today.getMinutes();   	
    	difMin = lastMin - startMin;

    	
    	lastSec = today.getSeconds();   	
    	difSec = lastSec - startSec;
    }
    
    public int pause(){
    	
    }

}


public class Main {
	

	public static void main(String args[]) {

        
    }
}
