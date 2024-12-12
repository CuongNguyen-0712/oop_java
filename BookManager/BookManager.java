package BookManager;

import java.io.*;
import java.util.*;

import feature.formatString;
import feature.inputScanner;

public class BookManager {
    private static final Vector<Book> listOfBook = new Vector<>();
    private static final String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\dataBook.txt";
    // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng

    public static Vector<Book> getList() {
        return new Vector<>(listOfBook);
    }

    public static void readData() {
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
                boolean isBestSeller = Boolean.parseBoolean(br.readLine());
                switch (type) {
                    case 1:
                         String audience = br.readLine();
                        listOfBook.add(new PsychologyBook(id, name, author, publisher, cost, quantity, isBestSeller, audience));
                        br.readLine();
                        break;
                    case 2:
                        int volume = Integer.parseInt(br.readLine());
                        listOfBook.add(new MangaBook(id, name, author, publisher, cost, quantity, isBestSeller, volume));
                        br.readLine();
                        break;
                    case 3:
                        String nation = br.readLine();
                        listOfBook.add(new LiteratureBook(id, name, author, publisher, cost, quantity, isBestSeller, nation));
                        br.readLine();
                        break;
                    default:
                        System.out.println("File có lỗi, vui lòng chỉnh sửa lại!");
                        System.exit(0);
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("Loi doc du lieu, vui long thu lai!");
            System.exit(1);
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
                wt.write(book.getIsBestSeller() + "\n");

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
            System.out.println("Loi luu du lieu, vui long thu lai!");
        }
    }

    public static void add() {
        int choice;
        do {
            System.out.println("Chon loai sach ban muon them: 1. Sach Tam Ly Hoc  2. Manga   3. Sach Van Hoc");
            System.out.print("Lua chon cua ban: ");
            choice = Integer.parseInt(inputScanner.input.nextLine());

            Book newBook = null;

            switch (choice) {
                case 1:
                    newBook = new PsychologyBook();
                    break;
                case 2:
                    newBook = new MangaBook();
                    break;
                case 3:
                    newBook = new LiteratureBook();
                    break;
                default:
                    System.out.println("Lua chon khong hop le !!!\n");
                    break;
            }

            if(newBook != null) {
                newBook.add();
                listOfBook.add(newBook);
                return;
            }
        } while (true);
    }


    public static void delete() {
        BookManager.display();

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
    }

    public static void modify() {
        BookManager.display();

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
                System.out.println("\nChinh sua thong tin sach:");
                switch (choice) {
                    case 1:
                        System.out.print("Nhap ten sach: ");
                        String name = inputScanner.input.nextLine();
                        listOfBook.get(i).setName(name);
                        break;
                    case 2:
                        System.out.print("Nhap ten tac gia: ");
                        String author = inputScanner.input.nextLine();
                        listOfBook.get(i).setAuthor(author);
                        break;
                    case 3:
                        System.out.print("Nhap nha xuat ban: ");
                        String publisher = inputScanner.input.nextLine();
                        listOfBook.get(i).setPublisher(publisher);
                        break;
                    case 4:
                    while (true) {
                        try {
                            System.out.print("Nhap gia: ");
                            int cost = Integer.parseInt(inputScanner.input.nextLine());
                            listOfBook.get(i).setCost(cost);   
                            break; 
                        } catch (NumberFormatException e) {
                            System.out.println("Nhap so nguyen !\n");
                        }
                    }
                        break;
                    case 5:
                    while (true) {
                        try {
                            System.out.print("Nhap so luong: ");
                            int quantity = Integer.parseInt(inputScanner.input.nextLine());
                            listOfBook.get(i).setQuantity(quantity);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Nhap so nguyen !\n");
                        }
                    }
                        break;
                    case 6:
                        System.out.print("Ban co muon giu vi tri Best Seller cua cuon sach nay khong (y/n): ");
                        String bestSeller = inputScanner.input.nextLine();
                        listOfBook.get(i).setIsBestSeller(bestSeller.equalsIgnoreCase("y"));
                        break;
                    case 7:
                        if (listOfBook.get(i) instanceof PsychologyBook) {
                            System.out.println("Nhap doi tuong doc gia: ");
                            String audience = inputScanner.input.nextLine();
                            ((PsychologyBook) listOfBook.get(i)).setAudience(audience);
                        } else if (listOfBook.get(i) instanceof MangaBook) {
                            while (true) {
                                try {
                                    System.out.println("Nhap so tap: ");
                                    int volume = Integer.parseInt(inputScanner.input.nextLine());
                                    ((MangaBook) listOfBook.get(i)).setVolume(volume);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Nhap so nguyen !\n");
                                }
                            }

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

    public static void search() {
        boolean flag = false;
        System.out.print("Nhap ma sach hoac ten sach muon tim: ");
        String searchValue = inputScanner.input.nextLine();

        for (int i = 0; i < listOfBook.size(); i++) {
            if (listOfBook.get(i).getID().equalsIgnoreCase(searchValue) || listOfBook.get(i).getName().equalsIgnoreCase(searchValue)) {
                System.out.println("\n----THONG TIN SACH CAN TIM---\n");
                listOfBook.get(i).display();
                System.out.println("\n");
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Khong tim thay sach!!!\n");
        }
    }

    public static void display() {
        System.out.println("\n----DANH SACH SACH---\n");
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
            System.out.println("\n=== QUAN LI SACH ===");
            System.out.println("--------------------");
            System.out.println("1. Them sach");
            System.out.println("2. Xoa sach");
            System.out.println("3. Chinh sua sach");
            System.out.println("4. Tim kiem sach");
            System.out.println("5. Hien thi sach");
            System.out.println("6. Quay lai");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);
                switch (choice) {
                    case 1:
                        BookManager.add();
                        break;
                    case 2:
                        BookManager.delete();
                        break;
                    case 3:
                        BookManager.modify();
                        break;
                    case 4:
                        BookManager.search();
                        break;
                    case 5:
                        BookManager.display();
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
