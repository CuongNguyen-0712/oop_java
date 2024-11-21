package BookManager;

import IBook.IBookStore;
import inputValue.inputScanner;
import java.util.Vector;

public class BookManager 
{
    private Vector<Book> listOfBook = new Vector<>();
    public static int count = 0;

    public BookManager() 
    {
        listOfBook = new Vector<>();
    }

    public BookManager(Vector<Book> listOfBook)
    {
        this.listOfBook = listOfBook;
    }

    public Vector<Book> getListOfBook() 
    {
        return listOfBook;
    }

    public static String getId()
    {
        return "Book" + (count++);
    }

    public void add()
    {
        int choice;
        do
        {
            System.out.println("Chon loai sach ban muon them: 1. Sach Tam Ly Hoc  2. Manga   3. Sach Van Hoc");
            choice = inputScanner.input.nextInt();
            inputScanner.input.nextLine();

            switch(choice)
            {
                case 1: 
                    PsychologyBook pb = new PsychologyBook();
                    pb.add();
                    listOfBook.add(pb);
                    break;
                case 2: 
                    MangaBook mg = new MangaBook();
                    mg.add();
                    listOfBook.add(mg);
                    break;
                case 3:
                    LiteratureBook lb = new LiteratureBook();
                    lb.add();
                    listOfBook.add(lb);
                    break;
                default:
                    System.out.println("Lua chon khong hop le !!!\n");
            }

        }while(choice < 1 || choice > 3);
    }

    public void delete()
    {
        inputScanner.input.nextLine();
        System.out.println("Nhap ma sach muon xoa: ");
        String id = inputScanner.input.nextLine();

        boolean flag = false;

        for(int i = 0;i < listOfBook.size();i++)
        {
            if(listOfBook.get(i).getID().equalsIgnoreCase(id))
            {
                if(listOfBook.get(i) instanceof PsychologyBook)
                {
                    PsychologyBook.deCountBook();
                }
                else if(listOfBook.get(i) instanceof MangaBook)
                {
                    MangaBook.deCountBook();
                }
                else
                {
                    LiteratureBook.deCountBook();
                }
                listOfBook.remove(i);
                flag = true;
            }
        }

        if (flag == false) 
        {
            System.out.println("Khong tim thay sach!!!\n");
        }
    }

    public void change()
    {
        boolean flag = true;
        int choice;
        inputScanner.input.nextLine();
        System.out.println("Nhap ma sach muon sua: ");
        String id = inputScanner.input.nextLine();

        for(int i = 0;i < listOfBook.size();i++)
        {
            if(listOfBook.get(i).getID().equalsIgnoreCase(id))
            {
                flag = true;
                do {
                    System.out.println("Chon thong tin muon sua: ");
                    System.out.println("1. Ten sach");
                    System.out.println("2. Ten tac gia");
                    System.out.println("3. Nha xuat ban");
                    System.out.println("4. Gia");
                    System.out.println("5. So luong");
                    System.out.println("6. Best Seller");
                    System.out.println("7. Thong tin rieng cua sach");
                    System.out.println("8. Thoat");
                    choice = inputScanner.input.nextInt();
                    inputScanner.input.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println("Nhap ten sach: ");
                            String name = inputScanner.input.nextLine();
                            listOfBook.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Nhap ten tac gia: ");
                            String author = inputScanner.input.nextLine();
                            listOfBook.get(i).setAuthor(author);
                            break;
                        case 3:
                            System.out.println("Nhap nha xuat ban: ");
                            String publisher = inputScanner.input.nextLine();
                            listOfBook.get(i).setPublisher(publisher);
                            break;
                        case 4:
                            System.out.println("Nhap gia: ");
                            int cost = inputScanner.input.nextInt();
                            listOfBook.get(i).setCost(cost);
                            break;
                        case 5:
                            System.out.println("Nhap so luong: ");
                            int quantity = inputScanner.input.nextInt();
                            listOfBook.get(i).setQuantity(quantity);
                            break;
                        case 6:
                            System.out.println("Ban co muon giu vi tri Best Seller cua cuon sach nay khong? (y/n)");
                            String bestSeller = inputScanner.input.nextLine();
                            listOfBook.get(i).setIsBestSeller(bestSeller.equalsIgnoreCase("y"));
                            break;
                        case 7:
                            if (listOfBook.get(i) instanceof PsychologyBook) {
                                System.out.println("Nhap doi tuong doc gia: ");
                                String audience = inputScanner.input.nextLine();
                                ((PsychologyBook) listOfBook.get(i)).setAudience(audience);
                            }
                            else if(listOfBook.get(i) instanceof MangaBook)
                            {
                                System.out.println("Nhap so tap: ");
                                int volume = inputScanner.input.nextInt();
                                ((MangaBook) listOfBook.get(i)).setVolume(volume);
                            }
                            else
                            {
                                System.out.println("Tac pham thuoc ve quoc gia: ");
                                String nation = inputScanner.input.nextLine();
                                ((LiteratureBook) listOfBook.get(i)).setNation(nation);
                            }
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!!!\n");
                    }

                }while(choice != 8 );
                break;
            } else {
                flag = false;
            }
        }
        if (flag == false) {
            System.out.println("Ma sach khong hop le!!!\n");
        }
    }
    
    public void search()
    {
        inputScanner.input.nextLine();
        boolean flag = false;
        System.out.println("Nhap ma sach muon tim: ");
        String id = inputScanner.input.nextLine();

        for(int i = 0;i < listOfBook.size();i++)
        {
            if(listOfBook.get(i).getID().equalsIgnoreCase(id))
            {
                System.out.println("----THONG TIN SACH CAN TIM---\n");
                listOfBook.get(i).display();
                flag = true;
                break;
            }
        }

        if (flag == false) {
            System.out.println("Khong tim thay sach!!!\n");
        }
    }

    public int totalBook() {
        return listOfBook.size();
    }

    public void countBookByCategory() {
        System.out.println("So luong sach Tam Li Hoc: " + PsychologyBook.countBook());
        System.out.println("So luong MangaBook: " + MangaBook.countBook());
        System.out.println("So luong sach Van Hoc: " + LiteratureBook.countBook());
    }
}
