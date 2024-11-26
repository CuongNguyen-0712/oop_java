package Statistics;

import feature.inputScanner;
import StaffManager.StaffManager;
import BillManager.Bill;
import BillManager.BillDetail;
import BillManager.BillManager;
import BookManager.BookManager;
import BookManager.LiteratureBook;
import BookManager.MangaBook;
import BookManager.PsychologyBook;

import java.util.Vector;

public class Statistics {
  //   public static void bookStorage() {
  //       System.out.println("Tong so luong sach con lai trong kho :" + BookManager.getList().size());
  //       BookManager.countBookByCategory();
  //   }

  //   public static void StaffManage() {
  //       System.out.println("Tong so nhan vien la :" + StaffManager.getList().size());
  //       StaffManager.countByJobStaff();
  //   }

  //   public static int totalRevenue() {
  //       return BillManager.totalBill();
  //   }

  //   public static int benefit() {
  //       return BillManager.totalBill() - StaffManager.totalSalary();
  //   }

  //  public static bookSale() {
  //     System.out.println("Tong so hoa don : "+BillManager.getList.size());
  //       int countMG = 0;
  //       Vector <BillDetail> Manga = new Vector<>();
  //       Vector <BillDetail> Literature = new Vector<>();
  //       Vector <BillDetail> Psychology = new Vector<>();
  //       int countLB = 0;
  //       int countPB = 0;
  //     for (Bill bill : BillManager.getList())
  //     {
  //       for (BillDetail book: bill.getList())
  //       {
  //           if (book.getCategory().equalsIgnoreCase("manga"))
  //           {
  //               countMG++;
  //               Manga.add(book);
  //           }
  //           else if (book.getCategory().equalsIgnoreCase("literature"))
  //           {
  //               countLB++;
  //               Literature.add(book);
  //           }
  //           else {
  //               countPB++;
  //               Psychology.add(book);
  //           }
  //       }
  //     } 
  //     // Cần làm logic các cuốn trùng nhau trong những bill khác nhau hiển thị tổng kết
  //     System.out.println("Tong so Manga :" + countMG);
  //     for(BillDetail book : Manga)
  //     {
  //       book.display();
  //     }
  //     System.out.println("Tong so Literature :"+countLB);
  //     for(BillDetail book : Literature)
  //     {
  //       book.display();
  //     }
  //     System.out.println("Tong so Psychology :"+countPB);
  //     for(BillDetail book : Psychology)
  //     {
  //       book.display();
  //     }
  //     System.out.println("Tong so sach ban ra : "+(countLB+countMG+countPB));
  //  }
  //  //Ý tưởng viết 1 hàm kiểm tra lớn hơn nhỏ cho date , 1 hàm sort dựa cái date 
  //  public static billDate()
  //  {
  //   for (Bill bill : BillManager.getList().sortDate())
  //   {
  //       bill.display();
  //   }
  //  }
}
