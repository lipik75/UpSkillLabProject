package xml.sax;

import org.xml.sax.SAXException;
import xml.CatalogBook;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Parser {

    public CatalogBook parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Open sax parsing error: " + e.toString());
            return null;
        }
        File file = new File("catalog.xml");
        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("SAX parsing error: " + e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("IO parsing error: " + e.toString());
            return null;
        }


        return handler.getCatalogBook();
    }
}
