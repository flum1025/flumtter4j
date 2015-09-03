package flumtter4j;

import java.util.ArrayList;

import twitter4j.DirectMessage;

public class DMcallback {
	public static ArrayList<Callbacks> events = new ArrayList<Callbacks>();
	public static DMcallback dmcallback = new DMcallback();
	
	public interface Callbacks {
        public void callbackMethod(DirectMessage object);
    }

    public void setCallbacks(Callbacks callbacks){
    	DMcallback.events.add(callbacks);
    }

    public void on_DirectMessageObject(DirectMessage object){
    	for(int i = 0; i < DMcallback.events.size(); i++){
    		Callbacks callbacks = DMcallback.events.get(i);
    		callbacks.callbackMethod(object);
    	}
    }
}
