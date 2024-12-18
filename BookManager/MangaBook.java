package BookManager;

import feature.*;

public class MangaBook extends Book {
    private int volume;
    private static int count = 0;

    public MangaBook() {
        volume = 0;
        count++;
    }

    public MangaBook(String id, String name, String author, String publisher, int cost, int quantity,
            boolean isBestSeller, int volume) {
        super(id, name, author, publisher, cost, quantity, isBestSeller);
        this.volume = volume;
        count++;
    }

    public static int countBook() {
        return count;
    }

    public static void deCountBook() {
        count--;
    }

    @Override
    public void add() {
        super.add();
        this.setID("M" + (int) (Math.random() * 1000));
        System.out.print("Nhap so tap: ");
        while (true) {
            try {
                volume = Integer.parseInt(inputScanner.input.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhap so nguyen !\n");
            }
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int newVolume) {
        volume = newVolume;
    }

    @Override
    public void display() {
        formatString.toStringCartory(this.getID(), this.getName(), this.getAuthor(), this.getPublisher(),
                this.getCost(), this.getQuantity(), String.valueOf(getVolume()), "So tap",
                this.getIsBestSeller() ? "Có" : "Không");
    }
}
