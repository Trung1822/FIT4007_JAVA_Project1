package Main;

import Main_Books.Main_Books;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Tạo một số đối tượng Book
        Main_Books b01 = new Main_Books(1, "Book1", "A1", 3);
        Main_Books b02 = new Main_Books(2, "Book2", "A2", 5);
        Main_Books b03 = new Main_Books(3, "Book3", "A3", 2);

        // Scanner để nhận input từ người dùng
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Quản lý Thư viện ---");
            System.out.println("1. Hiển thị danh sách sách");
            System.out.println("2. Mượn sách");
            System.out.println("3. Trả sách");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Hiển thị danh sách sách
                    System.out.println("\nDanh sách sách:");
                    System.out.println(b01);
                    System.out.println(b02);
                    System.out.println(b03);
                    break;

                case 2:
                    // Mượn sách
                    System.out.print("\nNhập ID sách muốn mượn: ");
                    int borrowId = scanner.nextInt();
                    if (borrowId == 1) {
                        if (b01.borrowBook()) {
                            System.out.println("Mượn sách thành công.");
                        } else {
                            System.out.println("Sách đã hết.");
                        }
                    } else if (borrowId == 2) {
                        if (b02.borrowBook()) {
                            System.out.println("Mượn sách thành công.");
                        } else {
                            System.out.println("Sách đã hết.");
                        }
                    } else if (borrowId == 3) {
                        if (b03.borrowBook()) {
                            System.out.println("Mượn sách thành công.");
                        } else {
                            System.out.println("Sách đã hết.");
                        }
                    } else {
                        System.out.println("ID sách không hợp lệ.");
                    }
                    break;

                case 3:
                    // Trả sách
                    System.out.print("\nNhập ID sách muốn trả: ");
                    int returnId = scanner.nextInt();
                    if (returnId == 1) {
                        b01.returnBook();
                        System.out.println("Trả sách thành công.");
                    } else if (returnId == 2) {
                        b02.returnBook();
                        System.out.println("Trả sách thành công.");
                    } else if (returnId == 3) {
                        b03.returnBook();
                        System.out.println("Trả sách thành công.");
                    } else {
                        System.out.println("ID sách không hợp lệ.");
                    }
                    break;

                case 4:
                    // Thoát chương trình
                    running = false;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;



                case 5:
                    // 
            }
        }

        scanner.close();
    }
}


