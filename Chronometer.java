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
  
  
    
    public int start(){
      startHour = today.getHours();
      startMin = today.getMinutes();
      startSec = today.getSeconds();
      
      lastHour = startHour;
      lastMin = startMin;
      lastSec = startSec;
      
    }
  
    public int getIntermediate(){
      interHour = today.getHours();
      interMin = today.getMinutes();
      interSec = today.getSeconds();

      difHour = interHour - lastHour;
      lastHour = interHour;

      difMin = interMin - lastMin;
      lastMin = interMin;

      difSec = interSec - lastSec;
      lastSec = interSec;
    }
  
  	public int stop(){
    	
    }
  	
  	public int pause(){
    	
    }

}


public class Main {
	

	public static void main(String args[]) {

        
    }
}
