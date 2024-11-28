package feature;

import BookManager.Book;
import StaffManager.*;

import java.util.Vector;

public class formatString {
    static int idWidth = 10;
    static int nameWidth = 40;
    static int authorWidth = 20;
    static int publisherWidth = 20;
    static int costWidth = 15;
    static int quantityWidth = 10;
    static int isBestSellerWidth = 15;
    static int salaryWidth = 15;
    static int privateAttributeWidth = 15;


    public static void toStringBook(Vector<Book> books) {

        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+" + "-".repeat(isBestSellerWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|%-" + isBestSellerWidth + "s|\n";

        System.out.println(border);
        System.out.printf(format, "ID", "Ten sach", "Tac gia", "Nha xuat ban", "Gia tien", "So luong", "Sach ban chay");
        System.out.println(border);

        for (Book book : books) {
            System.out.printf(format, book.getID(), book.getName(), book.getAuthor(), book.getPublisher(), book.getCost() + ".000VND", book.getQuantity(), book.getIsBestSeller() ? "Co" : "Khong");
        }
        System.out.println(border);
    }

    public static void toStringCartory(String id, String name, String author, String publisher, int cost, int quantity, String specialAttribute, String title, String isBestSeller) {
        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+" + "-".repeat(privateAttributeWidth) + "+" + "-".repeat(isBestSellerWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|%-" + privateAttributeWidth + "s|%-" + isBestSellerWidth + "s|\n";

        System.out.println(border);
        System.out.printf(format, "ID", "Ten sach", "Tac gia", "Nha xuat ban", "Gia tien", "So luong", title, "Sach ban chay");
        System.out.println(border);
        System.out.printf(format, id, name, author, publisher, cost + ".000VND", quantity, specialAttribute, isBestSeller);
        System.out.println(border);
        System.out.print("\n");
    }

    public static void toStringStaff(Vector<Staff> staffs) {
        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(salaryWidth) + "+";
        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + salaryWidth + "s|\n";

        System.out.println(border);
        System.out.printf(format, "ID", "Ten nhan vien", "Luong");
        System.out.println(border);
        for (Staff staff : staffs) {
            System.out.printf(format, staff.getID(), staff.getName(), staff.getSalary() + "000VND");
        }
        System.out.println(border);
    }

    public static void toStringTypeStaff(String id, String name, int salary, String privateAttribute, String title) {
        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(salaryWidth) + "+" + "-".repeat(privateAttributeWidth) + "+";
        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + salaryWidth + "s|%-" + privateAttributeWidth + "s|\n";

        System.out.println(border);
        System.out.printf(format, "ID", "Ten nhan vien", "Luong", title);
        System.out.println(border);
        System.out.printf(format, id, name, salary + "000VND", privateAttribute);
        System.out.println(border);
        System.out.print("\n");
    }
}
