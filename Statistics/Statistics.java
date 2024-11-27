package Statistics;

import feature.inputScanner;
import StaffManager.StaffManager;
import BillManager.*;
import BookManager.BookManager;
import BookManager.Book;
import StaffManager.Staff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Statistics {
  public static void bookStorage() {
    System.out.println("Tong so luong sach con lai trong kho :" + BookManager.getList().size());
    BookManager.countBookByCategory();
  }

  public static void StaffManage() {
    System.out.println("Tong so nhan vien la :" + StaffManager.getList().size());
    StaffManager.countByJobStaff();
  }

  public static long totalRevenue() {
    return BillManager.allTotalBill();
  }

  public static long benefit() {
    return BillManager.allTotalBill() - StaffManager.totalSalary();
  }

  static class Summary {
    int quantity;
    double totalPrice;

    Summary(int quantity, double totalPrice) {
      this.quantity = quantity;
      this.totalPrice = totalPrice;
    }
  }

  private static void detailBillStatistict(List<BillDetail> productList) {
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
      System.out.println("  + Tong so tien: " + summary.totalPrice);
    }
  }

  public static void bookSale() {
    System.out.println("Tong so hoa don : " + BillManager.getList().size());
    int countMG = 0;
    Vector<BillDetail> Manga = new Vector<>();
    Vector<BillDetail> Literature = new Vector<>();
    Vector<BillDetail> Psychology = new Vector<>();
    int countLB = 0;
    int countPB = 0;
    int totalMG = 0;
    int totalLB = 0;
    int totalPB = 0;
    for (Bill bill : BillManager.getList()) {
      for (BillDetail book : bill.getList()) {
        if (book.getCategory().equalsIgnoreCase("manga")) {
          countMG++;
          totalMG += book.calcCost();
          Manga.add(book);
        } else if (book.getCategory().equalsIgnoreCase("literature")) {
          countLB++;
          totalLB += book.calcCost();
          Literature.add(book);
        } else {
          countPB++;
          totalPB += book.calcCost();
          Psychology.add(book);
        }
      }
    }
    // Cần làm logic các cuốn trùng nhau trong những bill khác nhau hiển thị tổng
    // kết
    System.out.println("Tong so Manga :" + countMG);
    System.out.println("Tong so tien thu dc tu Manga :" + totalMG);
    detailBillStatistict(Manga);
    System.out.println("Tong so Literature :" + countLB);
    System.out.println("Tong so tien thu tu Literature :" + totalLB);
    detailBillStatistict(Literature);
    System.out.println("Tong so Psychology :" + countPB);
    System.out.println("Tong so tien thu tu Psychology :" + totalPB);
    System.out.println("Tong so sach ban ra : " + (countLB + countMG + countPB));
    detailBillStatistict(Psychology);
  }

  //Có muốn option chọn từ ngày nào tới ngày nào để fill thống kê theo ngày không
  public static void billDate() {
    for (Bill bill : BillManager.sortDate()) {
      bill.display();
    }
  }

  public static void bookBestSeller() {
    int count = 0;
    for (Book book : BookManager.getList()) {
      if (book.getIsBestSeller())
        count++;
    }
    System.out.println("Tong so sach ban chay : " + count);
  }

  public static void billCashier() {
    for (Staff staff : StaffManager.getList()) {
      if (staff instanceof Cashier) {
        long total = 0;
        for (Bill bill : BillManager.getList()) {
          if (bill.getNameCashier().equalsIgnoreCase(staff.getName)) {
            total += bill.calcTotalBill();
          }
        }
        System.out.println(staff.getName + "Tong so hoa don : " + staff.getCountBill + ",Tong tien ban duoc" + total);
      }
    }
  }

  public static void manage();
  {

  }
}
