package xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.Book;
import xml.CatalogBook;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
parser XML with DOM
 */

public class DomParser {

    public static void main(String[] args) {
        CatalogBook catalogBook = new CatalogBook();


        Document doc;
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.toString());
            return;
        }

        Node catalogNode = doc.getFirstChild();

        NodeList catalogChilds = catalogNode.getChildNodes();

        String catalogName = null;
        Node bookNode = null;

        for (int i = 0; i < catalogChilds.getLength(); i++) {
            if (catalogChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
//            System.out.println(catalogChilds.item(i).getNodeName());

            switch (catalogChilds.item(i).getNodeName()) {
                case "name": {
                    catalogName = catalogChilds.item(i).getTextContent();
//                    System.out.println(catalogName);
                    break;
                }
                case "book": {
                    bookNode = catalogChilds.item(i);
//                    System.out.println(bookNode.getTextContent());
                    break;
                }
            }
        }

        if (bookNode == null) {
            return;
        }

        List<Book> bookList = new ArrayList<>();
        NodeList bookChilds = bookNode.getChildNodes();

        for (int i = 0; i < bookChilds.getLength(); i++) {
            if (bookChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!bookChilds.item(i).getNodeName().equals("element")) {
                continue;
            }

            String author = "";
            String title = "";
            String genre = "";
            double price = 0;
            String publishDate = "";
            String description = "";

            NodeList elementChilds = bookChilds.item(i).getChildNodes();
            for (int j = 0; j < elementChilds.getLength(); j++) {
                if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (elementChilds.item(j).getNodeName()) {
                    case "Author": {
                        author = elementChilds.item(j).getTextContent();
                        break;
                    }
                    case "Title": {
                        title = elementChilds.item(j).getTextContent();
                        break;
                    }
                    case "Genre": {
                        genre = elementChilds.item(j).getTextContent();
                        break;
                    }
                    case "Price": {
                        price = Double.parseDouble(elementChilds.item(j).getTextContent());
                        break;
                    }
                    case "PublishDate": {
                        publishDate = elementChilds.item(j).getTextContent();
                        break;
                    }
                    case "Description": {
                        description = elementChilds.item(j).getTextContent();
                        break;
                    }
                }
            }
            Book book = new Book(author, title, genre, price, publishDate, description);
            bookList.add(book);
        }

        catalogBook.setName(catalogName);
        catalogBook.setBooks(bookList);

        System.out.println("Catalog: " + catalogBook.toString());
    }

    private static Document buildDocument() throws Exception {
        File file = new File("catalog.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
