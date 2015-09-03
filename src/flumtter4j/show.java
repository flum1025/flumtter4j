package flumtter4j;

import java.io.UnsupportedEncodingException;

public class show {
	public show(){
		
	}
	
	public static String indent(int num){
		int x = process.cols;
		x = x - num;
		String str = "";
		for(int i=0; i<x; i++){
			str += " ";
		}
		return str;
	}
	
	public static String line(int num){
		int x = process.cols;
		x = x - num;
		String str = "";
		for(int i=0; i<x; i++){
			str += "-";
		}
		return str;
	}
	
	public static int getByte(String value) {
	    return getByte(value,"Shift_JIS");
	}
	
	public static int getByte(String value, String enc) {
	    if ( value == null || value.length() == 0 )
	        return 0;
	    int ret = 0;
	    try {
	        ret = value.getBytes(enc).length;
	    } catch ( UnsupportedEncodingException e ) {
	        ret = 0;
	    }
	    return ret;
	}
}
