package plugins;

import flumtter4j.Dcallback;
import twitter4j.StatusDeletionNotice;

public class delete implements Dcallback.Callbacks{
	
	public void setCallback(){
		flumtter4j.Dcallback.dcallback.setCallbacks(this);
	}

	@Override
	public void callbackMethod(StatusDeletionNotice object) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(object.getUserId());
	}
}
