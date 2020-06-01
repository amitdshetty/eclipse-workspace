import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirdAttempt {

	public static void extractUrls(StringBuilder text) throws MalformedURLException, URISyntaxException {
		String urlRegex = "((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher urlMatcher = pattern.matcher(text);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		while (urlMatcher.find()) {
			URI extractURL = new URI(text.substring(urlMatcher.start(0), urlMatcher.end(0)));

			String hashMapKeyValue = extractURL.getHost();
			if (hm.containsKey(hashMapKeyValue)) {
				hm.put(hashMapKeyValue, hm.get(hashMapKeyValue) + 1);
			} else {
				hm.put(hashMapKeyValue, 1);
			}
		}
		System.out.println("Stats:");
		System.out.println(hm.toString());

	}

	public static void main(String[] args) throws Exception {

		long start, end;
		start = System.nanoTime();
		System.out.println(start);

		String absoluteFileName = "/Users/amitshetty/Desktop/HopeLesslyLargeInputFile.txt";
		// File fileObj = new File(absoluteFileName);
		// FileInputStream fis = new FileInputStream(fileObj);
		// InputStreamReader isr = new InputStreamReader(fis);
		// BufferedReader br = new BufferedReader(isr);

		StringBuilder sbldr = new StringBuilder();
		// sbldr.ensureCapacity();
		String line;

		CharSequence http = "http://";
		CharSequence https = "https://";

		// while ((line = br.readLine()) != null) {
		// // process the line
		// // System.out.println(line);
		// if (line.contains(https) || line.contains(http)) {
		//
		// sbldr.append(line);
		// }
		//
		// }

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(absoluteFileName))) {
			byte[] bbuf = new byte[4096];
			int len;
			while ((len = in.read(bbuf)) != -1) {
				String s = new String(bbuf);
				if (s.contains(https) || s.contains(http)) {
					//System.out.println(s);
					//break;
					sbldr.append(s);
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}

		extractUrls(sbldr);
		// br.close();

		end = System.nanoTime();
		System.out.println(end);
		System.out.println("Total time:" + (end - start) / 1_000_000_000 + "seconds");
	}

}