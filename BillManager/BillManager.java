package BillManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.*;

import feature.*;

public class BillManager {

    private static final Vector<Bill> listOfBill = new Vector<>();
    private static final String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\historyBill.txt";
    // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng

    public static Vector<Bill> getList() {
        return new Vector<>(listOfBill);
    }

    public static void readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String id = line;
                String dateBuy = br.readLine();
                String nameCashier = br.readLine();
                String nameCustomer = br.readLine();
                String totalBill = br.readLine();

                Vector<BillDetail> bill = new Vector<>();
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String nameBook = line;
                    int costBook = Integer.parseInt(br.readLine());
                    int quantityBook = Integer.parseInt(br.readLine());
                    bill.add(new BillDetail(nameBook, costBook, quantityBook));
                }

                listOfBill.add(new Bill(id, dateBuy, nameCashier, nameCustomer, bill, Long.parseLong(totalBill)));
            }
        } catch (Exception e) {
            System.out.println("Loi doc du lieu, vui long thu lai!");
        }
    }

    public static void saveData() {
        try (BufferedWriter wt = new BufferedWriter(new FileWriter(filePath))) {
            for (Bill bill : listOfBill) {
                wt.write(bill.getId() + "\n");
                wt.write(bill.getDateBuy() + "\n");
                wt.write(bill.getNameCashier() + "\n");
                wt.write(bill.getNameCustomer() + "\n");
                wt.write(bill.getTotalBill() + "\n");
                for (BillDetail detail : bill.getBill()) {
                    wt.write(detail.getNameBook() + "\n");
                    wt.write(detail.getCostBook() + "\n");
                    wt.write(detail.getQuantityBook() + "\n");
                }
                wt.write("\n");
            }
        } catch (Exception e) {
            System.out.println("Loi luu du lieu, vui long thu lai!");
        }
    }

    public static void add() {
        Bill newBill = new Bill();
        newBill.add();
        listOfBill.add(newBill);
    }

    public static void delete() {
        BillManager.display();

        System.out.print("Nhap ID hoa don can xoa: ");
        String id = inputScanner.input.nextLine();
        for (int i = 0; i < listOfBill.size(); i++) {
            if (listOfBill.get(i).getId().equalsIgnoreCase(id)) {
                listOfBill.remove(i);
                System.out.println("Da xoa hoa don ID: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay hoa don ID: " + id);
    }

    public static void modify() {
        BillManager.display();

        System.out.print("Nhap ID hoa don can sua: ");
        String id = inputScanner.input.nextLine();
        boolean flag = false;

        for (Bill bill : listOfBill) {
            if (bill.getId().equalsIgnoreCase(id)) {
                while (true) {
                    System.out.println("Chinh sua thong tin moi cho hoa don");
                    System.out.println("1. Nhan vien thu ngan");
                    System.out.println("2. Ngay mua");
                    System.out.println("3. Thoat");
                    System.out.print("Nhap lua chon cua ban: ");

                    try {
                        String value = inputScanner.input.nextLine();
                        int choice = Integer.parseInt(value);
                        switch (choice) {
                            case 1:
                                System.out.print("Nhap ten nhan vien thu ngan moi: ");
                                bill.setNameCashier(inputScanner.input.nextLine());
                                break;
                            case 2:
                                while (true) {
                                    System.out.print("Nhap ngay mua moi (dd/mm/yyyy): ");
                                    try {
                                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                        LocalDate newDate = LocalDate.parse(inputScanner.input.nextLine(), dateFormat);
                                        bill.setDateBuy(newDate.format(dateFormat));
                                        break;
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Dinh dang khong dung, vui long thu lai! \n");
                                    }
                                }
                                break;
                            case 3:
                                return;
                            default:
                                System.out.println("Lua chon khong hop le, vui long nhap lai! \n");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lua chon khong hop le, vui long nhap lai! \n");
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("Khong tim thay hoa don voi ID: " + id);
        }
    }

    public static void search() {
        System.out.print("Nhap ID can tim kiem: ");
        String id = inputScanner.input.nextLine();

        boolean flag = false;

        for (Bill bill : listOfBill) {
            if (bill.getId().equalsIgnoreCase(id)) {
                System.out.print("\n");
                bill.display();
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Khong tim thay hoa don co ID: " + id);
        }
    }

    public static void display() {
        if (listOfBill.isEmpty()) {
            System.out.println("Danh sach hoa don trong!!! \n");
            return;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listOfBill.sort(Comparator.comparing(bill -> LocalDate.parse(bill.getDateBuy(), formatter)));
        for (Bill bill : listOfBill) {
            bill.display();
        }
        System.out.print("Nhấn Enter tiếp tục...");
        inputScanner.input.nextLine();
    }

    public static long allTotalBill() {
        long total = 0;
        for (Bill bill : listOfBill) {
            bill.calcTotalBill();
            total += bill.calcTotalBill();
        }
        return total;
    }

    public static void manage() {
        while (true) {
            System.out.println("\n==== QUAN LY HOA DON ====");
            System.out.println("-------------------------");
            System.out.println("1. Them hoa don");
            System.out.println("2. Xoa hoa don");
            System.out.println("3. Sua thong tin hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Hien thi danh sach hoa don");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);

                switch (choice) {
                    case 1:
                        BillManager.add();
                        break;
                    case 2:
                        BillManager.delete();
                        break;
                    case 3:
                        BillManager.modify();
                        break;
                    case 4:
                        BillManager.search();
                        break;
                    case 5:
                        BillManager.display();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Yeu cau khong kha dung, vui long nhap lai! \n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai!\n");
            }
        }
    }

}