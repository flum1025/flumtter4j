package flumtter4j;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class twitter {
	private static Twitter twitter = new TwitterFactory().getInstance();
	public static long user_id;
	
	public twitter(){
		try {
			user_id = twitter.getId();
		} catch (IllegalStateException | TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		TwitterStream stream = new TwitterStreamFactory().getInstance();
		stream.addListener(new Streaming());
		stream.user();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println(color.text_color("shudown streaming......", "red"));
				stream.shutdown();
			}
		});
	}
	
	public static void update(String text){
		try {
			twitter.updateStatus(text);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void reply(long id, String text){
		StatusUpdate su = new StatusUpdate(text);
		su.setInReplyToStatusId(id);
		try {
			twitter.updateStatus(su);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void retweet(long id){
		try {
			twitter.retweetStatus(id);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void favorite(long id){
		try {
			twitter.createFavorite(id);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static void directmessage(String sc, String text){
		try {
			twitter.sendDirectMessage(sc, text);
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
