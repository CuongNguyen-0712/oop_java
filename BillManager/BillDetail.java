package BillManager;

import feature.*;
import BookManager.*;

public class BillDetail {
    private String idBook, nameBook;
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

    public String getIDBook() {
        return this.idBook;
    }

    public String getNameBook() {
        return this.nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getCostBook() {
        return this.costBook;
    }

    public int getQuantityBook() {
        return this.quantityBook;
    }

    public void setQuantityBook(int quantityBook) {
        this.quantityBook = quantityBook;
    }

    public int calcCost() {
        return costBook * quantityBook;
    }

    public void add() {
        BookManager.display();

        Book bookBill = null;
        while (true) {
            System.out.print("Nhap ten sach: ");
            String value = inputScanner.input.nextLine();
            boolean flag = false;
            for (Book book : BookManager.getList()) {
                if (book.getName().equalsIgnoreCase(value)) {
                    nameBook = book.getName();
                    bookBill = book;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Khong tim thay sach, vui long nhap lai! \n");
            } else if (bookBill.getQuantity() == 0) {
                System.out.println("Sach da het, vui long chon sach moi!\n");
            } else {
                break;
            }
        }

        idBook = bookBill.getID();
        costBook = bookBill.getCost();

        System.out.println("So luong sach con lai: " + bookBill.getQuantity());
        System.out.print("Nhap so luong: ");
        while (true) {
            try {
                int value = Integer.parseInt(inputScanner.input.nextLine());
                if (value <= 0 || value > bookBill.getQuantity()) {
                    System.out.println("Gia tri khong hop le, vui long nhap lai ! \n");
                } else {
                    quantityBook = value;
                    bookBill.setQuantity(bookBill.getQuantity() - value);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai ! \n");
            }
        }

    }

    public void display() {
        System.out.println("-----------------------------");
        System.out.println("Ten sach: " + nameBook);
        System.out.println("Gia: " + costBook + ".000 VND");
        System.out.println("So Luong: " + quantityBook);
        System.out.println("Tong: " + calcCost() + ".000 VND");
        System.out.println("-----------------------------");
    }
}


