import java.util.*;
import java.io.*;
import java.lang.*;

import BookManager.Book;

public class Main{

    public static void main(String[] args) {
        Book[] listBook = new Book[2];

        Book newBook = new Book();

        listBook[0] = newBook;

        listBook[0].display();
    }
}