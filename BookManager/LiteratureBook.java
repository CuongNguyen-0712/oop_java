package BookManager;

import feature.*;

public class LiteratureBook extends Book {
    private String nation;
    private static int count = 0;

    public LiteratureBook() {
        nation = "";
        count++;
    }

    public LiteratureBook(String id, String name, String author, String publisher, int cost, int quantity, String nation) {
        super(id, name, author, publisher, cost, quantity);
        this.nation = nation;
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
        this.setID("L" + (int) (Math.random() * 1000));
        System.out.print("Tac pham thuoc ve quoc gia: ");
        nation = inputScanner.input.nextLine();
    }

    // @Override public void display()

    public String getNation() {
        return nation;
    }

    public void setNation(String newNation) {
        nation = newNation;
    }

    @Override
    public void display() {
        formatString.toStringCartory(this.getID(), this.getName(), this.getAuthor(), this.getPublisher(), this.getCost(), this.getQuantity(), this.getNation(), "Quốc gia", this.getIsBestSeller() ? "Có" : "Khồng");
    }
}
