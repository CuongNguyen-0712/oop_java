package BookManager;
import inputValue.inputScanner;

public class Book {
    String name;
    String id;

    public Book(){

    }

    public Book(String name, String id){
        this.name = name;
        this.id = id;
    }

    public void inputValue(){
        System.out.print("Nhập tên sách: ");
        name = inputScanner.input.nextLine();

        System.out.print("Nhập mã sách: ");
        id = inputScanner.input.nextLine();
    }

    public void display(){
        System.out.println("Ten sach: " + name);
        System.out.println("Ma sach: " + id);
    }
}
