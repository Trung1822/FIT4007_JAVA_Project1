package librarymanagement;

import transaction.Transaction;
import book.Books;
import Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
    private List<Books> books;
    private List<Reader> readers;
    private List<Transaction> transactions;

    // Constructor
    public LibraryManagement() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Thêm sách mới vào danh sách
    public void addBook(Books book) {
        books.add(book);
    }

    // Xóa sách theo ID
    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }

    // Đăng ký độc giả mới
    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    // Tìm sách theo tiêu đề
    public Books findBookByTitle(String title) {
        for (Books book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    // Mượn sách
    public boolean borrowBook(int readerId, int bookId) {
        String readerIdStr = String.valueOf(readerId);  // Chuyển readerId thành chuỗi để so sánh
        for (Reader reader : readers) {
            if (reader.getReader_ID().equals(readerIdStr)) {  // So sánh đúng với kiểu String
                for (Books book : books) {
                    if (book.getId() == bookId && book.isAvailable()) {
                        book.borrowBook();
                        transactions.add(new Transaction(readerId, bookId, "borrow"));
                        return true; // Mượn thành công
                    }
                }
            }
        }
        return false; // Mượn thất bại
    }


    // Trả sách
    public boolean returnBook(int readerId, int bookId) {
        for (Books book : books) {
            if (book.getId() == bookId) {
                book.returnBook();
                transactions.add(new Transaction(readerId, bookId, "return"));
                return true; // Trả thành công
            }
        }
        return false; // Trả thất bại
    }

    // Hiển thị tất cả các sách
    public void showAllBooks() {
        for (Books book : books) {
            System.out.println(book);
        }
    }

    // Hiển thị tất cả các độc giả
    public void showAllReaders() {
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}
