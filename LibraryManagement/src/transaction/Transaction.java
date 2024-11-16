package transaction;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int readerId;
    private int bookId;
    private String action; // "borrow" hoặc "return"

    // Danh sách giao dịch (dùng để lưu trữ tất cả các giao dịch)
    private static List<Transaction> transactions = new ArrayList<>();

    // Constructor
    public Transaction(int readerId, int bookId, String action) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.action = action;
        // Thêm giao dịch vào danh sách khi khởi tạo
        transactions.add(this);
    }

    // Getter
    public int getReaderId() {
        return readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    // Phương thức để hiển thị tất cả giao dịch
    public static void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Hiện không có giao dịch nào.");
        } else {
            System.out.println("Danh sách giao dịch:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    // Phương thức toString để hiển thị thông tin giao dịch
    @Override
    public String toString() {
        return String.format("Giao dịch: Độc giả ID: %d, Sách ID: %d, Hành động: %s",
                readerId, bookId, action);
    }
}
