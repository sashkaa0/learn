package parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Test {
	public static void main(String[] args) throws IOException,
			ParserConfigurationException, SAXException {

		for (String a : GetRefsOnPage
				.GetRefsOnPage("http://www.ceneo.pl/Faksy")) {
			GetComents.getComments(a);
		}
	}
}