package flumtter4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class process {
	static int cols;
	static int lines;
	
	public process(){
		try{
			cols = Integer.parseInt(exec(new ProcessBuilder("tput", "cols")));
		}catch(java.lang.NumberFormatException e){
			cols = 80;
		}
		try{
			lines = Integer.parseInt(exec(new ProcessBuilder("tput", "lines")));
		}catch(java.lang.NumberFormatException e){
			lines = 24;
		}
	}
	
	public String exec(ProcessBuilder pb) throws java.lang.NumberFormatException{
		try {
		  Process p = pb.start();
		  p.waitFor();

		  // 実行結果を取得するストリームの種別を出力
		  //System.out.println(pb.redirectInput());

		  try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
		    for(String line = br.readLine(); line != null; line = br.readLine()) {
		      return line;
		    }
		  }
		} catch (IOException | InterruptedException e) {
		  // 例外ハンドリング処理
		}
		return null;
	}
}
