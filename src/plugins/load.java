package plugins;

//import java.io.File;
//import java.lang.reflect.Array;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class load {
	private ArrayList<Class> cls = new ArrayList<Class>();
	
	public load(){
		cls.add(tweet.class);
		cls.add(delete.class);
		cls.add(dm.class);
		cls.add(favorite.class);
		cls.add(command.class);
		
		Method method = null;
		for(int i=0; i<this.cls.size(); i++){
			Class cl = this.cls.get(i);
			try {
				method = cl.getMethod("setCallback");
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			try {
				method.invoke(cl.newInstance());
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | InstantiationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	
	/*	jarにすると死ぬ
	public load(){
		File file = new File("./src/plugins");
		File files[] = file.listFiles();
		Pattern pattern = Pattern.compile("(.+).java");
		for(int i=0; i<files.length; i++){
			String filename = new File(files[i].getName()).getName();
			if(!filename.equals("load.java")){
				Matcher m = pattern.matcher(filename);
				if(m.find()){
					Class cl = null;
					try {
						cl = Class.forName("plugins."+m.group(1));
					} catch (ClassNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					Method method = null;
					try {
						method = cl.getMethod("setCallback");
					} catch (NoSuchMethodException | SecurityException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					try {
						method.invoke(cl.newInstance());
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException
							| InstantiationException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			}
		}
	}
	*/
}
