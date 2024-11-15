package BookManager;

public class BookManager 
{
    private int choice;
    Vector<Book> listOfBook = new Vector<>();

    public BookManager()
    {
        listOfBook = new Vector<>();  
    }

    public BookManager(Vector<Book> listOfBook)
    {
        this.listOfBook = listOfBook;
    }

    public void add()
    {
        do
        {
            System.out.println("Chon loai sach ban muon them: 1. Sach Tam Ly Hoc  2. Manga   3. Sach Van Hoc");
            choice = rd.nextInt();

            switch(choice)
            {
                case 1: 
                    PyschologyBook pb = new PyschologyBook();
                    pb.add();
                    listOfBook.add(pb);
                    break;
                case 2: 
                    Manga mg = new Manga();
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
        rd.nextLine();
        System.out.println("Nhap ma sach muon xoa: ");
        String id = rd.nextLine();

        boolean flag = false;

        for(int i=0;i<listOfBook.size();i++)
        {
            if(listOfBook.get(i).getID().equalsIgnoreCase(id))
            {
                listOfBook.remove(i);
                flag = true;
            }
        }

        if(flag==false)
        {
            System.out.println("Khong tim thay sach!!!");
        }
    }
}
