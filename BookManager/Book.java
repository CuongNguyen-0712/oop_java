package BookManager;

import feature.inputScanner;
import IBook.IBookStore;

public class Book implements IBookStore {
    String name;
    String id;

    public Book() {

    }

    public Book(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public void add() {
        System.out.print("Nhap ten sach: ");
        name = inputScanner.input.nextLine();
        System.out.print("Nhap ma sach: ");
        id = inputScanner.input.nextLine();
    }

    @Override
    public void display() {
        System.out.println("Ten sach: " + name);
        System.out.println("Ma sach: " + id);
    }
}
