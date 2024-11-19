package BookManager;
import inputValue.inputScanner;

class PsychologyBook extends Book
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
        System.out.println("Nhap doi tuong doc gia:");
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
}
