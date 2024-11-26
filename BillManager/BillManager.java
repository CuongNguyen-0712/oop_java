package BillManager;

import java.util.*;

import feature.*;

public class BillManager {

    private static final Vector<Bill> listOfBill = new Vector<>();

    public static Vector<Bill> getListOfBill(){
        return listOfBill;
    }

    public static void add() {
        Bill newBill = new Bill();
        newBill.add();
        listOfBill.add(newBill);

    }

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
}
