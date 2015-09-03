package flumtter4j;

import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.User;

public class Favcallback {
	public static ArrayList<Callbacks> events = new ArrayList<Callbacks>();
	public static Favcallback favcallback = new Favcallback();
	
	public interface Callbacks {
        public void callbackMethod(User source, User target, Status object);
    }

    public void setCallbacks(Callbacks callbacks){
    	Favcallback.events.add(callbacks);
    }

    public void on_FavoriteObject(User source, User target, Status object){
    	for(int i = 0; i < Favcallback.events.size(); i++){
    		Callbacks callbacks = Favcallback.events.get(i);
    		callbacks.callbackMethod(source, target, object);
    	}
    }
}
