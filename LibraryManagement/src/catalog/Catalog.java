package catalog;

import book.Books;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Books> catalogBooks;
    private String catalogName;

    // Constructor
    public Catalog(String catalogName) {
        this.catalogName = catalogName;
        this.catalogBooks = new ArrayList<>();
    }

    // Thêm sách vào danh mục
    public void addBookToCatalog(Books book) {
        catalogBooks.add(book);
    }

    // Xóa sách khỏi danh mục
    public void removeBookFromCatalog(int bookId) {
        catalogBooks.removeIf(book -> book.getId() == bookId);
    }

    // Cập nhật thông tin sách trong danh mục
    public void updateBookInCatalog(int bookId, String newLocation, int newCopies, int newPublicationYear) {
        for (Books book : catalogBooks) {
            if (book.getId() == bookId) {
                book.setLocation(newLocation);
                book.setCopies(newCopies);
                book.setPublicationYear(newPublicationYear);
                System.out.println("Thông tin sách đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID đã cho.");
    }

    // Tìm kiếm sách theo tiêu chí (ID, tác giả, hoặc thể loại)
    public void searchBooks(String keyword) {
        System.out.println("Kết quả tìm kiếm:");
        for (Books book : catalogBooks) {
            if (String.valueOf(book.getId()).equals(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword) ||
                    book.getCategory().equalsIgnoreCase(keyword)) {
                System.out.println(book);
            }
        }
    }

    // Hiển thị tất cả sách trong danh mục
    public void showCatalogBooks() {
        System.out.println("Danh mục: " + catalogName);
        for (Books book : catalogBooks) {
            System.out.println(book);
        }
    }

    // Getter và Setter
    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public List<Books> getCatalogBooks() {
        return catalogBooks;
    }

    public void setCatalogBooks(List<Books> catalogBooks) {
        this.catalogBooks = catalogBooks;
    }
}
