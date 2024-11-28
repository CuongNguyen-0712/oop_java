package BookManager;

import feature.*;

public class PsychologyBook extends Book
{
    private String audience;
    private static int count = 0;

    public PsychologyBook()
    {
        audience = "";
        count++;
    }

    public PsychologyBook(String id, String name, String author, String publisher, int cost, int quantity, boolean isBestSeller, String audience)
    {
        super(id, name, author, publisher, cost, quantity, isBestSeller);
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
        this.setID("P" + (int) (Math.random() * 1000));
        System.out.print("Nhap doi tuong doc gia:");
        audience = inputScanner.input.nextLine();
    }
    
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
        formatString.toStringCartory(this.getID(), this.getName(), this.getAuthor(), this.getPublisher(), this.getCost(), this.getQuantity(), this.getAudience(), "Doi tuong", this.getIsBestSeller() ? "Có" : "Không");
    }
}
