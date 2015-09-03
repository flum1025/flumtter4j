package flumtter4j;

import java.util.ArrayList;

import twitter4j.StatusDeletionNotice;

public class Dcallback {
	static ArrayList<Callbacks> events = new ArrayList<Callbacks>();
	public static Dcallback dcallback = new Dcallback();
	
	public interface Callbacks {
        public void callbackMethod(StatusDeletionNotice object);
    }

    public void setCallbacks(Callbacks callbacks){
    	Dcallback.events.add(callbacks);
    }

    public void on_DeleteObject(StatusDeletionNotice object){
    	for(int i = 0; i < Dcallback.events.size(); i++){
    		Callbacks callbacks = Dcallback.events.get(i);
    		callbacks.callbackMethod(object);
    	}
    }
}
