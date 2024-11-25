package BillManager;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;

// Lớp quản lý hóa đơn
class BillManager {
    private Vector<Bill> listOfBill;

    public BillManager() {
        this.listOfBill = new Vector<>();
    }
// Phương thức thêm
    public void add() {
        Bill bill = new Bill();
        bill.add();
        listOfBill.add(bill);
    }
// Phương thức xuất
    public void display() {
        
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
// Phương thức sửa
    public void change() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhap ID hoa don can sua: ");
        String id = sc.nextLine();
        
        for (Bill bill : listOfBill) {
            if (bill.getId().equals(id)) {
                System.out.println("Nhap thong tin moi cho hoa don:");
                    System.out.println("Nhap ten nhan vien thu ngan moi: ");
                                 bill.setNameCashier(sc.nextLine());
   
                    System.out.println("Nhap ngay mua moi (dd/mm/2024): ");
                                bill.setDateBuy(sc.nextLine());
            }
        }
        System.out.println("Khong tim thay hoa don voi ID: " + id);
    }
// Phương thức xóa
    public void delete() {
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


// Phương thức tìm kiếm

 public void search() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhap ID can tim kiem: ");
    String id = sc.nextLine();

    boolean flag = false; // Đặt cờ

    for (Bill bill : listOfBill) {
        if (bill.getId().equals(id)) {
            System.out.println("Da tim thay hoa don!!!");
            bill.display(); 
            flag = true;    
            break;          
        }
    }

    if (!flag) { 
        System.out.println("Khong tim thay hoa don voi ID " + id);
        }
    }
       

    
}

class menuBillManager{
    BillManager manager = new BillManager();
        public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== MENU QUAN LY HOA DON ====");
            System.out.println("1. Them hoa don");
            System.out.println("2. Hien thi danh sach hoa don");
            System.out.println("3. Sua thong tin hoa don");
            System.out.println("4. Xoa hoa don");
            System.out.println("5. Tim kiem hoa don");   
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.add();
                    break;
                case 2:
                    manager.display();
                    break;
                case 3:
                    manager.change();
                    break;
                case 4:
                    manager.delete();
                    break;
                case 5:
                    manager.search();
                    break;
                case 6:
                    break;
                default: 
                    System.out.println("Lua chon khong hop le! Vui long chon lai.");
            }
        } while (choice != 6);
    }
}

// Lớp chính với menu
public class Main {
    public static void main(String[] args) {
    menuBillManager menuBill = new menuBillManager();
    menuBill.menu();
    }
}

