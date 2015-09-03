package flumtter4j;

public class color {
	public static String text_color(String text, String kind){
		String new_text = "";
		switch (kind) {
		case "black":
			new_text = "\u001b[00;30"+"m"+text+" \u001b[00m";
			break;
		case "red":
			new_text = "\u001b[00;31"+"m"+text+" \u001b[00m";
			break;
		case "green":
			new_text = "\u001b[00;32"+"m"+text+" \u001b[00m";
			break;
		case "yellow":
			new_text = "\u001b[00;33"+"m"+text+" \u001b[00m";
			break;
		case "blue":
			new_text = "\u001b[00;34"+"m"+text+" \u001b[00m";
			break;
		case "magenta":
			new_text = "\u001b[00;35"+"m"+text+" \u001b[00m";
			break;
		case "cyan":
			new_text = "\u001b[00;36"+"m"+text+" \u001b[00m";
			break;
		case "white":
			new_text = "\u001b[00;37"+"m"+text+" \u001b[00m";
			break;
		}
		return new_text;
	}
	
	public static String background_color(String text, String kind){
		String new_text = "";
		switch (kind) {
		case "black":
			new_text = "\u001b[00;40"+"m"+text+" \u001b[00m";
			break;
		case "red":
			new_text = "\u001b[00;41"+"m"+text+" \u001b[00m";
			break;
		case "green":
			new_text = "\u001b[00;42"+"m"+text+" \u001b[00m";
			break;
		case "yellow":
			new_text = "\u001b[00;43"+"m"+text+" \u001b[00m";
			break;
		case "blue":
			new_text = "\u001b[00;44"+"m"+text+" \u001b[00m";
			break;
		case "magenta":
			new_text = "\u001b[00;45"+"m"+text+" \u001b[00m";
			break;
		case "cyan":
			new_text = "\u001b[00;46"+"m"+text+" \u001b[00m";
			break;
		case "white":
			new_text = "\u001b[00;47"+"m"+text+" \u001b[00m";
			break;
		}
		return new_text;
	}
	
}
