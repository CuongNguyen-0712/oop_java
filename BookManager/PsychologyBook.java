package BookManager;

import feature.*;

public class PsychologyBook extends Book
{
    private String audience;
    private static int count = 0;  //gán tạm bằng 0 nha

    public PsychologyBook()
    {
        audience = "";
        count++;
    }

    public PsychologyBook(String id, String name, String author, String publisher, int cost, int quantity, String audience)
    {
        super(id, name, author, publisher, cost, quantity);
        this.audience = audience;
        count++;
    }

    public static int countBook()
    {
        return count;
    }

    public static void deCountBook()
    {
        count--;
    }

    @Override
    public void add()
    {
        super.add();
        System.out.print("Nhap doi tuong doc gia:");
        audience = inputScanner.input.nextLine();
    }

    // @Override public void display()

    public String getAudience()
    {
        return audience;
    }

    public void setAudience(String newAudience)
    {
        audience = newAudience;
    }

    @Override
    public void display() {
        formatString.toStringCartory(this.getID(), this.getName(), this.getAuthor(), this.getPublisher(), this.getCost(), this.getQuantity(), this.getAudience(), "Đối tượng", this.getIsBestSeller() ? "Có" : "Không");
    }
}
