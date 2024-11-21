package feature;

import BookManager.Book;

import java.util.Vector;

public class formatString {
    public static void toStringBook(Vector<Book> books) {
        int idWidth = 10;
        int nameWidth = 35;
        int authorWidth = 20;
        int publisherWidth = 20;
        int costWidth = 10;
        int quantityWidth = 10;

        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|\n";
        String formatTitle = "|%-10s|%-36s|%-22s|%-23s|%-12s|%-12s|\n";

        System.out.println(border);
        System.out.printf(formatTitle,"ID", "Tên sách", "Tác giả", "Nhà xuất bản", "Giá tiền", "Số lượng");
        System.out.println(border);

        for (Book book : books) {
            System.out.printf(format, book.getID(), book.getName(), book.getAuthor(), book.getPublisher(), book.getCost(), book.getQuantity());
        }
        System.out.println(border);
    }

    public static void toStringCartory(String id, String name, String author, String publisher, int cost, int quantity, String specialAttribute, String title) {
        int idWidth = 10;
        int nameWidth = 35;
        int authorWidth = 20;
        int publisherWidth = 20;
        int costWidth = 10;
        int quantityWidth = 10;
        int attributeSpecialWidth = 15;

        String border = "+" + "-".repeat(idWidth) + "+" + "-".repeat(nameWidth) + "+" + "-".repeat(authorWidth) + "+" + "-".repeat(publisherWidth) + "+" + "-".repeat(costWidth) + "+" + "-".repeat(quantityWidth) + "+" + "-".repeat(attributeSpecialWidth) + "+";

        String format = "|%-" + idWidth + "s|%-" + nameWidth + "s|%-" + authorWidth + "s|%-" + publisherWidth + "s|%-" + costWidth + "s|%-" + quantityWidth + "s|%-" + attributeSpecialWidth + "s|\n";
        String formatTitle = "|%-10s|%-36s|%-22s|%-23s|%-12s|%-12s|%-17s|\n";

        System.out.println(border);
        System.out.printf(formatTitle,"ID", "Tên sách", "Tác giả", "Nhà xuất bản", "Giá tiền", "Số lượng",title);
        System.out.println(border);
        System.out.printf(format, id, name, author, publisher, cost, quantity, specialAttribute);
        System.out.println(border);
    }
}
