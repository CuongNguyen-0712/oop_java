package BookManager;

import feature.inputScanner;

class LiteratureBook extends Book{
    public static int countBook = 0;

    String special;

    public LiteratureBook(){}

    public LiteratureBook(String name, String id, String special) {
        super(name, id);
        this.special = special;
    }

    @Override
    public void add() {
        super.add();
        System.out.print("Nhap chuc nang: ");
        special = inputScanner.input.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Chuc nang: " + special);
    }

    public static void increaseCountBook(int mount) {
        countBook += mount;
    }

    public static void decreaseCountBook(int mount) {
        countBook -= mount;
    }
}
