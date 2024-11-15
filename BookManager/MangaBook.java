package BookManager;

class MangaBook extends Book
{
    private int volume;
    private static int count = 0;

    public Manga()
    {
        volume = 0;
    }

    public Manga(String id, String name, String author, String publisher, int cost, int quantity, int volume)
    {
        super(id, name, author, publisher, cost, quantity);
        this.volume = volume;
    }
    
    @Override 
    public void add()
    {
        super.add();
        System.out.println("Nhap so tap: ");
        volume = rd.nextInt();
    }

    // @Override public void display()
    
    public static void countBook()
    {
        count++;
    }

    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int newVolume)
    {
        volume = newVolume;
    }
}
