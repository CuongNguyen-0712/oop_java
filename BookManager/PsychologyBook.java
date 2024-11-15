package BookManager;

class PsychologyBook extends Book
{
    private String audience;
    private static int count = 0;  //gán tạm bằng 0 nha

     public PyschologyBook()
    {
        audience = "";
    }

    public PyschologyBook(String id, String name, String author, String publisher, String audience)
    {
        super(id, name, author, publisher);
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
