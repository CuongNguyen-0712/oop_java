package BookManager;

import feature.inputScanner;

class MangaBook extends Book{
    public static int countBook;
    String another;

    public MangaBook(){

    }

    public MangaBook(String name, String id, String another) {
        super(name, id);
        this.another = another;
    }

    @Override
    public void add(){
        super.add();
        System.out.print("Nhap nha xuat ban: ");
        another = inputScanner.input.nextLine();
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Nha xuat ban: " + another);
    }

    public static void increaseCountBook(int mount) {
        countBook += mount;
    }

    public static void decreaseCountBook(int mount) {
        countBook -= mount;
    }
}
