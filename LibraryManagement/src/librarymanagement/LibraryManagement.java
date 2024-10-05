package librarymanagement;

import java.util.ArrayList;
import java.util.List;

import reader.Reader;
import book.Book;
import transaction.Transaction;

public class LibraryManagement {
    private List<Book> books;
    private List<Reader> readers;
    private List<Transaction> transactions;

    public LibraryManagement() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public boolean borrowBook(int readerId, int bookId) {
        for (Reader reader : readers) {
            if (reader.getReaderId().equals(readerId)) {
                for (Book book : books) {
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

    public boolean returnBook(int readerId, int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.returnBook();
                transactions.add(new Transaction(readerId, bookId, "return"));
                return true; // Trả thành công
            }
        }
        return false; // Trả thất bại
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showAllReaders() {
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}
