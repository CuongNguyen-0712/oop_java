package StoreManager;

import BookManager.BookManager;
import StaffManager.StaffManager;
import BillManager.BillManager;
import Statistics.Statistics;

import feature.inputScanner;

public class StoreManager {
    public static void readFile() {
        BookManager.readData();
    }

    public static void saveFile() {
        BookManager.saveData();
    }

    public static void startProgram() {
        while (true) {
            System.out.println("\n");
            System.out.println("=== QUAN LI CUA HANG SACH ===");
            System.out.println("---------------------------");
            System.out.println("Vui lòng chọn chức năng để thao tác: ");
            System.out.println("1. Quản lí sách");
            System.out.println("2. Quản lí hóa đơn");
            System.out.println("3. Quản lí nhân viên");
            System.out.println("4. Thống kê");
            System.out.println("5. Lưu");
            System.out.println("6. Ket thuc chuong trinh");
            System.out.print("Vui lòng nhập lựa chọn: ");

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
