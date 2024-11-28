package Statistics;

import StaffManager.StaffManager;
import BillManager.*;
import BookManager.BookManager;
import BookManager.Book;
import StaffManager.*;
import feature.inputScanner;

import java.util.*;

public class Statistics {
    public static void bookStatistic() {
        System.out.println("\nTong so luong sach con lai trong kho :" + BookManager.getList().size());
        BookManager.countBookByCategory();
    }

    public static void staffStatistic() {
        System.out.println("\nTong so nhan vien la :" + StaffManager.getList().size());
        StaffManager.countByJobStaff();
    }

    public static void totalRevenueAndProfit() {
        long revenue = BillManager.allTotalBill();
        long profit = revenue - StaffManager.totalSalary();
        System.out.println("\nTong doanh thu: " + revenue + "000VND");
        System.out.println("Tong loi nhuan: " + profit + "000VND");
    }

    static class Summary {
        int quantity;
        double totalPrice;

        Summary(int quantity, double totalPrice) {
            this.quantity = quantity;
            this.totalPrice = totalPrice;
        }
    }

    private static void detailBillStatistic(List<BillDetail> productList) {
        Map<String, Summary> Bill = new HashMap<>();

        for (BillDetail product : productList) {
            String productName = product.getNameBook();

            Bill.putIfAbsent(productName, new Summary(0, 0));
            Summary current = Bill.get(productName);

            current.quantity += product.getQuantityBook();
            current.totalPrice += product.calcCost();
        }

        for (Map.Entry<String, Summary> entry : Bill.entrySet()) {
            String nameBook = entry.getKey();
            Summary summary = entry.getValue();
            System.out.println("- " + nameBook + ":");
            System.out.println("  + Tong so luong: " + summary.quantity);
            System.out.println("  + Tong so tien: " + summary.totalPrice + "000VND");
        }
    }

    public static void bookSale() {
        System.out.println("\nTong so hoa don : " + BillManager.getList().size());
        Vector<BillDetail> Manga = new Vector<>();
        Vector<BillDetail> Literature = new Vector<>();
        Vector<BillDetail> Psychology = new Vector<>();
        long countMG = 0;
        long countLB = 0;
        long countPB = 0;
        long totalMG = 0;
        long totalLB = 0;
        long totalPB = 0;
        for (Bill bill : BillManager.getList()) {
            for (BillDetail detail : bill.getBill()) {
                if (detail.getIDBook().charAt(0) == 'M') {
                    countMG += detail.getQuantityBook();
                    totalMG += detail.calcCost();
                    Manga.add(detail);
                } else if (detail.getIDBook().charAt(0) == 'L') {
                    countLB += detail.getQuantityBook();
                    totalLB += detail.calcCost();
                    Literature.add(detail);
                } else {
                    countPB += detail.getQuantityBook();
                    totalPB += detail.calcCost();
                    Psychology.add(detail);
                }
            }
        }
        System.out.println("Tong so luong sach ban: " + (countMG + countLB + countPB));
        System.out.println("Tong so Manga: " + countMG);
        detailBillStatistic(Manga);
        System.out.println("Tong so tien thu dc tu Manga: " + totalMG + "000VND");
        System.out.println("Tong so Literature: " + countLB);
        detailBillStatistic(Literature);
        System.out.println("Tong so tien thu tu Literature: " + totalLB + "000VND");
        System.out.println("Tong so Psychology: " + countPB);
        detailBillStatistic(Psychology);
        System.out.println("Tong so tien thu tu Psychology: " + totalPB + "000VND");
    }

    public static void bookBestSeller() {
        System.out.print("\n");
        int count = 0;
        for (Book book : BookManager.getList()) {
            if (book.getIsBestSeller()) {
                book.display();
                count++;
            }
        }
        System.out.println("\nTong so sach ban chay : " + count);
    }

    public static void billCashier() {
        for (Staff staff : StaffManager.getList()) {
            if (staff instanceof Cashier) {
                long total = 0;
                int countBill = 0;
                for (Bill bill : BillManager.getList()) {
                    if (bill.getNameCashier().equalsIgnoreCase(staff.getName())) {
                        total += bill.calcTotalBill();
                        countBill++;
                    }
                }
                System.out.println("\n-------------------------------");
                System.out.println("Thu ngan: " + staff.getName());
                System.out.println("Tong so hoa don: " + countBill);
                System.out.println("Tong tien ban duoc: " + total + "000VND");
                System.out.println("-------------------------------");
            }
        }
    }

    public static void manage() {
        while (true) {
            System.out.println("\n====THONG KE====");
            System.out.println("1. Thong ke sach ton kho");
            System.out.println("2. Thong ke nhan vien cua hang");
            System.out.println("3. Thong ke doanh thu va loi nhuan");
            System.out.println("4. Thong ke hoa don");
            System.out.println("5. Thong ke sach ban chay");
            System.out.println("6. Thong ke nhan vien tu hoa don");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                int choice = Integer.parseInt(inputScanner.input.nextLine());
                switch (choice) {
                    case 1:
                        Statistics.bookStatistic();
                        break;
                    case 2:
                        Statistics.staffStatistic();
                        break;
                    case 3:
                        Statistics.totalRevenueAndProfit();
                        break;
                    case 4:
                        Statistics.bookSale();
                        break;
                    case 5:
                        Statistics.bookBestSeller();
                        break;
                    case 6:
                        Statistics.billCashier();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Yeu cau khong kha dung, vui long nhap lai! \n");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai!");
            }
        }
    }
}
