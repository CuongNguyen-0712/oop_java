package BillManager;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;

import StaffManager.*;
import feature.*;

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
        this.bill = bill;
        this.totalBill = totalBill;
    }

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

    public String getNameCustomer() {
        return nameCustomer;
    }

    public Vector<BillDetail> getBill() {
        return bill;
    }

    public long getTotalBill() {
        return totalBill;
    }

    public String getId() {
        return this.id;
    }


    public long calcTotalBill() {
        totalBill = 0;
        for (BillDetail detail : bill) {
            totalBill += detail.calcCost();
        }
        return totalBill;
    }

    public void add() {
        id = "HD" + (int) (Math.random() * 1000);

        System.out.print("Ban co muon thay doi ngay mua (mac dinh la hom nay) (y/n): ");
        String choice = inputScanner.input.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            while (true) {
                System.out.println("Nhap ngay mua (dd/mm/yyyy): ");
                try {
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(inputScanner.input.nextLine(), dateFormat);
                    if (date.getDayOfMonth() > 29 && date.getMonthValue() == 2) {
                        System.out.println("Ngay khong hop le, vui long nhap lai! \n");
                    } else {
                        dateBuy = date.format(dateFormat);
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Vui long nhap dung cu phap \n");
                }
            }
        } else {
            LocalDateTime date = LocalDateTime.now();
            dateBuy = date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
        }

        Vector<Staff> cashiers = new Vector<>();

        for (Staff staff : StaffManager.getList()) {
            if (staff instanceof Cashier) {
                cashiers.add(staff);
            }
        }

        while (true) {
            boolean flag = false;
            for (Staff cashier : cashiers) {
                cashier.display();
            }

            System.out.print("Nhap ten nhan vien thu ngan: ");
            String value = inputScanner.input.nextLine();
            for (Staff cashier : cashiers) {
                if (cashier.getName().equalsIgnoreCase(value)) {
                    nameCashier = cashier.getName();
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println("Vui long nhap dung thu ngan duoc hien thi!");
            } else {
                break;
            }
        }

        System.out.print("Nhap ten khach hang: ");
        nameCustomer = inputScanner.input.nextLine();

        System.out.print("Nhap so luong mat hang ban mua: ");
        int detailCount = Integer.parseInt(inputScanner.input.nextLine());

        for (int i = 0; i < detailCount; i++) {
            System.out.println("Nhap chi tiet hoa don thu " + (i + 1) + ":");

            BillDetail detail = new BillDetail();
            detail.add();
            bill.add(detail);
        }
    }

    public void display() {
        System.out.println("\n-----------------------------");
        System.out.println("Ma hoa don: " + id);
        System.out.println("Ngay mua : " + dateBuy);
        System.out.println("Nhan vien thu ngan: " + nameCashier);
        System.out.println("Khach hang: " + nameCustomer);
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("Chi tiet hoa don:");
        for (BillDetail detail : bill) {
            detail.display();
        }
        System.out.println("Tong hoa don: " + calcTotalBill() + ".000VND");
        System.out.println("-----------------------------");
    }
}
