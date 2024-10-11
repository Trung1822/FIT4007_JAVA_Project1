package Reader;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ReaderManagement {
    private List<Reader> ReaderList;
    private Scanner scanner;

    public ReaderManagement() {
        ReaderList = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    public void AddReader() {
        System.out.println("Enter Reader Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Reader ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter Reader Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Reader Address: ");
        String address = scanner.nextLine();
        scanner.nextLine();
        ReaderList.add(new Reader(name, id, email, address));
    }

    /* public void RemoveReader() {

     }*/
    public void WriteFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("ReaderStorage.txt", true))) {
            outputStream.writeObject(ReaderList);
            System.out.println("Write Done");
        } catch (IOException e) {
            System.out.println("Cannot enter File ");
            e.printStackTrace();
        }
    }

    public void ReadFile() {
        ReaderList.clear();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ReaderStorage.txt"))) {
            while (true) {
                try {
                    @SuppressWarnings("unchecked")
                    List<Reader> rl = (List<Reader>) inputStream.readObject();
                    ReaderList.addAll(rl);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Done");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot enter File :");
            e.printStackTrace();
        }

    }
}
