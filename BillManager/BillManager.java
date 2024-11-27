package BillManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


import feature.*;

public class BillManager {

    private static final Vector<Bill> listOfBill = new Vector<>();

    public static Vector<Bill> getList() {
        return listOfBill;
    }

    public static void add() {
        Bill newBill = new Bill();
        newBill.add();
        listOfBill.add(newBill);

    }

    // import inputScanner
    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID hoa don can xoa: ");
        String id = sc.nextLine();
        for (int i = 0; i < listOfBill.size(); i++) {
            if (listOfBill.get(i).getId().equals(id)) {
                listOfBill.remove(i);
                System.out.println("Da xoa hoa don ID: " + id);
                return;
            }
        }
        System.out.println("Khong tim thay hoa don ID: " + id);
    }

    public static void modify() {
        System.out.println("Nhap ID hoa don can sua: ");
        String id = inputScanner.input.nextLine();

        for (Bill bill : listOfBill) {
            if (bill.getId().equals(id)) {
                System.out.println("Nhap thong tin moi cho hoa don:");
                System.out.println("Nhap ten nhan vien thu ngan moi: ");
                bill.setNameCashier(inputScanner.input.nextLine());

                System.out.println("Nhap ngay mua moi (dd/mm/2024): ");
                bill.setDateBuy(inputScanner.input.nextLine());
            }
        }
        System.out.println("Khong tim thay hoa don voi ID: " + id);
    }

    public static void search() {
        System.out.println("Nhap ID can tim kiem: ");
        String id = inputScanner.input.nextLine();

        boolean flag = false;

        for (Bill bill : listOfBill) {
            if (bill.getId().equals(id)) {
                System.out.println("Da tim thay hoa don!!!");
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
            System.out.println("Danh sach hoa don trong!!!");

        } else {
            for (Bill bill : listOfBill) {
                System.out.println("-----------------------------");
                bill.display();
                System.out.println("-----------------------------");
            }
        }
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
            System.out.println("1. Them hoa don");
            System.out.println("2. Xoa hoa don");
            System.out.println("3. Sua thong tin hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Hien thi danh sach hoa don");
            System.out.println("6. Thoat");
            System.out.print("Nhua chon cua ban: ");

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

    public static boolean dateCheck(String dateBuy1, String dateBuy2) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate localDate1 = LocalDate.parse(dateBuy1, dateFormat);
        LocalDate localDate2 = LocalDate.parse(dateBuy2, dateFormat);

        return !localDate1.isAfter(localDate2);
    }

    public static Vector<Bill>sortDate(){
        Vector<Bill> temp = listOfBill;
             Comparator<Bill> dateCompare = new Comparator<Bill>() {
                @Override
                public int compare(Bill bill1, Bill bill2) {
                    String date1 = bill1.getDateBuy();
                    String date2 = bill2.getDateBuy();
                    if (dateCheck(date1, date2)) {
                        return -1; 
                    } else {
                        return 1; 
                    }
                }
            };
    
            Collections.sort(temp,dateCompare);
            return temp;
    }
}
