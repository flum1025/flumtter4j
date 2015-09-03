package plugins;

import twitter4j.Status;
import twitter4j.User;
import flumtter4j.Streaming;
import flumtter4j.Tcallback;
import flumtter4j.color;
import flumtter4j.show;
import flumtter4j.twitter;

import java.text.SimpleDateFormat;

public class tweet implements Tcallback.Callbacks{
	
	public void setCallback(){
		flumtter4j.Tcallback.tcallback.setCallbacks(this);
	}

	@Override
	public void callbackMethod(Status status) {
		// TODO 自動生成されたメソッド・スタブ
		if (status.isRetweet()){
			System.out.println(color.text_color(ReTweetDisplay(status.getRetweetedStatus(), status.getUser(), Streaming.statues.size()-1), "blue"));
		}else{
			if (status.getUser().getId() == twitter.user_id){
				System.out.println(color.text_color(TweetDisplay(status, Streaming.statues.size()-1), "cyan"));
			}else{
				System.out.println(TweetDisplay(status, Streaming.statues.size()-1));
			}
		}
	}
	
	public String TweetDisplay(Status status, int num){
		String text = "";
		text += (num + " " + show.line(show.getByte(String.valueOf(num)+1)) + "\n");
		String user = status.getUser().getName() + " (" + status.getUser().getScreenName() + ")";
		text += (user + show.indent(show.getByte(user) + 1) + "\n");
		text += (status.getText() + show.indent(show.getByte(status.getText()) + 1) + "\n\n");
		String created_at = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(status.getCreatedAt());
		String source = status.getSource().replaceAll("<.+?>", "");
		text += (created_at + show.indent(show.getByte(created_at) + show.getByte(source)) + source + "\n");
		return text;
	}
	
	public String ReTweetDisplay(Status status, User source_user, int num){
		String text = "";
		text += (num + " " + show.line(show.getByte(String.valueOf(num))+show.getByte(source_user.getScreenName())+4) + "<< " + source_user.getScreenName() + "\n");
		String user = status.getUser().getName() + " (" + status.getUser().getScreenName() + ")";
		text += (user + show.indent(show.getByte(user) + 1) + "\n");
		text += (status.getText() + show.indent(show.getByte(status.getText()) + 1) + "\n\n");
		String created_at = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(status.getCreatedAt());
		String source = status.getSource().replaceAll("<.+?>", "");
		text += (created_at + show.indent(show.getByte(created_at) + show.getByte(source)) + source + "\n");
		return text;
	}
}
