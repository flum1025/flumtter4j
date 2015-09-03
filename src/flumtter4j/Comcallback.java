package flumtter4j;

import java.util.ArrayList;

public class Comcallback {
	static ArrayList<Callbacks> events = new ArrayList<Callbacks>();
	public static Comcallback comcallback = new Comcallback();
	
	public interface Callbacks {
        public void callbackMethod(String command);
    }

    public void setCallbacks(Callbacks callbacks){
    	Comcallback.events.add(callbacks);
    }

    public void on_Command(String command){
    	for(int i = 0; i < Comcallback.events.size(); i++){
    		Callbacks callbacks = Comcallback.events.get(i);
    		callbacks.callbackMethod(command);
    	}
    }
}
