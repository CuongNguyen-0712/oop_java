package BookManager;
import inputValue.inputScanner;

public class Book 
{
    private String id, name, author, publisher;
    private int cost, quantity;
    String bestSeller;
    boolean isBestSeller;

    public Book()
    {
        id = "";
        name = "";
        author = "";
        publisher = "";
        cost = 0;
        quantity = 0;
    }

    public Book(String id, String name, String author, String publisher, int cost, int quantity)
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void add()
    {
        System.out.print("Nhap ma sach: "); 
        id = inputScanner.input.nextLine();

        System.out.print("Nhap ten sach: ");
        name = inputScanner.input.nextLine();

        System.out.println("Nhap ten tac gia: ");
        author = inputScanner.input.nextLine();

        System.out.println("Nhap nha xuat ban: ");
        publisher = inputScanner.input.nextLine();

        System.out.println("Nhap gia: ");
        cost = inputScanner.input.nextInt();

        System.out.println("Nhap so luong: ");
        quantity = inputScanner.input.nextInt();

        inputScanner.input.nextLine();

        System.out.println("Sach nay co phai bestseller khong? (y/n)");
        bestSeller = inputScanner.input.nextLine();
        
        isBestSeller = bestSeller.equalsIgnoreCase("y");
    }

    //  public void display()

    public String getID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public int getCost()
    {
        return cost;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setAuthor(String newAuthor)
    {
        author = newAuthor;
    }

    public void setPublisher(String newPublisher)
    {
        publisher = newPublisher;
    }

    public void setCost(int newCost)
    {
        cost = newCost;
    }

    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }

    public void setIsBestSeller(boolean newIsBestSeller)
    {
        isBestSeller = newIsBestSeller;
    }
}
