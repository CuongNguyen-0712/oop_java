package StoreManager;

import BookManager.BookManager;
import StaffManager.StaffManager;
import BillManager.BillManager;
import Statistics.Statistics;

import feature.inputScanner;

public class StoreManager {
    public static void readFile(){
        BookManager.readData();
    }

    public static void startProgram() {
        System.out.println("Quản lí cửa hàng bán sách !");
        System.out.println("---------------------------");
        System.out.println("Vui lòng chọn chức năng để thao tác: ");
        System.out.println("1. Quản lí sách.");
        System.out.println("2. Quản lí hóa đơn.");
        System.out.println("3. Quản lí nhân viên.");
        System.out.println("4. Lưu và kết thúc chương trình.");
        System.out.print("Vui lòng nhập lựa chọn: ");
        String value;
        value = inputScanner.input.nextLine();

        try {
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
                default:
                    System.out.println("Phương thức không khả dụng");
                    StoreManager.startProgram();
                    break;
            }
        }
        catch (NumberFormatException e){
            System.out.println("Giá trị không hợp lê, vui lòng nhập lại");
            StoreManager.startProgram();
        }
    }
}
