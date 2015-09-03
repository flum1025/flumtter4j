package flumtter4j;

import java.util.ArrayList;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.User;
import twitter4j.UserStreamAdapter;

public class Streaming extends UserStreamAdapter {
	public static ArrayList<Status> statues = new ArrayList<Status>();
	
	public void onStatus(Status status){
		statues.add(status);
		Tcallback.tcallback.on_TweetObject(status);
	}
	
	public void onDeletionNotice(StatusDeletionNotice object){
		Dcallback.dcallback.on_DeleteObject(object);
	}
	
	public void onFavorite(User source, User target, Status object){
		statues.add(object);
		Favcallback.favcallback.on_FavoriteObject(source, target, object);
	}
	
	public void onUnfavorite(User source, User target, Status object){
	}
	
	public void onDirectMessage(DirectMessage object){
		DMcallback.dmcallback.on_DirectMessageObject(object);
	}
	
	public void onFollow(User source, User followedUser){
	}
}
