package book;

public class Books {
    private int id;
    private String title;
    private String author;
    private int publicationYear; // Năm xuất bản
    private String category; // Thể loại
    private int copies; // Số lượng sách
    private String location; // Vị trí lưu trữ trong thư viện

    // Constructor
    public Books(int id, String title, String author, int publicationYear, String category, int copies, String location) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.category = category;
        this.copies = copies;
        this.location = location;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Kiểm tra sách còn có sẵn không
    public boolean isAvailable() {
        return copies > 0;
    }

    // Mượn sách
    public void borrowBook() {
        if (isAvailable()) {
            copies--;
        }
    }

    // Trả sách
    public void returnBook() {
        copies++;
    }

    @Override
    public String toString() {
        return String.format("Sách [ID: %d, Tên: %s, Tác giả: %s, Năm xuất bản: %d, Thể loại: %s, Số lượng: %d, Vị trí: %s]",
                id, title, author, publicationYear, category, copies, location);
    }
}
