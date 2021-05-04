package xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml.Book;
import xml.CatalogBook;

import java.util.ArrayList;
import java.util.List;

public class SaxParserHandler extends DefaultHandler {

    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_BOOK = "book";
    private static final String TAG_ELEMENT = "element";
    private static final String TAG_AUTHOR = "Author";
    private static final String TAG_TITLE = "Title";
    private static final String TAG_GENRE = "Genre";
    private static final String TAG_PRICE = "Price";
    private static final String TAG_DATE = "PublishDate";
    private static final String TAG_DESCRIPTION = "Description";

    private String author;
    private String title;
    private String genre;
    private double price;
    private String publishDate;
    private String description;


    CatalogBook catalogBook = new CatalogBook();
    private List<Book> bookList = new ArrayList<>();
    private String currentTagName;

    private boolean isElement = false;
    private boolean isBook = false;

    public CatalogBook getCatalogBook() {
        return catalogBook;
    }

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("START document");
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.println("END document");
        catalogBook.setBooks(bookList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println("START element " + qName);
        currentTagName = qName;

        if (currentTagName.equals(TAG_BOOK)) {
            isBook = true;
        } else if (currentTagName.equals(TAG_ELEMENT)) {
            isElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println("END element " + qName);

        if (qName.equals(TAG_BOOK)) {
            isBook = false;
        } else if (qName.equals(TAG_ELEMENT)) {
            isElement = false;

            Book book = new Book(author, title, genre, price, publishDate, description);
            bookList.add(book);
        }

        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        System.out.println("currentTag " + new String(ch, start, length));

        if (currentTagName == null) {
            return;
        }

        if (!isBook && currentTagName.equals(TAG_NAME_MAIN)) {
            catalogBook.setName(new String(ch, start, length));
        }

        if (isBook && isElement) {
            switch (currentTagName) {
                case TAG_AUTHOR: {
                    author = new String(ch, start, length);
                    break;
                }
                case TAG_TITLE: {
                    title = new String(ch, start, length);
                    break;
                }
                case TAG_GENRE: {
                    genre = new String(ch, start, length);
                    break;
                }
                case TAG_PRICE: {
                    price = Double.parseDouble(new String(ch, start, length));
                    break;
                }
                case TAG_DATE: {
                    publishDate = new String(ch, start, length);
                    break;
                }
                case TAG_DESCRIPTION: {
                    description = new String(ch, start, length);
                    break;
                }
            }
        }
    }
}
