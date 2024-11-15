package BookManager;

class PsychologyBook extends Book
{
    private String audience;
    private static int count = 0;  //gán tạm bằng 0 nha

     public PsychologyBook()
    {
        audience = "";
    }

    public PsychologyBook(String id, String name, String author, String publisher, int cost, int quantity, String audience)
    {
        super(id, name, author, publisher, cost, quantity);
        this.audience = audience;
    }

    @Override
    public void add()
    {
        super.add();
        System.out.println("Nhap doi tuong doc gia:");
        audience = rd.nextLine();
       
    }

    // @Override public void display()

    public static void countBook()
    {
        count++;
    }

    public String getAudience()
    {
        return audience;
    }

    public void setAudience(String newAudience)
    {
        audience = newAudience;
    }
}
