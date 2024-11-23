package feature;

import BookManager.Book;

import java.util.Vector;

public class formatString {
    public static int idWidth = 10;
    public static int nameWidth = 35;
    public static int authorWidth = 20;
    public static int publisherWidth = 20;
    public static int costWidth = 10;
    public static int quantityWidth = 10;
    public static int isBestSellerWidth = 15;

    public static void toStringBook(Vector<Book> books) {

        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+" + "-".repeat(isBestSellerWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|%-" + isBestSellerWidth + "s|\n";
        String formatTitle = "|%-10s|%-36s|%-22s|%-23s|%-12s|%-12s|%-18s|\n";

        System.out.println(border);
        System.out.printf(formatTitle, "ID", "Tên sách", "Tác giả", "Nhà xuất bản", "Giá tiền", "Số lượng", "Sách bán chạy");
        System.out.println(border);

        for (Book book : books) {
            System.out.printf(format, book.getID(), book.getName(), book.getAuthor(), book.getPublisher(), book.getCost(), book.getQuantity(), book.getIsBestSeller() ? "Có" : "Không");
        }
        System.out.println(border);
    }

    public static void toStringCartory(String id, String name, String author, String publisher, int cost, int quantity, String specialAttribute, String title, String isBestSeller) {
        int attributeSpecialWidth = 15;

        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+" + "-".repeat(attributeSpecialWidth) + "+" + "-".repeat(isBestSellerWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|%-" + attributeSpecialWidth + "s|%-" + isBestSellerWidth + "s|\n";
        String formatTitle = "|%-10s|%-36s|%-22s|%-23s|%-12s|%-12s|%-17s|%17s\n";

        System.out.println(border);
        System.out.printf(formatTitle, "ID", "Tên sách", "Tác giả", "Nhà xuất bản", "Giá tiền", "Số lượng", title, "Sách bán chạy");
        System.out.println(border);
        System.out.printf(format, id, name, author, publisher, cost, quantity, specialAttribute, isBestSeller);
        System.out.println(border);
    }
}
