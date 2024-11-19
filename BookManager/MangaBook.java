package BookManager;
import inputValue.inputScanner;
import java.util.Vector;

class MangaBook extends Book
{
    private int volume;
    private static int count = 0;

    public MangaBook()
    {
        volume = 0;
        count++;
    }

    public MangaBook(String id, String name, String author, String publisher, int cost, int quantity, int volume)
    {
        super(id, name, author, publisher, cost, quantity);
        this.volume = volume;
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
        System.out.println("Nhap so tap: ");
        volume = inputScanner.input.nextInt();
    }

    // @Override public void display()

    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int newVolume)
    {
        volume = newVolume;
    }
}
