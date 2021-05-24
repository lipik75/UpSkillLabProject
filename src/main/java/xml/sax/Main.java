package xml.sax;

import xml.CatalogBook;


public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        CatalogBook catalogBook = parser.parse();

        System.out.println("Catalog " + catalogBook.toString());
    }
}
