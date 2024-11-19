package feature;

import BookManager.Book;

import java.util.Vector;

public class formatString {
    public static void toStringBook(Vector<Book> books){
        int idWidth = 10;
        int nameWidth = 30;

        String format = "| %-"+idWidth+"s | %-"+nameWidth+"s |\n";
        System.out.println("+------------+--------------------------------+");
        System.out.printf("| %-"+idWidth+"s | %-"+nameWidth+"s |\n", "ID", "Name");
        System.out.println("+------------+--------------------------------+");

        for(Book book : books){
            System.out.printf(format, book.getId(), book.getName());
        }

        System.out.println("+------------+--------------------------------+");
    }
}
