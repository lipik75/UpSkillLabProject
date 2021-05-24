package xml;

import java.util.List;

public class CatalogBook {

    private String name;
    private List<Book> books;

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "CatalogBook{" +
                "name='" + name + '\'' +
                ", books=" + books + '\'' + '}' + '\n';
    }
}
