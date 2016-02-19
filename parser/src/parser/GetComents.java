package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class GetComents {
	public static void main(String[] args) throws IOException {
		getComments("http://www.ceneo.pl/38465971");
	}

	public static void getComments(String url) throws IOException {
		Document document = Jsoup.connect(url).get();
		List<String> posComments = new ArrayList<String>();
		List<String> negComments = new ArrayList<String>();
		HtmlToPlainText plainify = new HtmlToPlainText();

		for (Element element : document.getElementsByClass("pros-cell")) {// zalety
			for (Element elem : element.children()) {
				for (Element ele : elem.children()) {
					if (elem != null) {
						posComments.add(plainify.getPlainText(ele));
					}
				}
			}
		}
		for (Element element : document.getElementsByClass("cons-cell")) {// wady
			for (Element elem : element.children()) {
				for (Element ele : elem.children()) {
					if (elem != null) {
						negComments.add(plainify.getPlainText(ele));
					}
				}
			}
		}

		for (Element element : document.getElementsByClass("product-name")) {
			for (Element elem : element
					.getElementsByClass("js_product-h1-link")) {
				String aa = plainify.getPlainText(elem);
				System.out.println(aa);
			}
		}

		System.out.println("Zalety");
		for (String a : posComments) {
			System.out.println(a);
		}
		System.out.println("Wady");
		for (String a : negComments) {
			System.out.println(a);
		}
	}

}