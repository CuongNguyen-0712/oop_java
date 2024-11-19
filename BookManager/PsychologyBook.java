package BookManager;

import feature.inputScanner;

class PsychologyBook extends Book{
    public static int countBook;
    String newUpdate;

    public PsychologyBook() {}

    public PsychologyBook(String name, String id, String newUpdate) {
        super(name, id);
        this.newUpdate = newUpdate;
    }

    public void add() {
        super.add();
        System.out.print("Nhap chuc nang moi: ");
        newUpdate = inputScanner.input.nextLine();
    }

    public void display() {
        super.display();
        System.out.println("Chuc nang moi: " + newUpdate);
    }

    public static void increaseCountBook(int mount) {
        countBook += mount;
    }

    public static void decreaseCountBook(int mount) {
        countBook -= mount;
    }
}
