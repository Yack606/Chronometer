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
  	int 
  	Date today = new Date();
  
  
    
    public int start(){
      startHour = today.getHours();
      startMin = today.getMinutes();
      startSec = today.getSeconds();
      
      lastHour = today.getHours();
      lastMin = today.getMinutes();
      lastSec = today.getSeconds();
      
    }
  
  	public int getIntermediate(){
      
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
