package StoreManager;

import BookManager.BookManager;
import StaffManager.StaffManager;
import BillManager.BillManager;
import Statistics.Statistics;

import feature.inputScanner;

public class StoreManager {
    public static void readFile() {
        BookManager.readData();
        BillManager.readData();
        StaffManager.readData();
    }

    public static void saveFile() {
        BookManager.saveData();
        BillManager.saveData();
        StaffManager.saveData();
    }

    public static void startProgram() {
        while (true) {
            System.out.println("\n=== QUAN LI CUA HANG SACH ===");
            System.out.println("-----------------------------");
            System.out.println("Vui long chon chuc nang de thao tac: ");
            System.out.println("1. Quan li sach");
            System.out.println("2. Quan li hoa don");
            System.out.println("3. Quan li nhan vien");
            System.out.println("4. Thong ke");
            System.out.println("5. Luu");
            System.out.println("6. Ket thuc chuong trinh");
            System.out.print("Vui long nhap lua chon: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);
                switch (choice) {
                    case 1:
                        BookManager.manage();
                        break;
                    case 2:
                        BillManager.manage();
                        break;
                    case 3:
                        StaffManager.manage();
                        break;
                    case 4:
                        Statistics.manage();
                        break;
                    case 5:
                        StoreManager.saveFile();
                        System.out.println("Lưu thanh cong! \n");
                        break;
                    case 6:
                        StoreManager.saveFile();
                        System.out.println("Lưu thành công. Kết thúc chương trình!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập lại.\n");
            }
        }
    }
}
