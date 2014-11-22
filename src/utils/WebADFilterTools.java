package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebADFilterTools {
	
	public static List<String> doRequest(String urlStr,boolean isUTF_8) throws IOException{
		List<String> list = new ArrayList<String>();
		URL url = new URL(urlStr);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		String currentLine = "";
		InputStream requestStream = connection.getInputStream();
		BufferedReader htmlReader = null;
		if (isUTF_8) {
			htmlReader = new BufferedReader(new InputStreamReader(requestStream, "UTF-8"));
		} else {
			htmlReader = new BufferedReader(new InputStreamReader(requestStream, "GBK"));
		}
		while ((currentLine = htmlReader.readLine()) != null) {
			String temp = getHref(currentLine);
			if (temp != null) {
				list.add(temp);
			}
		}
		return list;
	}
	
	private static String getHref(String str) { 
        Pattern pattern = Pattern.compile("<a href=\"http://.*</a>|<a href='/.*</a>|<a href=\"ftp:.*</a>"); 
        Matcher matcher = pattern.matcher(str); 
        if (matcher.find()) 
            return matcher.group(0); 
        return null; 
    } 
}
