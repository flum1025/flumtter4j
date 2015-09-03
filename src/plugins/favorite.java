package plugins;

import java.text.SimpleDateFormat;

import twitter4j.Status;
import twitter4j.User;
import flumtter4j.Favcallback;
import flumtter4j.Streaming;
import flumtter4j.color;
import flumtter4j.show;

public class favorite implements Favcallback.Callbacks{
	
	public void setCallback(){
		flumtter4j.Favcallback.favcallback.setCallbacks(this);
	}

	@Override
	public void callbackMethod(User source, User target, Status status) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(color.text_color(FavoriteDisplay(status, source, Streaming.statues.size()-1), "yellow"));
	}
	
	public String FavoriteDisplay(Status status, User source_user, int num){
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
