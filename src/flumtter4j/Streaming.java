package flumtter4j;

import java.util.ArrayList;

import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.User;
import twitter4j.UserStreamAdapter;

public class Streaming extends UserStreamAdapter {
	public static ArrayList<Status> statues = new ArrayList<Status>();
	
	@Override
	public void onStatus(Status status){
		statues.add(status);
		Tcallback.tcallback.on_TweetObject(status);
	}
	
	@Override
	public void onDeletionNotice(StatusDeletionNotice object){
		Dcallback.dcallback.on_DeleteObject(object);
	}
	
	@Override
	public void onFavorite(User source, User target, Status object){
		statues.add(object);
		Favcallback.favcallback.on_FavoriteObject(source, target, object);
	}
	
	@Override
	public void onUnfavorite(User source, User target, Status object){
	}
	
	@Override
	public void onDirectMessage(DirectMessage object){
		DMcallback.dmcallback.on_DirectMessageObject(object);
	}
	
	@Override
	public void onFollow(User source, User followedUser){
	}
}
