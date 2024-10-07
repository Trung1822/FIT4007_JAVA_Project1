package FIT4007_JAVA_OOP.Loan;

import java.util.Date;

public class Loan {
    private String loanId;
    private String bookId;
    private String reader_Id;
    private Date loanDate;
    private Date dueDate;

    public Loan(String loanId, String bookId, String readerId, Date loanDate, Date dueDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.reader_Id = readerId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReaderId() {
        return reader_Id;
    }

    public void setReaderId(String readerId) {
        this.reader_Id = readerId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
