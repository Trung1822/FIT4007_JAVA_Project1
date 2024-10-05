package transaction;

public class Transaction {
    private int readerId;
    private int bookId;
    private String action; // "borrow" hoặc "return"

    public Transaction(int readerId, int bookId, String action) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.action = action;
    }

    public int getReaderId() {
        return readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return String.format("Giao dịch: Độc giả ID: %d, Sách ID: %d, Hành động: %s",
                readerId, bookId, action);
    }
}
