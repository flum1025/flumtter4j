package plugins;

import java.text.SimpleDateFormat;

import twitter4j.DirectMessage;
import twitter4j.Status;
import flumtter4j.DMcallback;
import flumtter4j.color;
import flumtter4j.show;

public class dm  implements DMcallback.Callbacks{

	public void setCallback(){
		flumtter4j.DMcallback.dmcallback.setCallbacks(this);
	}

	@Override
	public void callbackMethod(DirectMessage object) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(color.text_color(DMDisplay(object), "magenta"));
	}
	
	public String DMDisplay(DirectMessage object){
		String text = "";
		text += (show.line(0) + "\n");
		//String user = status.getUser().getName() + " (" + status.getUser().getScreenName() + ")";
		String user = object.getSender().getName() + " (" + object.getSenderScreenName() + ")";
		text += (user + show.indent(show.getByte(user) + 1) + "\n");
		text += (object.getText() + show.indent(show.getByte(object.getText()) + 1) + "\n\n");
		String created_at = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(object.getCreatedAt());
		text += (created_at + show.indent(show.getByte(created_at)) + "\n");
		return text;
	}
}
