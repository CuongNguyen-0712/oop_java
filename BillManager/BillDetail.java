package BillManager;

import feature.*;
import BookManager.*;

import java.awt.desktop.SystemSleepEvent;

public class BillDetail {
    private String idBook,nameBook,category;
    private int costBook, quantityBook;

    public BillDetail() {
        this.nameBook = "";
        this.costBook = 0;
        this.quantityBook = 0;
    }

    public BillDetail(String nameBook, int costBook, int quantityBook) {
        this.nameBook = nameBook;
        this.costBook = costBook;
        this.quantityBook = quantityBook;
    }

    public BillDetail(Book book)
    {
        idBook = book.getID();
        nameBook = book.getName();
        costBook = book.getCost();
        if (book instanceof MangaBook)
        category = "manga";
        else if (book instanceof LiteratureBook)
        category = "literature";
        else 
        category = "psychology";
    }

    // Get/Set nameBook
    public String getNameBook() {
        return this.nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    // Get/Set costBook
    public int getCostBook() {
        return this.costBook;
    }

    public void setCostBook(int costBook) {
        this.costBook = costBook;
    }

    // Get/Set quantityBook
    public int getQuantityBook() {
        return this.quantityBook;
    }

    public void setQuantityBook(int quantityBook) {
        this.quantityBook = quantityBook;
    }

    // Tính calcCost
    // Có thể tính cho 1 quyển nhiều thể loại và 1 quyển 1 thể loai
    public int calcCost() {
        return costBook * quantityBook;
    }

    public String getCategory(){
        return category;
    }

    public String getID()
    {
        return idBook;
    }

    // Phương thức nhập
    public void add() {
        BookManager.display();

        Book bookBill = null;
        while (true) {
            System.out.println("Nhap ten sach: ");
            String value = inputScanner.input.nextLine();
            boolean flag = false;
            for (Book book : BookManager.getList()) {
                if (book.getName().equalsIgnoreCase(value)) {
                    nameBook = value;
                    bookBill = book;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Khong tim thay sach, vui long nhap lai! \n");
            }
            else{
                break;
            }
        }

        costBook = bookBill.getCost();

        System.out.println("So luong sach con lai: " + bookBill.getQuantity());
        System.out.println("Nhap so luong: ");
        while(true) {
            try {
                int value = Integer.parseInt(inputScanner.input.nextLine());
                if(value < 0 || value > bookBill.getQuantity()){
                    System.out.println("Gia tri khong hop le, vui long nhap lai ! \n");
                }
                else {
                    quantityBook = value;
                    bookBill.setQuantity(bookBill.getQuantity() - value);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai ! \n");
            }
        }

    }

    // Phương thức xuất
    public void display() {
        System.out.println("Ten sach: " + nameBook);
        System.out.println("Gia: " + costBook + ".000 VND");

        System.out.println("So Luong: " + quantityBook);
        System.out.println("Tong: " + calcCost() + ".000 VND");
    }

}


