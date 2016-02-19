package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.xml.sax.SAXException;

public class GetRefsOnPage {
	public static void main(String[] args) throws IOException,
			ParserConfigurationException, SAXException {
		GetRefsOnPage("http://www.ceneo.pl/Faksy");

	}

	public static List<String> GetRefsOnPage(String url) throws IOException,
			ParserConfigurationException, SAXException {
		int i = 1;
		Document document = Jsoup.connect(url).get();
		List<String> refference = new ArrayList<String>();
		for (Element element : document.getElementsByClass("js_conv").select(
				"a[href]")) {
			if (i > 4) {
				refference.add(element.attr("abs:href"));
				System.out.println(element.attr("abs:href"));
			}
			i++;
			System.out.println(i);
		}
		try {
			GetRefsOnPage(getRReff(url));
		} catch (Exception e) {
			System.out.println("end");
		}
		return refference;

	}

	static String getRReff(String url) throws IOException,
			ParserConfigurationException, SAXException {
		URL urll = new URL(url);
		URLConnection urlConnection = urll.openConnection();
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream()));
		StringBuilder lines = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			lines.append(line);
		}
		Document document = Jsoup.parse(lines.toString());
		String hiprefference = null;
		for (Element element : document.getElementsByClass("pagination")) {
			for (Element elemen : element.getElementsByClass("arrow-next")
					.select("a[href]")) {
				hiprefference = elemen.attr("href");
			}
		}
		if (!hiprefference.isEmpty()) {
			return "http://www.ceneo.pl" + hiprefference;
		} else
			return hiprefference;
	}
}

/*
 * URL urll = new URL(url); URLConnection connection = urll.openConnection();
 * BufferedReader reader = new BufferedReader(new InputStreamReader(
 * connection.getInputStream()));
 */