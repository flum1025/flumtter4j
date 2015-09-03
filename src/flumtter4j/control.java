package flumtter4j;

import java.io.Console;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.BufferedReader;

public class control extends Thread{
	private String command;

	public static void func() {
        control _control = new control();
        _control.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				System.out.println(color.text_color("killing control()......", "red"));
				_control.stop();
			}
		});
    }
	public void run(){
		Console console = System.console();
		while(true){
			command = String.valueOf(console.readPassword());
			Comcallback.comcallback.on_Command(command);
		}
	}
	/*
	public void run(){ //eclipseテスト用
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try {
				command = reader.readLine();
			} catch (IOException e) {} 
			Comcallback.comcallback.on_Command(command);
		}
	}
	*/
}