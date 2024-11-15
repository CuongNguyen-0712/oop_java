package BookManager;

class LiteratureBook extends Book
{
    private String nation;
    private static int count = 0;

    public LiteratureBook()
    {
        nation = "";
    }

    public LiteratureBook(String id, String name, String author, String publisher, int cost, int quantity, String nation)
    {
        super(id, name, author, publisher, cost, quantity);
        this.nation = nation;
    }

    @Override 
    public void add()
    {
        super.add();
        System.out.println("Tac pham thuoc ve quoc gia: ");
        nation = rd.nextLine();
    }

    public static void countBook()
    {
        count++;
    }

    public String getNation()
    {
        return nation;
    }

    public void setNation(String newNation)
    {
        nation = newNation;
    }
}
