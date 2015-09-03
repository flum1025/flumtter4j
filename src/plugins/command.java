package plugins;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import flumtter4j.Comcallback;
import flumtter4j.Streaming;
import flumtter4j.color;
import flumtter4j.twitter;

public class command implements Comcallback.Callbacks{
	private Pattern r = Pattern.compile("^r\\s(\\d)\\s(.*)");
	private Pattern t = Pattern.compile("^t\\s(\\d)");
	private Pattern f = Pattern.compile("^f\\s(\\d)");
	private Pattern n = Pattern.compile("^n\\s(.*)");
	private Pattern d = Pattern.compile("^d\\s(@[A-Za-z0-9_]{1,15})\\s(.*)");
	
	public void setCallback(){
		flumtter4j.Comcallback.comcallback.setCallbacks(this);
	}

	@Override
	public void callbackMethod(String command) {
		// TODO 自動生成されたメソッド・スタブ
		if (command.startsWith("r")){
			Matcher m = r.matcher(command);
			if (m.find()){
				long id = Streaming.statues.get(Integer.parseInt(m.group(1))).getId();
				String sc = Streaming.statues.get(Integer.parseInt(m.group(1))).getUser().getScreenName();
				twitter.reply(id, "@" + sc + " " + m.group(2));
			}
		}else if(command.startsWith("t")){
			Matcher m = t.matcher(command);
			if (m.find()){
				long id = Streaming.statues.get(Integer.parseInt(m.group(1))).getId();
				twitter.retweet(id);
			}
		}else if(command.startsWith("f")){
			Matcher m = f.matcher(command);
			if (m.find()){
				long id = Streaming.statues.get(Integer.parseInt(m.group(1))).getId();
				twitter.favorite(id);
			}
		}else if(command.startsWith("n")){
			Matcher m = n.matcher(command);
			if (m.find()){
				twitter.update(m.group(1));
			}
		}else if(command.startsWith("d")){
			Matcher m = d.matcher(command);
			if (m.find()){
				twitter.directmessage(m.group(1), m.group(2));
			}
		}else{
			System.out.println(color.text_color("Command not foune", "red"));
		}
	}
}
