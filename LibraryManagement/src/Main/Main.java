import book.Books;
import catalog.Catalog;
import librarymanagement.LibraryManagement;
import Reader.Reader;
import Reader.ReaderManagement;
import transaction.Transaction;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagement library = new LibraryManagement();
        ReaderManagement readerManagement = new ReaderManagement();
        Catalog catalog = new Catalog("Thư viện chính");

        while (true) {
            System.out.println("\n--- Quản lý Thư viện ---");
            System.out.println("1. Quản lý sách");
            System.out.println("2. Quản lý độc giả");
            System.out.println("3. Quản lý danh mục");
            System.out.println("4. Quản lý giao dịch");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1: // Quản lý sách
                    manageBooks(scanner, library, catalog);
                    break;

                case 2: // Quản lý độc giả
                    manageReaders(scanner, readerManagement);
                    break;

                case 3: // Quản lý danh mục
                    manageCatalog(scanner, catalog);
                    break;

                case 4: // Quản lý giao dịch
                    manageTransactions(scanner, library, readerManagement);
                    break;

                case 0: // Thoát
                    System.out.println("Cảm ơn đã sử dụng hệ thống. Tạm biệt!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        }
    }

    // Quản lý sách
    public static void manageBooks(Scanner scanner, LibraryManagement library, Catalog catalog) {
        System.out.println("\n--- Quản lý Sách ---");
        System.out.println("1. Thêm sách mới");
        System.out.println("2. Xóa sách");
        System.out.println("3. Cập nhật thông tin sách");
        System.out.println("4. Tìm kiếm sách");
        System.out.print("Chọn một tùy chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1: // Thêm sách mới
                System.out.println("\n--- Thêm sách mới ---");
                System.out.print("Nhập ID sách: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                System.out.print("Nhập tên sách: ");
                String title = scanner.nextLine();
                System.out.print("Nhập tác giả: ");
                String author = scanner.nextLine();
                System.out.print("Nhập năm xuất bản: ");
                int publicationYear = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nhập thể loại: ");
                String category = scanner.nextLine();
                System.out.print("Nhập số lượng sách: ");
                int copies = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nhập vị trí lưu trữ: ");
                String location = scanner.nextLine();

                Books newBook = new Books(id, title, author, publicationYear, category, copies, location);
                catalog.addBookToCatalog(newBook);
                library.addBook(newBook);
                System.out.println("Sách đã được thêm thành công!");
                break;

            case 2: // Xóa sách
                System.out.println("\n--- Xóa sách ---");
                System.out.print("Nhập ID sách cần xóa: ");
                int bookIdToRemove = scanner.nextInt();
                catalog.removeBookFromCatalog(bookIdToRemove);
                library.removeBook(bookIdToRemove);
                System.out.println("Sách đã được xóa thành công (nếu tồn tại).");
                break;

            case 3: // Cập nhật thông tin sách
                System.out.println("\n--- Cập nhật thông tin sách ---");
                System.out.print("Nhập ID sách cần cập nhật: ");
                int bookIdToUpdate = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng trống
                System.out.print("Nhập vị trí mới của sách: ");
                String newLocation = scanner.nextLine();
                System.out.print("Nhập số lượng mới: ");
                int newCopies = scanner.nextInt();
                System.out.print("Nhập năm xuất bản mới: ");
                int newPublicationYear = scanner.nextInt();

                catalog.updateBookInCatalog(bookIdToUpdate, newLocation, newCopies, newPublicationYear);
                break;

            case 4: // Tìm kiếm sách
                System.out.println("\n--- Tìm kiếm sách ---");
                System.out.print("Nhập từ khóa tìm kiếm (ID, tác giả, hoặc thể loại): ");
                String keyword = scanner.nextLine();
                catalog.searchBooks(keyword);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    // Quản lý độc giả
    public static void manageReaders(Scanner scanner, ReaderManagement readerManagement) {
        System.out.println("\n--- Quản lý Độc giả ---");
        System.out.println("1. Thêm độc giả mới");
        System.out.println("2. Hiển thị tất cả độc giả");
        System.out.println("3. Ghi độc giả vào file");
        System.out.println("4. Đọc độc giả từ file");
        System.out.print("Chọn một tùy chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1: // Thêm độc giả mới
                readerManagement.AddReader();
                break;

            case 2: // Hiển thị tất cả độc giả
                readerManagement.showAllReaders();
                break;

            case 3: // Ghi độc giả vào file
                readerManagement.WriteFile();
                break;

            case 4: // Đọc độc giả từ file
                readerManagement.ReadFile();
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    // Quản lý danh mục
    public static void manageCatalog(Scanner scanner, Catalog catalog) {
        System.out.println("\n--- Quản lý Danh mục ---");
        System.out.println("1. Thêm sách vào danh mục");
        System.out.println("2. Xóa sách khỏi danh mục");
        System.out.println("3. Hiển thị sách trong danh mục");
        System.out.print("Chọn một tùy chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1: // Thêm sách vào danh mục
                System.out.println("Chức năng thêm sách vào danh mục đã có trong quản lý sách.");
                break;

            case 2: // Xóa sách khỏi danh mục
                System.out.print("Nhập ID sách cần xóa khỏi danh mục: ");
                int bookIdToRemove = scanner.nextInt();
                catalog.removeBookFromCatalog(bookIdToRemove);
                System.out.println("Đã xóa sách khỏi danh mục (nếu tồn tại).");
                break;

            case 3: // Hiển thị sách trong danh mục
                catalog.showCatalogBooks();
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    // Quản lý giao dịch mượn trả sách
    public static void manageTransactions(Scanner scanner, LibraryManagement library, ReaderManagement readerManagement) {
        System.out.println("\n--- Quản lý Giao dịch ---");
        System.out.println("1. Mượn sách");
        System.out.println("2. Trả sách");
        System.out.println("3. Hiển thị tất cả giao dịch");
        System.out.print("Chọn một tùy chọn: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        switch (choice) {
            case 1: // Mượn sách
                System.out.print("Nhập ID độc giả: ");
                int readerIdBorrow = scanner.nextInt();
                System.out.print("Nhập ID sách muốn mượn: ");
                int bookIdBorrow = scanner.nextInt();

                if (library.borrowBook(readerIdBorrow, bookIdBorrow)) {
                    System.out.println("Mượn sách thành công.");
                } else {
                    System.out.println("Mượn sách thất bại. Kiểm tra lại thông tin.");
                }
                break;

            case 2: // Trả sách
                System.out.print("Nhập ID độc giả: ");
                int readerIdReturn = scanner.nextInt();
                System.out.print("Nhập ID sách muốn trả: ");
                int bookIdReturn = scanner.nextInt();

                if (library.returnBook(readerIdReturn, bookIdReturn)) {
                    System.out.println("Trả sách thành công.");
                } else {
                    System.out.println("Trả sách thất bại. Kiểm tra lại thông tin.");
                }
                break;

            case 3: // Hiển thị tất cả giao dịch
                Transaction.showTransactions();
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }
}
