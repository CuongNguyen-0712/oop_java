package BillManager;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;

import BillManager.*;

import feature.*;

// Lớp hóa đơn
public class Bill {
    private String id;
    private String dateBuy;
    private String nameCashier;
    private String nameCustomer;
    private final Vector<BillDetail> bill;
    private long totalBill;

    public Bill() {
        this.id = "";
        this.dateBuy = "";
        this.nameCashier = "";
        this.nameCustomer = "";
        this.bill = new Vector<>();
        this.totalBill = 0;
    }

    public Bill(String id, String dateBuy, String nameCashier, String nameCustomer, Vector<BillDetail> bill, long totalBill) {
        this.id = id;
        this.dateBuy = dateBuy;
        this.nameCashier = nameCashier;
        this.nameCustomer = nameCustomer;
        this.bill = new Vector<>();
        this.totalBill = totalBill;
    }

    // Change chỉ sửa tên nv và ngày nên lấy get/set 2 cái thôi
    public String getNameCashier() {
        return this.nameCashier;
    }

    public void setNameCashier(String nameCashier) {
        this.nameCashier = nameCashier;
    }

    public String getDateBuy() {
        return this.dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Vector<BillDetail> getBill() {
        return bill;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long calcTotalBill() {
        totalBill = 0;
        for (BillDetail detail : bill) {
            totalBill += detail.calcCost();
        }
        return totalBill;
    }

    public void add() {
        id = "HD" + BillManager.getListOfBill().size();

        System.out.print("Ban co muon thay doi ngay mua (mac dinh la hom nay) (y/n): ");
        String choice = inputScanner.input.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            while (true) {
                System.out.println("Nhap ngay mua (dd/mm/yyyy): ");
                try{
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(inputScanner.input.nextLine(), dateFormat);
                    dateBuy = date.format(dateFormat);
                    break;
                }
                catch (DateTimeParseException e){
                    System.out.println("Vui long nhap dung cu phap \n");
                }
            }
        }
        else{
            LocalDateTime date = LocalDateTime.now();
            dateBuy = date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
        }

        System.out.println("Nhap ten nhan vien thu ngan: ");
        nameCashier = inputScanner.input.nextLine();

        System.out.println("Nhap ten khach hang: ");
        nameCustomer = inputScanner.input.nextLine();

        System.out.println("Nhap so luong mat hang ban mua: ");
        int detailCount = inputScanner.input.nextInt();
        inputScanner.input.nextLine();

        for (int i = 0; i < detailCount; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");

            BillDetail detail = new BillDetail();
            detail.add();
            bill.add(detail);
        }
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Ngay mua : " + dateBuy);
        System.out.println("Nhan vien thu ngan: " + nameCashier);
        System.out.println("Khach hang: " + nameCustomer);
        System.out.println("Chi tiet hoa don:");

        for (BillDetail detail : bill) {
            detail.display();
            System.out.println("---------------------");
        }
        System.out.println("Tong hoa don: " + calcTotalBill() + ".000VND");
    }

}
