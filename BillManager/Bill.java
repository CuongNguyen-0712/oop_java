package BillManager;
import java.io.*;
import java.util.*;
// Lớp hóa đơn
class Bill {
    private String id;
    private String dateBuy;
    private String nameCashier;
    private String nameCustomer;
    private Vector<DetailBill> listOfDetailBill;
    private long totalBill;

    public Bill() {
        this.id = "";
        this.dateBuy = "";
        this.nameCashier = "";
        this.nameCustomer = "";
        this.listOfDetailBill = new Vector<>();
        this.totalBill = 0;
    }
    
    public Bill(String id, String dateBuy, String nameCashier, String nameCustomer, Vector<DetailBill> listOfDetailBill, long totalBill ){
      this.id = id;
        this.dateBuy = dateBuy;
        this.nameCashier = nameCashier;
        this.nameCustomer = nameCustomer;
        this.listOfDetailBill = new Vector<>();
        this.totalBill = totalBill;
    }  
    // Change chỉ sửa tên nv và ngày nên lấy get/set 2 cái thôi 
    public String getNameCashier(){
        return this.nameCashier;
    }
    public void setNameCashier(String nameCashier){
        this.nameCashier = nameCashier;
    }
    
    public String getDateBuy(){
        return this.dateBuy;
    }
    public void setDateBuy(String dateBuy){
        this.dateBuy= dateBuy;
    }
    
    public Vector<DetailBill> getListOfDetailBill() {
        return listOfDetailBill;
    }
    
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    
    
    public long calcTotalBill() {
        totalBill = 0;
        for (DetailBill detail : listOfDetailBill) {
            totalBill += detail.calcCost();
        }
        return totalBill;
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID hoa don: ");
        id = sc.nextLine();
        
        System.out.println("Nhap ngay mua: ");
        dateBuy = sc.nextLine();
        while(!checkDate(dateBuy)) {
            System.out.println("Khong hop le! Vui long nhap lai!!!");
            dateBuy = sc.nextLine();
        }
        
        System.out.println("Nhap ten nhan vien thu ngan: ");
        nameCashier = sc.nextLine();
        
        System.out.println("Nhap ten khach hang: ");
        nameCustomer = sc.nextLine();
        
        System.out.println("Nhap so luong mat hang ban mua: ");
        int detailCount = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < detailCount; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");
            
            DetailBill detail = new DetailBill();
            detail.add();
            listOfDetailBill.add(detail);
        }
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Ngay mua (dd/mm/2024): " + dateBuy);
        System.out.println("Nhan vien thu ngan: " + nameCashier);
        System.out.println("Khach hang: " + nameCustomer);
        System.out.println("Chi tiet hoa don:");
        
        for (DetailBill detail : listOfDetailBill) {
            detail.display();
            System.out.println("---------------------");
        }
        System.out.println("Tong hoa don: " + calcTotalBill() +".000VND");
    }
    // Chua co y tuong nao khac ngoai dung mang! Co gi gop y cho tui
        public boolean checkDate(String dateBuy){
             String[] divide = dateBuy.split("/");
            // Chuyenn String thanh Int
            int ngay = Integer.parseInt(divide[0]);
            int thang = Integer.parseInt(divide[1]);
            int nam = Integer.parseInt(divide[2]);
    
            if (thang < 1 || thang > 12) {
                return false;
            }
            if (ngay < 1 || ngay > 31) {
                return false;
            }
            if(nam != 2024){
                return false;
            }
            return true;
}

}
