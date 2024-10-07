package FIT4007_JAVA_OOP.Reader;
import java.util.Scanner;

public class Reader {
    private String reader;
    private String reader_ID;
    private String reader_Name;
    private String reader_Email;
    private String reader_Address;



    public Reader(String reader, String reader_ID, String reader_Name, String reader_Email, String reader_Address, String reader_Phone_number) {
    this.reader = reader;
    this.reader_ID = reader_ID;
    this.reader_Name = reader_Name;
    this.reader_Email = reader_Email;
    this.reader_Address = reader_Address;


    }
    public String getReader() {
        return reader;
    }
    public String getReader_ID() {
        return reader_ID;
    }
    public String getReader_Name() {
        return reader_Name;
    }
    public String getReader_Email() {
        return reader_Email;}
    public String getReader_Address() {
        return reader_Address;
    }
    public void setReader(String reader) {
        this.reader = reader;
    }
    public void setReader_ID(String reader_ID) {
        this.reader_ID = reader_ID;
    }
    public void setReader_Name(String reader_Name) {
        this.reader_Name = reader_Name;
    }
    public void setReader_Email(String reader_Email) {
        this.reader_Email = reader_Email;
    }
    public void setReader_Address(String reader_Address) {
        this.reader_Address = reader_Address;
    }

}