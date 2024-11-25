package BillManager;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;

// Lớp chi tiết hóa đơn
class DetailBill {
    private String nameBook;
    private int costBook;
    private int quantityBook;

    public DetailBill() {
        this.nameBook = "";
        this.costBook = 0;
        this.quantityBook = 0;
    }

    public DetailBill(String nameBook, int costBook, int quantityBook) {
        this.nameBook = nameBook;
        this.costBook = costBook;
        this.quantityBook = quantityBook;
    }
    // Get/Set nameBook
    public String getNameBook(){
        return this.nameBook;
    }
    public void setNameBook(String nameBook){
        this.nameBook = nameBook;
    }
    
    // Get/Set costBook
    public int getCostBook(){
        return this.costBook;
    }
    public void setCostBook(int costBook){
        this.costBook = costBook;
    }
    
    // Get/Set quantityBook
    public int getQuantityBook(){
        return this.quantityBook;
    }
    
    public void setQuantityBook(int quantityBook){
        this.quantityBook = quantityBook;
    }
    // Tính calcCost
    // Có thể tính cho 1 quyển nhiều thể loại và 1 quyển 1 thể loại 
    public int calcCost() {
        return costBook * quantityBook;
    }
// Phương thức nhập
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        nameBook = sc.nextLine();
        System.out.println("Nhap gia sach: ");
        costBook = sc.nextInt();
         while(costBook > 500000)
        {
        System.out.println("Vui long nhap lai gia sach: ");
        costBook = sc.nextInt();
        }
        System.out.println("Nhap so luong: ");
        quantityBook = sc.nextInt();
        sc.nextLine();
    }
// Phương thức xuất
    public void display() {
        System.out.println("Ten sach: " + nameBook);
        System.out.println("Gia: " + costBook+ ".000 VND");
        
        System.out.println("So Luong: " + quantityBook);
        System.out.println("Tong: " + calcCost()+ ".000 VND");
    }
}


