package BookManager;

import java.io.*;
import java.util.*;

import StoreManager.StoreManager;
import feature.formatString;
import feature.inputScanner;

public class BookManager {
    private static final Vector<Book> listOfBook = new Vector<>();
    static final String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\dataBook.txt";

    public static Vector<Book> getListOfBook() {
        return listOfBook;
    }

    public static void readData() {
        // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int type = Integer.parseInt(line);
                String id = br.readLine();
                String name = br.readLine();
                String author = br.readLine();
                String publisher = br.readLine();
                int cost = Integer.parseInt(br.readLine());
                int quantity = Integer.parseInt(br.readLine());
                switch (type) {
                    case 1:
                        String audience = br.readLine();
                        listOfBook.add(new PsychologyBook(id, name, author, publisher, cost, quantity, audience));
                        br.readLine();
                        break;
                    case 2:
                        int volume = Integer.parseInt(br.readLine());
                        listOfBook.add(new MangaBook(id, name, author, publisher, cost, quantity, volume));
                        br.readLine();
                        break;
                    case 3:
                        String nation = br.readLine();
                        listOfBook.add(new LiteratureBook(id, name, author, publisher, cost, quantity, nation));
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

    public static void saveData() {
        try (BufferedWriter wt = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : listOfBook) {
                int indexBookType;

                if (book instanceof PsychologyBook) {
                    wt.write("1\n");
                    indexBookType = 1;
                } else if (book instanceof MangaBook) {
                    wt.write("2\n");
                    indexBookType = 2;
                } else {
                    wt.write("3\n");
                    indexBookType = 3;
                }

                wt.write(book.getID() + "\n");
                wt.write(book.getName() + "\n");
                wt.write(book.getAuthor() + "\n");
                wt.write(book.getPublisher() + "\n");
                wt.write(book.getCost() + "\n");
                wt.write(book.getQuantity() + "\n");

                if (indexBookType == 1) {
                    wt.write(((PsychologyBook) book).getAudience() + "\n");
                } else if (indexBookType == 2) {
                    wt.write(((MangaBook) book).getVolume() + "\n");
                } else {
                    wt.write(((LiteratureBook) book).getNation() + "\n");
                }

                wt.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBook() {
        int choice;

        do {
            System.out.println("Chon loai sach ban muon them: 1. Sach Tam Ly Hoc  2. Manga   3. Sach Van Hoc");
            choice = inputScanner.input.nextInt();
            inputScanner.input.nextLine();

            switch (choice) {
                case 1:
                    PsychologyBook pb = new PsychologyBook();
                    pb.add();
                    listOfBook.add(pb);
                    break;
                case 2:
                    MangaBook mg = new MangaBook();
                    mg.add();
                    listOfBook.add(mg);
                    break;
                case 3:
                    LiteratureBook lb = new LiteratureBook();
                    lb.add();
                    listOfBook.add(lb);
                    break;
                default:
                    System.out.println("Lua chon khong hop le !!!\n");
            }

        } while (choice < 1 || choice > 3);
    }

    public static void deleteBook() {
        System.out.print("Nhap ma sach muon xoa: ");
        String id = inputScanner.input.nextLine();

        boolean flag = false;

        for (int i = 0; i < listOfBook.size(); i++) {
            if (listOfBook.get(i).getID().equalsIgnoreCase(id)) {
                if (listOfBook.get(i) instanceof PsychologyBook) {
                    PsychologyBook.deCountBook();
                } else if (listOfBook.get(i) instanceof MangaBook) {
                    MangaBook.deCountBook();
                } else {
                    LiteratureBook.deCountBook();
                }
                listOfBook.remove(i);
                flag = true;
                System.out.println("Đã xóa thành công!!!\n");
                break;
            }
        }

        if (!flag) {
            System.out.println("Khong tim thay sach!!!\n");
        }

        BookManager.manage();
    }

    public static void modifyBook() {
        boolean flag = false;
        System.out.print("Nhap ma sach muon sua: ");
        String id = inputScanner.input.nextLine();

        for (int i = 0; i < listOfBook.size(); i++) {
            if (listOfBook.get(i).getID().equalsIgnoreCase(id)) {
                modifyData(i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Ma sach khong hop le!!!\n");
        }
    }

    public static void modifyData(int i) {
        while (true) {
            System.out.println("Chon thong tin muon sua: ");
            System.out.println("1. Ten sach");
            System.out.println("2. Ten tac gia");
            System.out.println("3. Nha xuat ban");
            System.out.println("4. Gia");
            System.out.println("5. So luong");
            System.out.println("6. Best Seller");
            System.out.println("7. Thong tin rieng cua sach");
            System.out.println("8. Thoat");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);
                switch (choice) {
                    case 1:
                        System.out.println("Nhap ten sach: ");
                        String name = inputScanner.input.nextLine();
                        listOfBook.get(i).setName(name);
                        break;
                    case 2:
                        System.out.println("Nhap ten tac gia: ");
                        String author = inputScanner.input.nextLine();
                        listOfBook.get(i).setAuthor(author);
                        break;
                    case 3:
                        System.out.println("Nhap nha xuat ban: ");
                        String publisher = inputScanner.input.nextLine();
                        listOfBook.get(i).setPublisher(publisher);
                        break;
                    case 4:
                        System.out.println("Nhap gia: ");
                        int cost = inputScanner.input.nextInt();
                        listOfBook.get(i).setCost(cost);
                        break;
                    case 5:
                        System.out.println("Nhap so luong: ");
                        int quantity = inputScanner.input.nextInt();
                        listOfBook.get(i).setQuantity(quantity);
                        break;
                    case 6:
                        System.out.println("Ban co muon giu vi tri Best Seller cua cuon sach nay khong? (y/n)");
                        String bestSeller = inputScanner.input.nextLine();
                        listOfBook.get(i).setIsBestSeller(bestSeller.equalsIgnoreCase("y"));
                        break;
                    case 7:
                        if (listOfBook.get(i) instanceof PsychologyBook) {
                            System.out.println("Nhap doi tuong doc gia: ");
                            String audience = inputScanner.input.nextLine();
                            ((PsychologyBook) listOfBook.get(i)).setAudience(audience);
                        } else if (listOfBook.get(i) instanceof MangaBook) {
                            System.out.println("Nhap so tap: ");
                            int volume = inputScanner.input.nextInt();
                            ((MangaBook) listOfBook.get(i)).setVolume(volume);
                            inputScanner.input.nextLine();
                        } else {
                            System.out.println("Tac pham thuoc ve quoc gia: ");
                            String nation = inputScanner.input.nextLine();
                            ((LiteratureBook) listOfBook.get(i)).setNation(nation);
                        }
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le!!!\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le!!!\n");
            }
        }
    }

    public static void searchBook() {
        boolean flag = false;
        System.out.print("Nhap ma sach muon tim: ");
        String searchValue = inputScanner.input.nextLine();

        for (int i = 0; i < listOfBook.size(); i++) {
            if (listOfBook.get(i).getID().equalsIgnoreCase(searchValue)) {
                System.out.println("\n");
                System.out.println("----THONG TIN SACH CAN TIM---\n");
                if(listOfBook.get(i) instanceof PsychologyBook){
                    listOfBook.get(i).display();
                }
                else if(listOfBook.get(i) instanceof LiteratureBook){
                    listOfBook.get(i).display();
                }
                else{
                    listOfBook.get(i).display();
                }
                System.out.println("\n");
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Khong tim thay sach!!!\n");
        }
    }

    public static void displayListofBook() {
        System.out.println("\n");
        System.out.println("----DANH SACH SACH---\n");
        formatString.toStringBook(listOfBook);
        System.out.print("Nhấn Enter tiếp tục...");
        inputScanner.input.nextLine();
    }

    public static void countBookByCategory() {
        System.out.println("So luong sach Tam Li Hoc: " + PsychologyBook.countBook());
        System.out.println("So luong Manga: " + MangaBook.countBook());
        System.out.println("So luong sach Van Hoc: " + LiteratureBook.countBook());
    }

    public static void manage() {
        while (true) {
            System.out.println("\n");
            System.out.println("Quản lí sách: ");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xóa sách");
            System.out.println("3. Chỉnh sửa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiện thị sách");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);
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
                        BookManager.searchBook();
                        break;
                    case 5:
                        BookManager.displayListofBook();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Gía trị không hợp lệ, vui lòng nhập lại.");
            }
        }
    }

}
