package BookManager;

import java.util.*;
import java.io.*;
import java.lang.*;

import StoreManager.StoreManager;
import feature.*;

public class BookManager {
    private static final Vector<Book> books = new Vector<>();

    public BookManager() {
    }

    public static Vector<Book> getInfoBook() {
        return books;
    }

    public static void readData() {
        String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\dataBook.txt";
        // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int type = Integer.parseInt(line);
                String id = br.readLine();
                String name = br.readLine();
                switch (type) {
                    case 1:
                        books.add(new LiteratureBook(id, name, br.readLine()));
                        LiteratureBook.increaseCountBook(1);
                        br.readLine();
                        break;
                    case 2:
                        books.add(new MangaBook(id, name, br.readLine()));
                        MangaBook.increaseCountBook(1);
                        br.readLine();
                        break;
                    case 3:
                        books.add(new PsychologyBook(id, name, br.readLine()));
                        PsychologyBook.increaseCountBook(1);
                        br.readLine();
                        break;
                    default:
                        System.out.println("File có lỗi, vui lòng chỉnh sửa lại!");
                        System.exit(0);
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBook() {
        System.out.println("Nhập thể loại muốn thêm sách: ");
        System.out.println("1. Sách văn học");
        System.out.println("2. Manga");
        System.out.println("3. Sách tâm lý");
        System.out.println("4. Thoat");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice;
        choice = inputScanner.input.nextInt();
        inputScanner.input.nextLine();

        Book newBook = null;

        switch (choice) {
            case 1:
                newBook = new LiteratureBook();
                break;
            case 2:
                newBook = new MangaBook();
                break;
            case 3:
                newBook = new PsychologyBook();
                break;
            case 4:
                StoreManager.startProgram();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại !!");
                BookManager.addBook();
                break;
        }

        if (newBook != null) {
            newBook.add();
            books.add(newBook);
            System.out.println("Thêm sách thành công");
        } else {
            System.out.println("Không thể thêm sách.");
        }

        BookManager.manage();
    }

    public static void deleteBook() {
        System.out.print("Nhập tên sách bạn muốn xóa (xóa tất cả các thuộc tính của sách đó): ");
        String nameBookDelete = inputScanner.input.nextLine();
        boolean isRemove = books.removeIf(book -> book.getName().equals(nameBookDelete));
        if (isRemove) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy sách để xóa");
        }

        BookManager.manage();
    }

    public static void modifyBook() {
        boolean checkBook = false;
        System.out.print("Nhập tên sách cần chỉnh sửa: ");
        String nameBook = inputScanner.input.nextLine();
        for (Book book : books) {
            if (book.getName().equals(nameBook)) {
                checkBook = true;
                System.out.println("Chỉnh sửa dữ liệu (nhấn 0 để giữ nguyên dữ liệu): ");
                System.out.print("Chỉnh sửa tên sách: ");
                book.setName(inputScanner.input.nextLine());
                System.out.print("Chỉnh sửa id: ");
                book.setId(inputScanner.input.nextLine());
            }
        }
        if (!checkBook) {
            System.out.println("Sách này hiện tại không tồn tại");
        }
        BookManager.manage();
    }

    public static void display() {
        formatString.toStringBook(books);
        System.out.print("Nhấn Enter tiếp tục...");
        inputScanner.input.nextLine();
        BookManager.manage();
    }

    public static void manage() {
        System.out.println("Quản lí sách: ");
        System.out.println("1. Thêm sách");
        System.out.println("2. Xóa sách");
        System.out.println("3. Chỉnh sửa sách");
        System.out.println("4. Hiện thị sách");
        System.out.println("5 .Quay lại");
        System.out.print("Nhập lựa chọn của bạn: ");
        String value = inputScanner.input.nextLine();
        int choice = Integer.parseInt(value);
        try {
            switch (choice) {
                case 1:
                    BookManager.addBook();
                    break;
                case 2:
                    BookManager.deleteBook();
                    break;
                case 3:
                    BookManager.modifyBook();
                    break;
                case 4:
                    BookManager.display();
                    break;
                case 5:
                    StoreManager.startProgram();
                    break;
                default:
                    System.out.println("Phương thức này không khả dụng");
                    BookManager.manage();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Gía trị không hợp lệ, vui lòng nhập lại");
            BookManager.manage();
        }
    }
}
