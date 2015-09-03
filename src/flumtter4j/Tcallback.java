package flumtter4j;

import java.util.ArrayList;

import twitter4j.Status;

public class Tcallback {
	static ArrayList<Callbacks> events = new ArrayList<Callbacks>();
	public static Tcallback tcallback = new Tcallback();
	
	public interface Callbacks {
        public void callbackMethod(Status status);
    }

    public void setCallbacks(Callbacks callbacks){
    	Tcallback.events.add(callbacks);
    }

    public void on_TweetObject(Status status){
    	for(int i = 0; i < Tcallback.events.size(); i++){
    		Callbacks callbacks = Tcallback.events.get(i);
    		callbacks.callbackMethod(status);
    	}
    }
}
